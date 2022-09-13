package com.example.foodiechallengeback.service.interfaces;

import com.example.foodiechallengeback.dto.SigueChefDTO;
import com.example.foodiechallengeback.model.SigueChef;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public interface ISigueChefService {

    List<Long> findAllChef(Long idUsuarioMiembro);

    List<Long> findAllMiembro(Long idUsuarioChef);
    @Transactional
    SigueChef createSeguidor(SigueChefDTO sigueChefDTO);

    @Transactional
    void deleteSeguidor(Long aId);
}
