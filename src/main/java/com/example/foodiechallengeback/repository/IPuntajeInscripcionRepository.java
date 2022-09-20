package com.example.foodiechallengeback.repository;

import com.example.foodiechallengeback.model.PuntajeInscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IPuntajeInscripcionRepository extends JpaRepository<PuntajeInscripcion, Long> {

    @Query("SELECT AVG(p.puntaje) " +
            "FROM PuntajeInscripcion p " +
            "WHERE p.idDetalle = :idDetalle ")
    Long sumAllPuntajes(Long idDetalle);

    @Query("SELECT p " +
            "FROM PuntajeInscripcion p " +
            "WHERE p.idDetalle = :idDetalle " +
            "AND p.idUsuario =:idUsuario ")
    PuntajeInscripcion findByIdDetalle(Long idDetalle, Long idUsuario);
}
