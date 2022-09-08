package com.example.foodiechallengeback.mapper;

import com.example.foodiechallengeback.dto.InscritoRetoDTO;
import com.example.foodiechallengeback.dto.RetoDTO;
import com.example.foodiechallengeback.model.InscripcionReto;
import com.example.foodiechallengeback.model.Reto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * Contiene los mappers de Retos
 * @author Rubi Utima
 *
 */
@Mapper
public interface RetoMapper {
    RetoMapper INSTANCE = Mappers.getMapper(RetoMapper.class);

    //Entity to DTO
    @Mapping(target = "nombreChef", source = "chef.usuario.nombre")
    @Mapping(target = "nombreCategoria", source = "categoria.nombre")
    RetoDTO toRetoDTO(Reto reto);

    @Mapping(target = "nombreChef", source = "chef.usuario.nombre")
    @Mapping(target = "nombreCategoria", source = "categoria.nombre")
    InscritoRetoDTO toInscritoRetoDTO(Reto reto);


    //DTO to Entity

    Reto toReto(RetoDTO retoDTO);
}
