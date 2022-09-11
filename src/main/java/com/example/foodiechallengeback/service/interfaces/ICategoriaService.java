package com.example.foodiechallengeback.service.interfaces;

import com.example.foodiechallengeback.model.Categoria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICategoriaService {

    List<Categoria> findAllCategoria();
}
