package com.example.foodiechallengeback.repository;

import com.example.foodiechallengeback.model.InscripcionReto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositorio para la tabla InscripcionReto
 * @author Rubi Utima
 */
@Repository
public interface IInscripcionRetoRepository extends JpaRepository<InscripcionReto, Long> {
    @Query("SELECT i " +
            "FROM InscripcionReto i " +
            "WHERE i.idMiembro = :idMiembro " +
            "AND i.idReto = :idReto ")
    InscripcionReto findInscripcion(Long idReto, Long idMiembro);

    List<InscripcionReto> findAllByIdReto(Long idReto);
}
