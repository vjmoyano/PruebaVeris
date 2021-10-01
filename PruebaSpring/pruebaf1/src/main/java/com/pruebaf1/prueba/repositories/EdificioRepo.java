package com.pruebaf1.prueba.repositories;

import com.pruebaf1.prueba.entities.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EdificioRepo extends JpaRepository<Edificio, Integer> {
}
