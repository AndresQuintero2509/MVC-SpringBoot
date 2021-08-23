package com.jesussanchez.crud.repository;

import com.jesussanchez.crud.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
