package com.example.foodiechallengeback.model;

import lombok.*;
import javax.persistence.*;

/**
 * Clase para el manejo de Usuarios
 *
 * @author Rubi Utima
 * @since 1.0
 */

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Contraseña")
    private String contrasena;

    @Column(name = "Username")
    private String username;

    @Column(name = "Nacionalidad")
    private String nacionalidad;

    @Column(name = "Correo")
    private String correo;

}
