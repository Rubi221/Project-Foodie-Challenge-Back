package com.example.foodiechallengeback.mapper;

import com.example.foodiechallengeback.dto.RecetaDTO;
import com.example.foodiechallengeback.model.Receta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * Contiene los mappers de Recetas
 * @author Rubi Utima
 *
 */
@Mapper
public interface RecetaMapper {
    RecetaMapper INSTANCE = Mappers.getMapper(RecetaMapper.class);

    //Entity to DTO
    @Mapping(target = "nombreUsuario", source = "usuario.nombre")
    RecetaDTO toRecetaDTO(Receta receta);


    //DTO to Entity

    Receta toReceta(RecetaDTO recetaDTO);
}
