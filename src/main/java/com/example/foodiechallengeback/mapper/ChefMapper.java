package com.example.foodiechallengeback.mapper;

import com.example.foodiechallengeback.dto.ChefDTO;
import com.example.foodiechallengeback.model.Chef;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Contiene los mappers de Chef
 * @author Rubi Utima
 *
 */
@Mapper
public interface ChefMapper {
    ChefMapper INSTANCE = Mappers.getMapper(ChefMapper.class);

    //Entity to DTO

    ChefDTO toChefDTO(Chef chef);

    //DTO to Entity

    Chef toChef(ChefDTO chefDTO);
}
