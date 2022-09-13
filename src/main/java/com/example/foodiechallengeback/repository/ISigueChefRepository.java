package com.example.foodiechallengeback.repository;

import com.example.foodiechallengeback.model.SigueChef;
import com.example.foodiechallengeback.service.impl.SigueChefServiceImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISigueChefRepository extends JpaRepository<SigueChef, Long> {

    @Query("SELECT sc.chef.id FROM SigueChef sc " +
            "WHERE sc.chef.id= :aIdMiembro ")
    List<Long> findAllChef(Long aIdMiembro);

    @Query("SELECT sc.miembro.id FROM SigueChef sc " +
            "WHERE sc.miembro.id= :aIdChef ")
    List<Long> findAllMiembro(Long aIdChef);

}
