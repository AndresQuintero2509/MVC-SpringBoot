package com.jesussanchez.crud.services;

import com.jesussanchez.crud.model.PersonaModel;
import com.jesussanchez.crud.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServices {
    @Autowired
    private PersonaRepository personaRepository;

    public PersonaModel create(PersonaModel personaModel) {
        return personaRepository.save(personaModel);
    }

    public List<PersonaModel> getAllPersonas() {
        return personaRepository.findAll();
    }

    public void delete(PersonaModel personaModel) {
        personaRepository.delete(personaModel);
    }

    public Optional<PersonaModel> findById(Long id) {
        return personaRepository.findById(id);
    }

}
