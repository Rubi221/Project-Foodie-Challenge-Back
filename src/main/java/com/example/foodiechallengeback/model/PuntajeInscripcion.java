package com.example.foodiechallengeback.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "Puntaje_Inscripcion")
public class PuntajeInscripcion {

    //Atributos

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "IdInscripcionReto")
    private Long idInscripcionReto;

    @Column(name = "IdMiembro")
    private Long idMiembro;

    @Column(name = "Puntaje")
    private Long puntaje;

    //Relaciones

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdInscripcionReto", insertable = false, updatable = false)
    private InscripcionReto inscripcionReto;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdMiembro", insertable = false, updatable = false)
    private Miembro miembro;
}
