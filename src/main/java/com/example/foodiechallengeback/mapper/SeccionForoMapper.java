package com.example.foodiechallengeback.mapper;

import com.example.foodiechallengeback.dto.SeccionForoDTO;
import com.example.foodiechallengeback.model.SeccionForo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Contiene los mappers de Seccion Foro
 * @author Rubi Utima
 *
 */
@Mapper
public interface SeccionForoMapper {
    SeccionForoMapper INSTANCE = Mappers.getMapper(SeccionForoMapper.class);

    //Entity to DTO
    SeccionForoDTO toSeccionForoDTO(SeccionForo seccionForo);


    //DTO to Entity

    SeccionForo toSeccionForo(SeccionForoDTO seccionForoDTO);
}
