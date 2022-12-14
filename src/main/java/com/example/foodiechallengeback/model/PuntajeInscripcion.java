package com.example.foodiechallengeback.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "puntaje_inscripcion")
public class PuntajeInscripcion {

    //Atributos

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "IdDetalle")
    private Long idDetalle;

    @Column(name = "IdUsuario")
    private Long idUsuario;

    @Column(name = "Puntaje")
    private Long puntaje;

    //Relaciones

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdDetalle", insertable = false, updatable = false)
    private DetalleInscripcion detalle;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdUsuario", insertable = false, updatable = false)
    private Usuario usuario;
}
