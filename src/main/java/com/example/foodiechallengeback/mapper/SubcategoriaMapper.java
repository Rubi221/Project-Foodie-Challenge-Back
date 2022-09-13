package com.example.foodiechallengeback.mapper;

import com.example.foodiechallengeback.dto.SubcategoriaDTO;
import com.example.foodiechallengeback.model.Subcategoria;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SubcategoriaMapper {
    SubcategoriaMapper INSTANCE = Mappers.getMapper(SubcategoriaMapper.class);

    //Entity to DTO
    SubcategoriaDTO toSubcategoriaDTO(Subcategoria subcategoria);

    //DTO to Entity
    Subcategoria toSubcateoria(SubcategoriaDTO subcategoriaDTO);

}
