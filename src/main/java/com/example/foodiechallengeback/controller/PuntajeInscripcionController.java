package com.example.foodiechallengeback.controller;

import com.example.foodiechallengeback.service.interfaces.IPuntajeInscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/puntajeIns")
public class PuntajeInscripcionController {

    private IPuntajeInscripcionService puntajeInscripcionService;



    //Inyecciones
    @Autowired
    public void setPuntajeInscripcionService(IPuntajeInscripcionService puntajeInscripcionService){this.puntajeInscripcionService=puntajeInscripcionService; }
}
