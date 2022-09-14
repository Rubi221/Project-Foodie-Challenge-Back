package com.example.foodiechallengeback.controller;

import com.example.foodiechallengeback.dto.PublicacionDTO;
import com.example.foodiechallengeback.mapper.PublicacionMapper;
import com.example.foodiechallengeback.repository.IUsuarioRepository;
import com.example.foodiechallengeback.service.interfaces.IPublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/publicacion")
public class PublicacionController {

    private IPublicacionService publicacionService;

    //Obtiene la lista de las publicaciones por seccion y/o usuario
    @GetMapping("/all")
    public ResponseEntity<List<PublicacionDTO>> getAllPublicaciones(@RequestParam(name = "idSeccion",required = false)Long idSeccion,
                                                                    @RequestParam(name = "idUsuario",required = false)Long idUsuario){
        return new ResponseEntity<>(this.publicacionService.findAllPublicacion(idSeccion, idUsuario).stream().map(PublicacionMapper.INSTANCE::toPublicacionDTO).collect(Collectors.toList()), HttpStatus.OK);
    }

    //Crea una nuevo publicacion
    @PostMapping
    public ResponseEntity<?> createPublicacion(@Validated @RequestBody PublicacionDTO publicacionDTO){
        try{
            return new ResponseEntity<>(PublicacionMapper.INSTANCE.toPublicacionDTO(this.publicacionService.createPublicacion(publicacionDTO)), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("No se pudo realizar la publicacion", HttpStatus.BAD_REQUEST);
        }
    }

    //Actualiza una publicacion
    @PutMapping
    public ResponseEntity<?> updatePublicacion(@Validated @RequestBody PublicacionDTO publicacionDTO){
        try{
            return new ResponseEntity<>(PublicacionMapper.INSTANCE.toPublicacionDTO(this.publicacionService.updatePublicacion(publicacionDTO)), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Id no encontrado", HttpStatus.BAD_REQUEST);
        }
    }

    //Elimina un mensaje por Id
    @DeleteMapping
    public ResponseEntity<Boolean> deletePublicacion(@RequestParam(name = "Id") Long aId) {
        this.publicacionService.deletePublicacion(aId);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    //Inyecciones
    @Autowired
    public void setPublicacionService(IPublicacionService publicacionService){
        this.publicacionService = publicacionService;
    }

}
