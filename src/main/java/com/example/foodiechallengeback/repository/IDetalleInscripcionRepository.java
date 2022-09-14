package com.example.foodiechallengeback.repository;

import com.example.foodiechallengeback.model.DetalleInscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositorio para la tabla DetalleInscripcion
 * @author Rubi Utima
 */
@Repository
public interface IDetalleInscripcionRepository extends JpaRepository<DetalleInscripcion, Long> {

    DetalleInscripcion findByIdInscripcionReto(Long idInscripcion);

    @Query("SELECT d " +
            "FROM DetalleInscripcion d " +
            "WHERE d.inscripcionReto.idReto = :idReto ")
    List<DetalleInscripcion> findAllDetallesByIdReto(Long idReto);
}
