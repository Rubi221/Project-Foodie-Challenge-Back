package com.example.foodiechallengeback.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Clase para el manejo de Retos
 *
 * @author Rubi Utima
 * @since 1.0
 */

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "reto")
public class Reto {

    //Atributos

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Titulo")
    private String titulo;

    @Column(name = "Contenido")
    private String contenido;

    @Column(name = "Dificultad")
    private Long dificultad;

    @Column(name = "Video")
    private String video;

    @Column(name = "IdUsuario")
    private Long idUsuario;

    @Column(name = "IdCategoria")
    private Long idCategoria;

    @Column(name = "FechaInicio", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;

    @Column(name = "FechaFin", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaFin;

    //Relaciones

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdUsuario", insertable = false, updatable = false)
    private Usuario usuario;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdCategoria", insertable = false, updatable = false)
    private Categoria categoria;
}
