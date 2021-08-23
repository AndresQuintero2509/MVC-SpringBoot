package com.jesussanchez.crud.services;

import com.jesussanchez.crud.model.Persona;
import com.jesussanchez.crud.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServices {
    @Autowired
    private PersonaRepository personaRepository;

    public Persona create(Persona persona) {
        return personaRepository.save(persona);
    }

    public List<Persona> getAllPersonas() {
        return personaRepository.findAll();
    }

    public void delete(Persona persona) {
        personaRepository.delete(persona);
    }

    public Optional<Persona> findById(Long id) {
        return personaRepository.findById(id);
    }

}
