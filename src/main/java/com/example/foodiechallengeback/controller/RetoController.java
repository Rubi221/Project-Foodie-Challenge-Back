package com.example.foodiechallengeback.controller;

import com.example.foodiechallengeback.dto.InscritoRetoDTO;
import com.example.foodiechallengeback.dto.RetoDTO;
import com.example.foodiechallengeback.dto.UsuarioDTO;
import com.example.foodiechallengeback.mapper.RetoMapper;
import com.example.foodiechallengeback.mapper.UsuarioMapper;
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
@CrossOrigin("*")
@RequestMapping("/api/reto")
public class RetoController {
    private IRetoService retoService;

    //Obtiene todos los retos por categoria
    @GetMapping("/allByCategoria")
    public ResponseEntity<List<RetoDTO>> obtenerRetosByCategoria(@RequestParam(name = "idCategoria")Long idCategoria) throws Exception {
        return new ResponseEntity<>(this.retoService.obtenerRetosByCategoria(idCategoria).stream()
                .map(RetoMapper.INSTANCE::toRetoDTO).collect(Collectors.toList()), HttpStatus.OK);
    }

    //Obtiene el id del usuario que crea un reto
    @GetMapping("/autor")
    public ResponseEntity<UsuarioDTO> obtenerAutorReto(@RequestParam(name = "idReto")Long idReto) throws Exception {
        return new ResponseEntity<>(UsuarioMapper.INSTANCE.toUsuarioDTO(this.retoService.obtenerAutorReto(idReto)), HttpStatus.OK);
    }

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

    // Obtiene la lista de retos inscritos por un usuario o creados por un chef
    @GetMapping("/misRetos")
    public ResponseEntity<List<RetoDTO>> getMisRetos(@RequestParam(name="idUsuario")Long idUsuario){
        return new ResponseEntity<>(this.retoService.getMisRetos(idUsuario).stream().map(RetoMapper.INSTANCE::toRetoDTO).collect(Collectors.toList()), HttpStatus.OK);
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

    //Actualiza un nuevo reto
    @PutMapping
    public ResponseEntity<?> updateReto(@Validated @RequestBody RetoDTO retoDTO){
        try{
            return new ResponseEntity<>(RetoMapper.INSTANCE.toRetoDTO(this.retoService.updateReto(retoDTO)), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("No se pudo realizar la transaccion", HttpStatus.CREATED);
        }
    }

    //Elimina una publicacion por Id
    @DeleteMapping
    public ResponseEntity<Boolean> deleteReto(@RequestParam(name = "Id") Long aId) throws Exception {
        this.retoService.deleteReto(aId);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    //Inyecciones
    @Autowired
    public void setRetoService(IRetoService retoService){
        this.retoService = retoService;
    }
}
