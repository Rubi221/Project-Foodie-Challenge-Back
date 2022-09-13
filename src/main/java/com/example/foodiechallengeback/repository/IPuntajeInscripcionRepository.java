package com.example.foodiechallengeback.repository;

import com.example.foodiechallengeback.model.PuntajeInscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPuntajeInscripcionRepository extends JpaRepository<PuntajeInscripcion, Long> {
}
