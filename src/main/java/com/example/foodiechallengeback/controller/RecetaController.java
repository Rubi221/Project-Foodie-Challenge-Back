package com.example.foodiechallengeback.controller;

import com.example.foodiechallengeback.dto.InscritoRetoDTO;
import com.example.foodiechallengeback.dto.RecetaDTO;
import com.example.foodiechallengeback.dto.RetoDTO;
import com.example.foodiechallengeback.mapper.RecetaMapper;
import com.example.foodiechallengeback.mapper.RetoMapper;
import com.example.foodiechallengeback.repository.IRecetaRepository;
import com.example.foodiechallengeback.service.interfaces.IRecetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Clase controladora para Receta
 *
 * @author Rubi Utima
 * @since 1.0
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/api/receta")
public class RecetaController {
    private IRecetaService recetaService;

    // Obtiene todas las recetas
    @GetMapping("/all")
    public ResponseEntity<List<RecetaDTO>> obtenerAllReceta(){
        return new ResponseEntity<>(this.recetaService.obtenerAllReceta().stream().map(RecetaMapper.INSTANCE::toRecetaDTO).collect(Collectors.toList()), HttpStatus.OK);
    }

    // Obtiene una receta por id
    @GetMapping("/id")
    public ResponseEntity<RecetaDTO> obtenerRecetaById(@RequestParam(name = "id")Long aId){
        return new ResponseEntity<>(RecetaMapper.INSTANCE.toRecetaDTO(this.recetaService.obtenerRecetaById(aId)), HttpStatus.OK);
    }

    //Crea una receta
    @PostMapping
    public ResponseEntity<?> createReceta(@Validated @RequestBody RecetaDTO recetaDTO){
        try{
            return new ResponseEntity<>(RecetaMapper.INSTANCE.toRecetaDTO(this.recetaService.createReceta(recetaDTO)), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Las fechas ingresadas son invalidas", HttpStatus.CREATED);
        }
    }

    //Elimina una receta por Id
    @DeleteMapping
    public ResponseEntity<Boolean> deleteReceta(@RequestParam(name = "Id") Long aId) throws Exception {
        this.recetaService.deleteReceta(aId);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    //Inyecciones
    @Autowired
    public void setRecetaService(IRecetaService recetaService) {
        this.recetaService = recetaService;
    }
}
