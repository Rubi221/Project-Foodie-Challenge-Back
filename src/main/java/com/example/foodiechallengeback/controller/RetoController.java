package com.example.foodiechallengeback.controller;

import com.example.foodiechallengeback.dto.InscritoRetoDTO;
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

    // Obtiene un reto dado un idReto y un idUsuario
    @GetMapping("/inscrito")
    public ResponseEntity<InscritoRetoDTO> obtenerRetoById(@RequestParam(name = "idReto")Long idReto,
                                                         @RequestParam(name = "idUsuario")Long idUsuario){
        return new ResponseEntity<>(this.retoService.obtenerRetoById(idReto, idUsuario), HttpStatus.OK);
    }

    // Obtiene la lista de retos abiertos
    @GetMapping("/abiertos")
    public ResponseEntity<List<RetoDTO>> obtenerRetosAbiertos(){
        return new ResponseEntity<>(this.retoService.obtenerRetosAbiertos().stream().map(RetoMapper.INSTANCE::toRetoDTO).collect(Collectors.toList()), HttpStatus.OK);
    }

    // Obtiene la lista de retos abiertos e inscritos dado un usuario
    @GetMapping("/abiertosInscrito")
    public ResponseEntity<List<InscritoRetoDTO>> obtenerRetosAbiertosInscrito(@RequestParam(name="idUsuario")Long idUsuario){
        return new ResponseEntity<>(this.retoService.obtenerRetosAbiertosInscrito(idUsuario), HttpStatus.OK);
    }

    //Crea un nuevo reto
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
