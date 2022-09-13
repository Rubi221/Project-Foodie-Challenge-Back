package com.example.foodiechallengeback.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "Reto_Subcategoria")
public class RetoSubCategoria {

    //Atributos

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "IdReto")
    private Long idReto;

    @Column(name = "IdSubcategoria")
    private Long idSubcategoria;

    //Relaciones

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdReto", insertable = false, updatable = false)
    private Reto reto;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdSubcategoria", insertable = false, updatable = false)
    private Subcategoria subcategoria;
}
