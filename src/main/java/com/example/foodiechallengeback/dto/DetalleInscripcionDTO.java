package com.example.foodiechallengeback.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO para datos de Detalle de Inscripciones
 *
 * @author Rubi Utima
 * @since 1.0
 */

@Getter
@Setter
@NoArgsConstructor
public class DetalleInscripcionDTO {

    private Long id;

    private Long idInscripcionReto;

    private String nombreUsuario;

    private Long calificacionFinal;

    private String video;

    private String adjuntoImg;
}
