package com.example.foodiechallengeback.mapper;

import com.example.foodiechallengeback.dto.PuntajeInscripcionDTO;
import com.example.foodiechallengeback.model.PuntajeInscripcion;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PuntajeInscripcionMapper {

    PuntajeInscripcionMapper INSTANCE = Mappers.getMapper(PuntajeInscripcionMapper.class);

    //Entity to DTO
    PuntajeInscripcionDTO toPuntajeInscripcionDTO(PuntajeInscripcion puntajeInscripcion);

    //DTO to Entity
    PuntajeInscripcion toPuntajeInscripcion(PuntajeInscripcionDTO puntajeInscripcionDTO);
}
