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
            "AND SYSDATE() <= r.fechaFin ")
    List<Reto> findAllAbiertas();

    List<Reto> findAllByIdCategoria(Long idCategoria);


}
