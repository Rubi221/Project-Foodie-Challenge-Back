package com.example.foodiechallengeback.repository;

import com.example.foodiechallengeback.model.Receta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRecetaRepository extends JpaRepository<Receta, Long> {

}
