package com.example.foodiechallengeback.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Clase para el manejo de Recetas
 *
 * @author Rubi Utima
 * @since 1.0
 */

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "receta")
public class Receta {

    //Atributos

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Titulo")
    private String titulo;

    @Column(name = "Contenido")
    private String contenido;

    @Column(name = "IdUsuario")
    private Long idUsuario;

    @Column(name = "IdCategoria")
    private Long idCategoria;

    @Column(name = "IdSubategoria")
    private Long idSubategoria;

    @Column(name = "IdTipoReceta")
    private Long idTipoReceta;

    @Column(name = "Fecha", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Column(name = "Adjunto")
    private String adjunto;

    //Relaciones

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdUsuario", insertable = false, updatable = false)
    private Usuario usuario;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdCategoria", insertable = false, updatable = false)
    private Categoria categoria;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdSubcategoria", insertable = false, updatable = false)
    private Subcategoria subcategoria;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdTipoReceta", insertable = false, updatable = false)
    private TipoReceta tipoReceta;
}
