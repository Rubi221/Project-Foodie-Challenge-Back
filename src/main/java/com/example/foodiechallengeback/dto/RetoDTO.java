package com.example.foodiechallengeback.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * DTO para datos de Reto
 *
 * @author Rubi Utima
 * @since 1.0
 */

@Getter
@Setter
@NoArgsConstructor
public class RetoDTO {

    private Long id;

    private String titulo;

    private String contenido;

    private Long dificultad;

    private String video;

    private Long idUsuario;
    private String nombreChef;

    private Long idCategoria;
    private String nombreCategoria;

    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "America/Bogota")
    private Date fechaInicio;

    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "America/Bogota")
    private Date fechaFin;

    private String adjunto;
}
