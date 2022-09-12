package com.example.foodiechallengeback.controller;


import com.example.foodiechallengeback.dto.MensajeDTO;
import com.example.foodiechallengeback.mapper.MensajeMapper;
import com.example.foodiechallengeback.service.interfaces.IMensajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/mensaje")
public class MensajeController {

    private IMensajeService mensajeService;

    //Obtiene la lista de todos los mensajes de una publiacion o un reto
    @GetMapping("/allByPublish")
    public ResponseEntity<List<MensajeDTO>> getAllMensajesByPublish(@RequestParam(name = "idPublicacion", required = false)Long idPublicacion,
                                                           @RequestParam(name = "idReto", required = false)Long idReto){
        return new ResponseEntity<>(this.mensajeService.findAllMensaje(idPublicacion, idReto).stream().map(MensajeMapper.INSTANCE::toMensajeDTO).collect(Collectors.toList()), HttpStatus.OK);
    }

    //Obtiene la lista de todos los mensajes hijos de un mensaje padre
    @GetMapping("/allByIdPadre")
    public ResponseEntity<List<MensajeDTO>> getAllMensajesHijos(@RequestParam(name = "idPadre")Long idPadre){
        return new ResponseEntity<>(this.mensajeService.findAllMensajesHijos(idPadre).stream().map(MensajeMapper.INSTANCE::toMensajeDTO).collect(Collectors.toList()), HttpStatus.OK);
    }


    //Crea un nuevo mensaje
    @PostMapping
    public ResponseEntity<?> createMensaje(@Validated @RequestBody MensajeDTO mensajeDTO){
        try{
            return new ResponseEntity<>(MensajeMapper.INSTANCE.toMensajeDTO(this.mensajeService.createMensaje(mensajeDTO)), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Mensaje no pudo ser publicado", HttpStatus.EXPECTATION_FAILED);
        }
    }


    //Elimina un mensaje por Id
    @DeleteMapping
    public ResponseEntity<Boolean> deleteMensaje(@RequestParam(name = "Id") Long aId) {
        this.mensajeService.deleteMensaje(aId);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    //Inyecciones
    @Autowired
    public void setMensajeService(IMensajeService mensajeService){ this.mensajeService = mensajeService; }

}
