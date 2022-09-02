package com.example.foodiechallengeback.repository;

import com.example.foodiechallengeback.model.Chef;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la tabla Chef
 * @author Rubi Utima
 */
@Repository
public interface IChefRepository extends JpaRepository<Chef, Long> {
}
