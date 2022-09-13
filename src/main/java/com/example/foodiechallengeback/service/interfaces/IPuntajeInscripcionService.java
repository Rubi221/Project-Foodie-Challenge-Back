package com.example.foodiechallengeback.service.interfaces;

import com.example.foodiechallengeback.dto.PuntajeInscripcionDTO;
import com.example.foodiechallengeback.model.PuntajeInscripcion;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public interface IPuntajeInscripcionService {

    List<PuntajeInscripcion> findAllPuntajes();

    @Transactional
    PuntajeInscripcion createPuntaje(PuntajeInscripcionDTO puntajeInscripcionDTO);
}
