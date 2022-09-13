package com.example.foodiechallengeback.repository;

import com.example.foodiechallengeback.model.Subcategoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISubcategoriaRepository extends JpaRepository<Subcategoria, Long> {
}
