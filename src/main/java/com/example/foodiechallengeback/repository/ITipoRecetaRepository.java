package com.example.foodiechallengeback.repository;

import com.example.foodiechallengeback.model.TipoReceta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoRecetaRepository extends JpaRepository<TipoReceta, Long> {
}
