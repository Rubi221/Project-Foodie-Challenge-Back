package com.example.foodiechallengeback.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PuntajeInscripcionDTO {

    private Long id;

    private Long idDetalle;

    private Long idUsuario;

    private Long puntaje;
}
