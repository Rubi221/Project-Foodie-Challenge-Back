package com.example.foodiechallengeback.repository;

import com.example.foodiechallengeback.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoriaRepository  extends JpaRepository<Categoria, Long> {
}
