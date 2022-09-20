package com.example.foodiechallengeback.repository;

import com.example.foodiechallengeback.model.InscripcionReto;
import com.example.foodiechallengeback.model.Reto;
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
            "WHERE i.idUsuario = :idUsuario " +
            "AND i.idReto = :idReto ")
    InscripcionReto findInscripcion(Long idReto, Long idUsuario);

    List<InscripcionReto> findAllByIdReto(Long idReto);

    List<InscripcionReto> findInscripcionRetoByIdUsuario(Long idUsuario);

    @Query("SELECT r " +
            "FROM Reto r, InscripcionReto i " +
            "WHERE i.idReto = r.id  " +
            "AND i.idUsuario =:idUsuario " +
            "AND SYSDATE() <= r.fechaFin ")
    List<Reto> findAllInscritos(Long idUsuario);
}
