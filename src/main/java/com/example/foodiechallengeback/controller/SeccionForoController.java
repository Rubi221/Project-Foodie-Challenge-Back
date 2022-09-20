package com.example.foodiechallengeback.controller;

import com.example.foodiechallengeback.dto.SeccionForoDTO;
import com.example.foodiechallengeback.mapper.SeccionForoMapper;
import com.example.foodiechallengeback.service.interfaces.ISeccionForoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Clase controladora para SeccionForo
 *
 * @author Rubi Utima
 * @since 1.0
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/api/seccionForo")
public class SeccionForoController {

    private ISeccionForoService seccionForoService;


    //Obtiene todas las secciones
    @GetMapping("/allSeccion")
    public ResponseEntity<List<SeccionForoDTO>> getAll() {
        return new ResponseEntity<>(this.seccionForoService.getAll().stream()
                .map(SeccionForoMapper.INSTANCE::toSeccionForoDTO).collect(Collectors.toList()), HttpStatus.OK);
    }

    //Inyeccciones
    @Autowired
    public void setSeccionForoService(ISeccionForoService seccionForoService) {
        this.seccionForoService = seccionForoService;
    }
}
