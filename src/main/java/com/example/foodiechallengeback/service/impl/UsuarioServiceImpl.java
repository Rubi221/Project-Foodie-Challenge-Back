package com.example.foodiechallengeback.service.impl;


import com.example.foodiechallengeback.dto.UsuarioDTO;
import com.example.foodiechallengeback.mapper.UsuarioMapper;
import com.example.foodiechallengeback.model.Usuario;
import com.example.foodiechallengeback.repository.IUsuarioRepository;
import com.example.foodiechallengeback.service.interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Servicio que implementa la interfaz para manejar usuarios
 * @autor Rubi Utima
 */
@Service
public class UsuarioServiceImpl implements IUsuarioService {
    private IUsuarioRepository usuarioRepository;

    //Obtiene la lista de todos los usuarios
    @Override
    public Usuario findById(Long idUsuario){
        return this.usuarioRepository.findById(idUsuario).orElse(null);
    }

    //Hace el registro de un nuevo usuario
    @Override
    @Transactional
    public Usuario createUsuario(UsuarioDTO usuarioDTO) throws Exception {
        var usuario = UsuarioMapper.INSTANCE.toUsuario(usuarioDTO);
        this.validateUsuarioRepetido(usuario);
        return this.usuarioRepository.save(usuario);
    }

    //Edita la informacion de un usuario
    @Override
    @Transactional
    public Usuario updateUsuario(UsuarioDTO usuarioDTO) throws Exception {
        var usuarioBD = this.usuarioRepository.findById(usuarioDTO.getId()).orElse(null);
        this.validateUsuarioRepetido(UsuarioMapper.INSTANCE.toUsuario(usuarioDTO));
        if (usuarioBD != null){
            usuarioBD.setNombre(usuarioDTO.getNombre());
            usuarioBD.setContrasena(usuarioDTO.getContrasena());
            usuarioBD.setUsername(usuarioDTO.getUsername());
            usuarioBD.setNacionalidad(usuarioDTO.getNacionalidad());
            usuarioBD.setEspecialidad(usuarioDTO.getEspecialidad());
            usuarioBD.setCorreo(usuarioDTO.getCorreo());
            usuarioBD.setFoto(usuarioDTO.getFoto());
        }else{
            throw new Exception("Id no encontrado");
        }
        return this.usuarioRepository.save(usuarioBD);
    }

    //Valida los datos de un usuario para realizar inicio de sesion
    @Override
    public Usuario validateUsuario(UsuarioDTO usuarioDTO){
        var login = this.usuarioRepository.validateUsuarioLogin(usuarioDTO.getUsername(), usuarioDTO.getContrasena());
        Boolean valid;
        if(login == null){
            valid = false;
        }else{
            valid = true;
        }
        return login;
    }

    //Elimina un usuario
    @Override
    @Transactional
    public void deleteUsuario(Long aId) {
        var usuarioBD = usuarioRepository.findById(aId).orElse(null);
        this.usuarioRepository.deleteById(usuarioBD.getId());
    }

    //Valida que el username ingresado no este en uso
    private void validateUsuarioRepetido(Usuario usuario) throws Exception {
        var registro = this.usuarioRepository.validateUsuarioRepetido(usuario.getUsername());
        if (registro != null) {
            throw new Exception("Este nombre de usuario ya esta en uso");
        }
    }

    //Inyecciones
    @Autowired
    public void setUsuarioRepository(IUsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
}