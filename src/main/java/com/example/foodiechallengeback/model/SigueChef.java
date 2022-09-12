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

    @Column(name = "IdChef")
    private Long idChef;

    @Column(name = "IdMiembro")
    private Long idMiembro;

    @Column(name = "Fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    //Relaciones

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdChef", insertable = false, updatable = false)
    private Chef chef;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdMiembro", insertable = false, updatable = false)
    private Miembro miembro;
}
