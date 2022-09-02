package com.example.foodiechallengeback.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

/**
 * Clase para el manejo de Categorias
 *
 * @author Rubi Utima
 * @since 1.0
 */

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Nombre")
    private String nombre;
}
