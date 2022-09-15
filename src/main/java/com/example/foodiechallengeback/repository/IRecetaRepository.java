package com.example.foodiechallengeback.repository;

import com.example.foodiechallengeback.model.Receta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRecetaRepository extends JpaRepository<Receta, Long> {

    List<Receta> findAllByIdTipoReceta(Long idTipoReceta);
}
