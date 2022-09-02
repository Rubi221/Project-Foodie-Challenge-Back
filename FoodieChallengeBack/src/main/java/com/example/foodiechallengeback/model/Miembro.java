package com.example.foodiechallengeback.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

/**
 * Clase para el manejo de Chefs
 *
 * @author Rubi Utima
 * @since 1.0
 */

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "miembro")
public class Miembro {

    //Atributos

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "IdUsuario")
    private Long idUsuario;

    @Column(name = "NivelActividad")
    private String nivelActividad;

    //Relaciones

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdUsuario", insertable = false, updatable = false)
    private Usuario usuario;
}
