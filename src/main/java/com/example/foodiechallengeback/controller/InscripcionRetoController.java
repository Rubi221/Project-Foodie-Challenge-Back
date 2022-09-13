package com.example.foodiechallengeback.controller;

import com.example.foodiechallengeback.dto.InscripcionRetoDTO;
import com.example.foodiechallengeback.mapper.InscripcionRetoMapper;
import com.example.foodiechallengeback.service.interfaces.IInscripcionRetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Clase controladora para InscripcionReto
 *
 * @author Rubi Utima
 * @since 1.0
 */
@RestController
@RequestMapping("/api/inscripcionReto")
public class InscripcionRetoController {
    private IInscripcionRetoService inscripcionRetoService;

    // Obtiene la lista de inscripciones para un reto por IdReto
    @GetMapping("/Lista")
    public ResponseEntity<List<InscripcionRetoDTO>> obtenerInscripcionesReto(@RequestParam(name = "idReto") Long idReto){
        return new ResponseEntity<>(this.inscripcionRetoService.obtenerInscripcionesReto(idReto).stream()
                .map(InscripcionRetoMapper.INSTANCE::toInscripcionRetoDTO).collect(Collectors.toList()), HttpStatus.OK);
    }

    //Crea una inscripcion a un reto
    @PostMapping
    public ResponseEntity<?> createInscripcionReto(@RequestParam(name = "idReto") Long idReto,
                                                   @RequestParam(name = "idUsuario") Long idUsuario){
        try{
            return new ResponseEntity<>(InscripcionRetoMapper.INSTANCE.toInscripcionRetoDTO(this.inscripcionRetoService.createInscripcionReto(idReto,idUsuario)), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("El miembro ya se ha inscrito a este reto", HttpStatus.CREATED);
        }
    }

    //Inyecciones
    @Autowired
    public void setInscripcionRetoService(IInscripcionRetoService inscripcionRetoService) {
        this.inscripcionRetoService = inscripcionRetoService;
    }
}
