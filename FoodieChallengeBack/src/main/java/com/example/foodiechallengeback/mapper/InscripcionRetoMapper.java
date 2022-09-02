package com.example.foodiechallengeback.mapper;

import com.example.foodiechallengeback.dto.InscripcionRetoDTO;
import com.example.foodiechallengeback.model.InscripcionReto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * Contiene los mappers de InscripcionRetos
 * @author Rubi Utima
 *
 */
@Mapper
public interface InscripcionRetoMapper {
    InscripcionRetoMapper INSTANCE = Mappers.getMapper(InscripcionRetoMapper.class);

    //Entity to DTO
    @Mapping(target = "nombreMiembro", source = "miembro.usuario.nombre")
    @Mapping(target = "tituloReto", source = "reto.titulo")
    InscripcionRetoDTO toInscripcionRetoDTO(InscripcionReto InscripcionReto);

    //DTO to Entity

    InscripcionReto toInscripcionReto(InscripcionRetoDTO inscripcionRetoDTO);
}
