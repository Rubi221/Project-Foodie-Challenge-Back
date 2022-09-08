package com.example.foodiechallengeback.repository;

import com.example.foodiechallengeback.model.Miembro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la tabla Miembro
 * @author Rubi Utima
 */
@Repository
public interface IMiembroRepository extends JpaRepository<Miembro, Long> {

    Miembro findByIdUsuario(Long idUsuario);
}
