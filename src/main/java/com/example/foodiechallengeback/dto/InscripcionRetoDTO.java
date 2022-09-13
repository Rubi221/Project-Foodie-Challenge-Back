package com.example.foodiechallengeback.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO para datos de Inscripciones a Retos
 *
 * @author Rubi Utima
 * @since 1.0
 */

@Getter
@Setter
@NoArgsConstructor
public class InscripcionRetoDTO {

    private Long id;

    private Long idReto;
    private String tituloReto;

    private Long idUsuario;
    private String nombreUsuario;

}

