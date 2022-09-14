package com.example.foodiechallengeback.controller;

import com.example.foodiechallengeback.dto.DetalleInscripcionDTO;
import com.example.foodiechallengeback.mapper.DetalleInscripcionMapper;
import com.example.foodiechallengeback.service.interfaces.IDetalleInscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Clase controladora para DetalleInscripcion
 *
 * @author Rubi Utima
 * @since 1.0
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/api/detalleInscripcion")
public class DetalleInscripcionController {
    private IDetalleInscripcionService detalleInscripcionService;

    // Obtiene un detalle de inscripcion
    @GetMapping("/entrega")
    public ResponseEntity<DetalleInscripcionDTO> obtenerDetalleByIdInscripcion(@RequestParam(name = "idInscripcion")Long idInscripcion){
        return new ResponseEntity<>(DetalleInscripcionMapper.INSTANCE.toDetalleInscripcionDTO(this.detalleInscripcionService.obtenerDetalleByIdInscripcion(idInscripcion)), HttpStatus.OK);
    }

    // Obtiene todas las entregas de un reto
    @GetMapping("/allEntregasByReto")
    public ResponseEntity<List<DetalleInscripcionDTO>> obtenerDetallesByIdReto(@RequestParam(name = "idReto")Long idReto){
        return new ResponseEntity<>(this.detalleInscripcionService.obtenerDetallesByIdReto(idReto).stream()
                .map(DetalleInscripcionMapper.INSTANCE::toDetalleInscripcionDTO).collect(Collectors.toList()), HttpStatus.OK);
    }

    //Crea un detalle de inscripcion a un reto
    @PostMapping
    public ResponseEntity<?> createDetalleInscripcion(@Validated @RequestBody DetalleInscripcionDTO detalleInscripcionDTO){
        try{
            return new ResponseEntity<>(DetalleInscripcionMapper.INSTANCE.toDetalleInscripcionDTO(this.detalleInscripcionService.createDetalleInscripcion(detalleInscripcionDTO)), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("El miembro ya ha creado una entrega para este reto", HttpStatus.CREATED);
        }
    }

    //Actualiza un detalle de inscripcion a un reto
    @PutMapping
    public ResponseEntity<?> updateDetalleInscripcion(@Validated @RequestBody DetalleInscripcionDTO detalleInscripcionDTO){
        try{
            return new ResponseEntity<>(DetalleInscripcionMapper.INSTANCE.toDetalleInscripcionDTO(this.detalleInscripcionService.updateDetalleInscripcion(detalleInscripcionDTO)), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Id no encontrado", HttpStatus.CREATED);
        }
    }

    //Inyecciones
    @Autowired
    public void setDetalleInscripcionService(IDetalleInscripcionService detalleInscripcionService) {
        this.detalleInscripcionService = detalleInscripcionService;
    }
}
