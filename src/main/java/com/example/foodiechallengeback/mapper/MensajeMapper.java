package com.example.foodiechallengeback.mapper;

import com.example.foodiechallengeback.dto.MensajeDTO;
import com.example.foodiechallengeback.model.Mensaje;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MensajeMapper {

    MensajeMapper INSTANCE = Mappers.getMapper(MensajeMapper.class);

    //Entity to DTO
    MensajeDTO toMensajeDTO(Mensaje mensaje);

    //DTO to Entity
    Mensaje toMensaje(MensajeDTO mensajeDTO);
}
