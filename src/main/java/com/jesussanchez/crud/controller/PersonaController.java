package com.jesussanchez.crud.controller;

import com.jesussanchez.crud.model.PersonaModel;
import com.jesussanchez.crud.services.PersonaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/persona")
public class PersonaController {
    @Autowired
    private PersonaServices personaServices;

    @PostMapping("/save")
    private ResponseEntity<PersonaModel> save(@RequestBody PersonaModel personaModel) {
        PersonaModel personaModel1 = personaServices.create(personaModel);
        try {
            return ResponseEntity.created(new URI("/api/persona/save" + personaModel1.getId())).body(personaModel1);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping
    private ResponseEntity<List<PersonaModel>> getAllPersonas() {
        return ResponseEntity.ok(personaServices.getAllPersonas());
    }

    @DeleteMapping
    private ResponseEntity<Void> deletePersona(@RequestBody PersonaModel personaModel) {
        personaServices.delete(personaModel);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "{id}")
    private ResponseEntity<Optional<PersonaModel>> getPersonaById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(personaServices.findById(id));
    }

}
