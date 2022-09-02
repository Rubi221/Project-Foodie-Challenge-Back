package com.example.foodiechallengeback.mapper;

import com.example.foodiechallengeback.dto.UsuarioDTO;
import com.example.foodiechallengeback.model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Contiene los mappers de Usuarios
 * @author Rubi Utima
 *
 */
@Mapper
public interface UsuarioMapper {
    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    //Entity to DTO

    UsuarioDTO toUsuarioDTO(Usuario usuario);

    //DTO to Entity

    Usuario toUsuario(UsuarioDTO usuarioDTO);
}

