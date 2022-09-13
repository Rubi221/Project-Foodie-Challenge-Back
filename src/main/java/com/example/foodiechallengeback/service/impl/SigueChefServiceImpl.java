package com.example.foodiechallengeback.service.impl;

import com.example.foodiechallengeback.dto.SigueChefDTO;
import com.example.foodiechallengeback.mapper.SigueChefMapper;
import com.example.foodiechallengeback.model.SigueChef;
import com.example.foodiechallengeback.repository.ISigueChefRepository;
import com.example.foodiechallengeback.service.interfaces.ISigueChefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class SigueChefServiceImpl implements ISigueChefService {

    private ISigueChefRepository sigueChefRepository;


    //Crea un nuevo Seguidor
    @Override
    @Transactional
    public SigueChef createSeguidor(SigueChefDTO sigueChefDTO){
        var seguidor = SigueChefMapper.INSTANCE.toSigueChef(sigueChefDTO);
        return this.sigueChefRepository.save(seguidor);
    }

    //Obtiene la lista de todos los miembros que siguen a un chef
    @Override
    public List<Long> findAllChef(Long aIdMiembro){
        return this.sigueChefRepository.findAllChef(aIdMiembro);
    }

    //Obtiene la lista de todos los chefs que son seguidos por un miembro
    @Override
    public List<Long> findAllMiembro(Long aIdChef){
        return this.sigueChefRepository.findAllMiembro(aIdChef);
    }

    //Elimina un Seguidor
    @Override
    @Transactional
    public void deleteSeguidor(Long aId) {
        var sigueChefBD = sigueChefRepository.findById(aId).orElse(null);
        this.sigueChefRepository.deleteById(sigueChefBD.getId());
    }

    //Inyecciones
    @Autowired
    public void setSigueChefRepository(ISigueChefRepository sigueChefRepository) {
        this.sigueChefRepository = sigueChefRepository;
    }
}
