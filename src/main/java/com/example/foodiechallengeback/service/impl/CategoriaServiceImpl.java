package com.example.foodiechallengeback.service.impl;

import com.example.foodiechallengeback.model.Categoria;
import com.example.foodiechallengeback.repository.ICategoriaRepository;
import com.example.foodiechallengeback.service.interfaces.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements ICategoriaService {

    private ICategoriaRepository categoriaRepository;

    //Obtiene la lista de categorias
    @Override
    public List<Categoria> findAllCategoria(){
        return this.categoriaRepository.findAll();
    }

    //Inyecciones
    @Autowired
    public void setCategoriaRepository(ICategoriaRepository categoriaRepository){ this.categoriaRepository = categoriaRepository; }
}
