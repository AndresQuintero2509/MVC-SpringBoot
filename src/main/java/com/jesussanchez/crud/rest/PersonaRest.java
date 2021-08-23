package com.jesussanchez.crud.rest;

import com.jesussanchez.crud.model.Persona;
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
public class PersonaRest {
    @Autowired
    private PersonaServices personaServices;

    @PostMapping("/save")
    private ResponseEntity<Persona> save(@RequestBody Persona persona) {
        Persona persona1 = personaServices.create(persona);
        try {
            return ResponseEntity.created(new URI("/api/persona/save" + persona1.getId())).body(persona1);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping
    private ResponseEntity<List<Persona>> getAllPersonas() {
        return ResponseEntity.ok(personaServices.getAllPersonas());
    }

    @DeleteMapping
    private ResponseEntity<Void> deletePersona(@RequestBody Persona persona) {
        personaServices.delete(persona);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "{id}")
    private ResponseEntity<Optional<Persona>> getPersonaById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(personaServices.findById(id));
    }

}
