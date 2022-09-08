package com.example.foodiechallengeback.mapper;

import com.example.foodiechallengeback.dto.DetalleInscripcionDTO;
import com.example.foodiechallengeback.model.DetalleInscripcion;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Contiene los mappers de DetalleInscripcion
 * @author Rubi Utima
 *
 */
@Mapper
public interface DetalleInscripcionMapper {

    DetalleInscripcionMapper INSTANCE = Mappers.getMapper(DetalleInscripcionMapper.class);

    //Entity to DTO

    DetalleInscripcionDTO toDetalleInscripcionDTO(DetalleInscripcion detalleInscripcion);


    //DTO to Entity

    DetalleInscripcion toDetalleInscripcion(DetalleInscripcionDTO detalleInscripcionDTO);
}
