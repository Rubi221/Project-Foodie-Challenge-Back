package com.example.foodiechallengeback.service.impl;

import com.example.foodiechallengeback.repository.IPuntajeInscripcionRepository;
import com.example.foodiechallengeback.service.interfaces.IPuntajeInscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PuntajeInscripcionServiceImpl implements IPuntajeInscripcionService {

    private IPuntajeInscripcionRepository puntajeInscripcionRepository;

    //Inyecciones
    @Autowired
    public void setPuntajeInscripcionRepository(IPuntajeInscripcionRepository puntajeInscripcionRepository){
        this.puntajeInscripcionRepository = puntajeInscripcionRepository;
    }
}
