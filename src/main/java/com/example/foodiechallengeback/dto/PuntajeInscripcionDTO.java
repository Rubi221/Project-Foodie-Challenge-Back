package com.example.foodiechallengeback.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PuntajeInscripcionDTO {

    private Long id;

    private Long idInscripcionReto;

    private Long idMiembro;

    private Long puntaje;
}
