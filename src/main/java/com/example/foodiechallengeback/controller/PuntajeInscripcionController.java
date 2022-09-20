package com.example.foodiechallengeback.controller;

import com.example.foodiechallengeback.dto.PuntajeInscripcionDTO;
import com.example.foodiechallengeback.mapper.PuntajeInscripcionMapper;
import com.example.foodiechallengeback.model.PuntajeInscripcion;
import com.example.foodiechallengeback.service.interfaces.IPuntajeInscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/puntajeIns")
public class PuntajeInscripcionController {

    private IPuntajeInscripcionService puntajeInscripcionService;

    //Obtiene todas las puntuaciones
    @GetMapping("/allPuntuacion")
    public ResponseEntity<List<PuntajeInscripcionDTO>> getAllPuntajes(){
        return new ResponseEntity<>(this.puntajeInscripcionService.findAllPuntajes().stream().map(PuntajeInscripcionMapper.INSTANCE::toPuntajeInscripcionDTO).collect(Collectors.toList()), HttpStatus.OK);
    }

    //Valida si se califico una inscripcion
    @GetMapping("/validateCalifica")
    public ResponseEntity<Boolean> validateCalifica(@RequestParam(name = "idUsuario")Long idUsuario,
                                                    @RequestParam(name = "idDetalle")Long idDetalle){
        return new ResponseEntity<>(this.puntajeInscripcionService.validateCalifica(idUsuario,idDetalle), HttpStatus.OK);
    }

    //Crea un Puntaje de inscripcion
    @PostMapping
    public ResponseEntity<?> createPuntaje(@Validated @RequestBody PuntajeInscripcionDTO puntajeInscripcionDTO){
        return new ResponseEntity<>(PuntajeInscripcionMapper.INSTANCE.toPuntajeInscripcionDTO(this.puntajeInscripcionService.createPuntaje(puntajeInscripcionDTO)), HttpStatus.CREATED);
    }

    //Inyecciones
    @Autowired
    public void setPuntajeInscripcionService(IPuntajeInscripcionService puntajeInscripcionService){this.puntajeInscripcionService=puntajeInscripcionService; }
}
