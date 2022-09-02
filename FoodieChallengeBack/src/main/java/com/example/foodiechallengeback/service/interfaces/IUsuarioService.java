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
    List<Usuario> findAllUsuario();

    @Transactional
    Usuario createUsuario(UsuarioDTO usuarioDTO, Long tipoUsuario, String especialidad) throws Exception;

    Boolean validateUsuario(UsuarioDTO usuarioDTO);

    @Transactional
    void deleteUsuario(Long aId);
}
