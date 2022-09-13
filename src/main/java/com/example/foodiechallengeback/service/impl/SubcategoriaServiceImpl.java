package com.example.foodiechallengeback.service.impl;

import com.example.foodiechallengeback.model.Subcategoria;
import com.example.foodiechallengeback.repository.ISubcategoriaRepository;
import com.example.foodiechallengeback.service.interfaces.ISubcategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubcategoriaServiceImpl implements ISubcategoriaService {

    private ISubcategoriaRepository subcategoriaRepository;

    //Obtiene la lista de categorias
    @Override
    public List<Subcategoria>findAllSubcategoria(){
        return this.subcategoriaRepository.findAll();
    }


    //Inyecciones
    @Autowired
    public void setSubcategoriaRepository(ISubcategoriaRepository subcategoriaRepository){ this.subcategoriaRepository = subcategoriaRepository; }
}
