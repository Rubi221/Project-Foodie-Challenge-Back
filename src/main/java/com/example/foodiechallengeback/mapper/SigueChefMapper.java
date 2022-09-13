package com.example.foodiechallengeback.mapper;

import com.example.foodiechallengeback.dto.SigueChefDTO;
import com.example.foodiechallengeback.model.SigueChef;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SigueChefMapper {

    SigueChefMapper INSTANCE = Mappers.getMapper(SigueChefMapper.class);

    //Entity to DTO
    SigueChefDTO toSigueChefDTO(SigueChef sigueChef);

    //DTO to Entity
    SigueChef toSigueChef(SigueChefDTO sigueChefDTO);
}
