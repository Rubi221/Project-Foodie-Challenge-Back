package com.example.foodiechallengeback.repository;

import com.example.foodiechallengeback.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IComentarioRepository extends JpaRepository<Comentario, Long> {
    @Query("SELECT m " +
            "FROM Comentario m " +
            "WHERE m.idPublicacion = :idPublicacion " +
            "OR m.idReto = :idReto " +
            "ORDER BY m.fecha DESC ")
    List<Comentario> findAllByIdPubliacionOrIdReto(Long idPublicacion, Long idReto);

    @Query("SELECT m " +
            "FROM Comentario m " +
            "WHERE m.idPadre = :idPadre ")
    List<Comentario> findAllByIdPadre(Long idPadre);
}
