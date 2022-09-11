package com.example.foodiechallengeback.mapper;

import com.example.foodiechallengeback.dto.CategoriaDTO;
import com.example.foodiechallengeback.model.Categoria;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoriaMapper {
    CategoriaMapper INSTANCE = Mappers.getMapper(CategoriaMapper.class);

    //Entity to DTO
    CategoriaDTO toCategoriaDTO(Categoria cateoria);

    //DTO to Entity
    Categoria toCateoria(CategoriaDTO categoriaDTO);

}
