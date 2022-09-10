package com.example.foodiechallengeback.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class MensajeDTO {

    private Long id;

    private String contenido;

    private Long idPadre;

    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "America/Bogota")
    private Date fecha;
}
