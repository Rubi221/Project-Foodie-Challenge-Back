package com.example.foodiechallengeback.repository;

import com.example.foodiechallengeback.model.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPublicacionRepository  extends JpaRepository<Publicacion, Long> {
}
