package com.example.foodiechallengeback.controller;

import com.example.foodiechallengeback.dto.SigueChefDTO;
import com.example.foodiechallengeback.mapper.SigueChefMapper;
import com.example.foodiechallengeback.service.interfaces.ISigueChefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sigueChef")
public class SigueChefController {

    private ISigueChefService sigueChefService;

    //Crea un nuevo mensaje
    @PostMapping
    public ResponseEntity<?> createSeguidor(@Validated @RequestBody SigueChefDTO sigueChefDTO){
        try{
            return new ResponseEntity<>(SigueChefMapper.INSTANCE.toSigueChefDTO(this.sigueChefService.createSeguidor(sigueChefDTO)), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("No se puede seguir a este Chef", HttpStatus.EXPECTATION_FAILED);
        }
    }


    //Obtiene todos los ID de los seguidores
    @GetMapping("/allSeguidores")
    public ResponseEntity<List<Long>> getAllSeguidores(@RequestParam(name= "idChef")Long idChef){
        return new ResponseEntity<>(this.sigueChefService.findAllMiembro(idChef), HttpStatus.OK);
    }

    //Obtiene todos los ID de los chefs
    @GetMapping("/allChef")
    public ResponseEntity<List<Long>> getAllChefs(@RequestParam(name= "idMiembro")Long idMiembro){
        return new ResponseEntity<>(this.sigueChefService.findAllChef(idMiembro), HttpStatus.OK);
    }

    //Elimina un seguidor por Id
    @DeleteMapping
    public ResponseEntity<Boolean> deleteMensaje(@RequestParam(name = "Id") Long aId) {
        this.sigueChefService.deleteSeguidor(aId);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    //Inyecciones
    @Autowired
    public void setSigueChefService(ISigueChefService sigueChefService){ this.sigueChefService = sigueChefService; }
}
