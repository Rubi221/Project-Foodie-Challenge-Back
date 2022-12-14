package com.example.foodiechallengeback.service.interfaces;

import com.example.foodiechallengeback.dto.UsuarioDTO;
import com.example.foodiechallengeback.model.Usuario;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Interfaz para manejar usuarios
 * @autor Rubi Utima
 */
@Service
public interface IUsuarioService {
    Usuario findById(Long idUsuario);

    @Transactional
    Usuario createUsuario(UsuarioDTO usuarioDTO) throws Exception;

    //Edita la informacion de un usuario
    @Transactional
    Usuario updateUsuario(UsuarioDTO usuarioDTO) throws Exception;

    Usuario validateUsuario(UsuarioDTO usuarioDTO);

    @Transactional
    void deleteUsuario(Long aId);
}
