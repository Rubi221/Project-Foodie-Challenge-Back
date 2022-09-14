package com.example.foodiechallengeback.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.util.Date;

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

    //Atributos

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

    @Column(name = "Especialidad")
    private String especialidad;

    @Column(name = "NivelActividad")
    private String nivelActividad;

    @Column(name = "IdTipoUsuario")
    private Long idTipoUsuario;

    @Column(name = "Img")
    private String foto;

    //Relaciones

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdTipoUsuario", insertable = false, updatable = false)
    private TipoUsuario tipoUsuario;

}
