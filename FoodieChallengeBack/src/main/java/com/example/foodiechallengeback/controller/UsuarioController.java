package com.example.foodiechallengeback.controller;

import com.example.foodiechallengeback.dto.UsuarioDTO;
import com.example.foodiechallengeback.mapper.UsuarioMapper;
import com.example.foodiechallengeback.service.interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Clase controladora para Usuarios
 *
 * @author Rubi Utima
 * @since 1.0
 */
@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    private IUsuarioService usuarioService;

    //Obtiene la lista de todos los usuarios
    @GetMapping("/all")
    public ResponseEntity<List<UsuarioDTO>> getAllUsuarios(){
        return new ResponseEntity<>(this.usuarioService.findAllUsuario().stream().map(UsuarioMapper.INSTANCE::toUsuarioDTO).collect(Collectors.toList()), HttpStatus.OK);
    }

    //Hace el registro de un nuevo usuario
    @PostMapping
    public ResponseEntity<?> createUsuario(@Validated  @RequestBody UsuarioDTO usuarioDTO,
                                                    @RequestParam (name = "tipoUsuario")Long tipoUsuario,
                                                    @RequestParam (name = "especialidad")String especialidad){
        try{
            return new ResponseEntity<>(UsuarioMapper.INSTANCE.toUsuarioDTO(this.usuarioService.createUsuario(usuarioDTO, tipoUsuario, especialidad)), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Este nombre de usuario ya esta en uso", HttpStatus.CREATED);
        }
    }

    //Valida los datos de un usuario para realizar inicio de sesion
    @PostMapping("/validateLogin")
    public ResponseEntity<Boolean> validateUsuario(@Validated  @RequestBody UsuarioDTO usuarioDTO){
        var valid = this.usuarioService.validateUsuario(usuarioDTO);
        return new ResponseEntity<>(valid, HttpStatus.OK);
    }

    //Elimina un usuario por Id
    @DeleteMapping
    public ResponseEntity<Boolean> deleteUsuario(@RequestParam(name = "Id") Long aId) {
        this.usuarioService.deleteUsuario(aId);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    //Inyecciones
    @Autowired
    public void setUsuarioService(IUsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
}
