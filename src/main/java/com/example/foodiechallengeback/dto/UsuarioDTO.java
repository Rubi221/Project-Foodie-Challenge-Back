package com.example.foodiechallengeback.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

/**
 * DTO para datos de Usuario
 *
 * @author Rubi Utima
 * @since 1.0
 */

@Getter
@Setter
@NoArgsConstructor
public class UsuarioDTO {
    private Long id;

    private String nombre;

    private String contrasena;

    private String username;

    private String nacionalidad;

    private String correo;
}
