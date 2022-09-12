package com.example.foodiechallengeback.repository;

import com.example.foodiechallengeback.model.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMensajeRepository  extends JpaRepository<Mensaje, Long> {
    @Query("SELECT m " +
            "FROM Mensaje m " +
            "WHERE m.idPublicacion = :idPublicacion " +
            "OR m.idReto = :idReto ")
    List<Mensaje> findAllByIdPubliacionOrIdReto(Long idPublicacion, Long idReto);

    @Query("SELECT m " +
            "FROM Mensaje m " +
            "WHERE m.idPadre = :idPadre ")
    List<Mensaje> findAllByIdPadre(Long idPadre);
}
