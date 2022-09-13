package com.example.foodiechallengeback.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "Publicacion_Foro")
public class Publicacion {

    //Atributos

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Column(name = "Contenido")
    private String contenido;

    @Column(name = "IdSeccionForo")
    private Long idSeccionForo;

    @Column(name = "IdUsuario")
    private Long idUsuario;

    @Column(name = "Adjunto")
    private String adjunto;

    @Column(name = "AdjuntoB")
    private String adjuntoBlob;


    //Relaciones

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdSeccionForo", insertable = false, updatable = false)
    private SeccionForo seccionForo;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdUsuario", insertable = false, updatable = false)
    private Usuario usuario;
}
