package com.example.foodiechallengeback.repository;

import com.example.foodiechallengeback.model.Reto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositorio para la tabla Reto
 * @author Rubi Utima
 */
@Repository
public interface IRetoRepository extends JpaRepository<Reto, Long> {
    @Query("SELECT r " +
            "FROM Reto r " +
            "WHERE SYSDATE()  >= r.fechaInicio " +
            "AND SYSDATE() <= r.fechaFin " +
            "ORDER BY r.fechaInicio desc")
    List<Reto> findAllAbiertas();

    List<Reto> findAllByIdCategoria(Long idCategoria);

    @Query("SELECT r " +
            "FROM Reto r " +
            "WHERE r.idUsuario =:idUsuario " +
            "AND SYSDATE() <= r.fechaFin " +
            "ORDER BY r.fechaInicio desc ")
    List<Reto> findAllCreadosPor(Long idUsuario);

    @Query("SELECT r " +
            "FROM Reto r " +
            "WHERE SYSDATE()  >= r.fechaInicio " +
            "AND SYSDATE() <= r.fechaFin ")
    List<Reto> findAllInscritos(Long idUsuario);

}
