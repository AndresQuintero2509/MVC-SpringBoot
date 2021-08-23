package com.jesussanchez.crud.repository;

import com.jesussanchez.crud.model.PersonaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<PersonaModel, Long> {
}
