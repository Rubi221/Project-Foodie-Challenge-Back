package com.example.foodiechallengeback.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

/**
 * Clase para el manejo de detalles inscripciones
 *
 * @author Rubi Utima
 * @since 1.0
 */

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "detalle_inscripcion")
public class DetalleInscripcion {

    //Atributos

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "IdInscripcionReto", updatable = false)
    private Long idInscripcionReto;

    @Column(name = "CalificacionFinal")
    private Long calificacionFinal;

    @Column(name = "Video")
    private String video;

    @Column(name = "AdjuntoImg")
    private String adjuntoImg;

    //Relaciones

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdInscripcionReto", insertable = false, updatable = false)
    private InscripcionReto inscripcionReto;

}
