package com.example.foodiechallengeback.repository;

import com.example.foodiechallengeback.model.DetalleInscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la tabla DetalleInscripcion
 * @author Rubi Utima
 */
@Repository
public interface IDetalleInscripcionRepository extends JpaRepository<DetalleInscripcion, Long> {

    DetalleInscripcion findByIdInscripcionReto(Long idInscripcion);
}
