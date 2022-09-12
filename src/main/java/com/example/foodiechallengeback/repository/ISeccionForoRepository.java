package com.example.foodiechallengeback.repository;

import com.example.foodiechallengeback.model.SeccionForo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la tabla SeccionForo
 * @author Rubi Utima
 */
@Repository
public interface ISeccionForoRepository extends JpaRepository<SeccionForo, Long> {
}