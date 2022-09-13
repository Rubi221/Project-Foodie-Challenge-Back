package com.example.foodiechallengeback.repository;

import com.example.foodiechallengeback.model.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPublicacionRepository  extends JpaRepository<Publicacion, Long> {

    @Query("SELECT p " +
            "FROM Publicacion p " +
            "WHERE p.idSeccionForo = :idSeccion " +
            "OR p.idUsuario = :idUsuario")
    List<Publicacion> findAllByIdSeccionOrIdUsuario(Long idSeccion, Long idUsuario);
}
