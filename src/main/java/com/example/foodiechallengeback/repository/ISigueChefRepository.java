package com.example.foodiechallengeback.repository;

import com.example.foodiechallengeback.model.SigueChef;
import com.example.foodiechallengeback.service.impl.SigueChefServiceImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISigueChefRepository extends JpaRepository<SigueChef, Long> {

    @Query("SELECT sc.usuarioChef.id " +
            "FROM SigueChef sc " +
            "WHERE sc.usuarioMiembro.id = :idUsuarioMiembro ")
    List<Long> findAllChef(Long idUsuarioMiembro);

    @Query("SELECT sc.usuarioMiembro.id " +
            "FROM SigueChef sc " +
            "WHERE sc.usuarioChef.id= :idUsuarioChef ")
    List<Long> findAllMiembro(Long idUsuarioChef);

}
