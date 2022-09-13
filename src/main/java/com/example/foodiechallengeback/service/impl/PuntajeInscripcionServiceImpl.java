package com.example.foodiechallengeback.service.impl;

import com.example.foodiechallengeback.dto.PuntajeInscripcionDTO;
import com.example.foodiechallengeback.mapper.PuntajeInscripcionMapper;
import com.example.foodiechallengeback.model.PuntajeInscripcion;
import com.example.foodiechallengeback.repository.IPuntajeInscripcionRepository;
import com.example.foodiechallengeback.service.interfaces.IPuntajeInscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PuntajeInscripcionServiceImpl implements IPuntajeInscripcionService {

    private IPuntajeInscripcionRepository puntajeInscripcionRepository;

    //Obtiene todos los puntajes
    @Override
    public List<PuntajeInscripcion> findAllPuntajes(){
        return this.puntajeInscripcionRepository.findAll();
    }


    //Crea un nuevo Seguidor
    @Override
    @Transactional
    public PuntajeInscripcion createPuntaje(PuntajeInscripcionDTO puntajeInscripcionDTO){
        var puntaje = PuntajeInscripcionMapper.INSTANCE.toPuntajeInscripcion(puntajeInscripcionDTO);
        return this.puntajeInscripcionRepository.save(puntaje);
    }

    //Inyecciones
    @Autowired
    public void setPuntajeInscripcionRepository(IPuntajeInscripcionRepository puntajeInscripcionRepository){
        this.puntajeInscripcionRepository = puntajeInscripcionRepository;
    }
}
