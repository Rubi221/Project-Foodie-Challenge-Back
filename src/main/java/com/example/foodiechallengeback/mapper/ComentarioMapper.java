package com.example.foodiechallengeback.mapper;

import com.example.foodiechallengeback.dto.ComentarioDTO;
import com.example.foodiechallengeback.model.Comentario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ComentarioMapper {

    ComentarioMapper INSTANCE = Mappers.getMapper(ComentarioMapper.class);

    //Entity to DTO
    @Mapping(target = "nombreUsuario", source = "usuario.nombre")
    ComentarioDTO toMensajeDTO(Comentario mensaje);

    //DTO to Entity
    Comentario toMensaje(ComentarioDTO mensajeDTO);
}
