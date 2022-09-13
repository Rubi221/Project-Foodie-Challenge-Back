package com.example.foodiechallengeback.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "Sigue_Chef")
public class SigueChef {

    //Atributos

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "IdUsuarioChef")
    private Long idUsuarioChef;

    @Column(name = "IdUsuarioMiembro")
    private Long idUsuarioMiembro;

    @Column(name = "Fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    //Relaciones

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdUsuarioChef", insertable = false, updatable = false)
    private Usuario usuarioChef;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdUsuarioMiembro", insertable = false, updatable = false)
    private Usuario usuarioMiembro;
}
