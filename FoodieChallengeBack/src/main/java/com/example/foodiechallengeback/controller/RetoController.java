package com.example.foodiechallengeback.controller;

import com.example.foodiechallengeback.dto.RetoDTO;
import com.example.foodiechallengeback.mapper.RetoMapper;
import com.example.foodiechallengeback.service.interfaces.IRetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Clase controladora para Reto
 *
 * @author Rubi Utima
 * @since 1.0
 */
@RestController
@RequestMapping("/api/reto")
public class RetoController {

    private IRetoService retoService;

    @GetMapping("/abiertos")
    public ResponseEntity<List<RetoDTO>> obtenerRetosAbiertos(){
        return new ResponseEntity<>(this.retoService.obtenerRetosAbiertos().stream().map(RetoMapper.INSTANCE::toRetoDTO).collect(Collectors.toList()), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createReto(@Validated @RequestBody RetoDTO retoDTO){
        try{
            return new ResponseEntity<>(RetoMapper.INSTANCE.toRetoDTO(this.retoService.createReto(retoDTO)), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Las fechas ingresadas son invalidas", HttpStatus.CREATED);
        }
    }


    //Inyecciones
    @Autowired
    public void setRetoService(IRetoService retoService){
        this.retoService = retoService;
    }
}
