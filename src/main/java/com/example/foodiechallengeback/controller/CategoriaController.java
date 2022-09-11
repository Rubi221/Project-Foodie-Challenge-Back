package com.example.foodiechallengeback.controller;

import com.example.foodiechallengeback.dto.CategoriaDTO;
import com.example.foodiechallengeback.mapper.CategoriaMapper;
import com.example.foodiechallengeback.service.interfaces.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

    private ICategoriaService categoriaService;

    //Obtiene la lista de todos las categorias
    @GetMapping("/all")
    public ResponseEntity<List<CategoriaDTO>> getAllCategoria(){
        return new ResponseEntity<>(this.categoriaService.findAllCategoria().stream().map(CategoriaMapper.INSTANCE::toCategoriaDTO).collect(Collectors.toList()), HttpStatus.OK);
    }

    //Inyecciones
    @Autowired
    public void setCategoriaService(ICategoriaService categoriaService){ this.categoriaService = categoriaService; }
}
