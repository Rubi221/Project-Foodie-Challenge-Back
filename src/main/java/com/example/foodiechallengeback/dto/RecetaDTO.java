package com.example.foodiechallengeback.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * DTO para datos de Receta
 *
 * @author Rubi Utima
 * @since 1.0
 */

@Getter
@Setter
@NoArgsConstructor
public class RecetaDTO {

    private Long id;

    private String titulo;

    private String contenido;

    private Long idUsuario;
    private String nombreUsuario;

    private Long idCategoria;

    private Long idSubategoria;

    private Long idTipoReceta;

    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "America/Bogota")
    private Date fecha;

    private String adjunto;
}
