package com.example.foodiechallengeback.repository;

import com.example.foodiechallengeback.model.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMensajeRepository  extends JpaRepository<Mensaje, Long> {

}
