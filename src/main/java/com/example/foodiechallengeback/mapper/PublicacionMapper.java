package com.example.foodiechallengeback.mapper;

import com.example.foodiechallengeback.dto.PublicacionDTO;
import com.example.foodiechallengeback.model.Publicacion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PublicacionMapper {

    PublicacionMapper INSTANCE = Mappers.getMapper(PublicacionMapper.class);

    //Entity to DTO
    @Mapping(target = "idSeccionForo", source = "seccionForo.id")
    @Mapping(target = "nombreSeccionForo", source = "seccionForo.nombre")
    PublicacionDTO toPublicacionDTO(Publicacion publicacion);

    //DTO to Entity
    Publicacion toPublicacion(PublicacionDTO publicacionDTO);

}
