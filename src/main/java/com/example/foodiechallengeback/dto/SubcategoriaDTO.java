package com.example.foodiechallengeback.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SubcategoriaDTO {

    private Long id;

    private String nombre;

    private Long idCategoria;
}
