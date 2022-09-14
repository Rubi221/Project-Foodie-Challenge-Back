package com.example.foodiechallengeback.controller;

import com.example.foodiechallengeback.dto.SubcategoriaDTO;
import com.example.foodiechallengeback.mapper.SubcategoriaMapper;
import com.example.foodiechallengeback.service.interfaces.ISubcategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/subcategoria")
public class SubcategoriaController {

    private ISubcategoriaService subcategoriaService;

    @GetMapping("/all")
    public ResponseEntity<List<SubcategoriaDTO>> getAllCategoria(){
        return new ResponseEntity<>(this.subcategoriaService.findAllSubcategoria().stream().map(SubcategoriaMapper.INSTANCE::toSubcategoriaDTO).collect(Collectors.toList()), HttpStatus.OK);
    }


    //Inyecciones
    @Autowired
    public void setSubcategoriaService(ISubcategoriaService subcategoriaService){ this.subcategoriaService = subcategoriaService; }
}
