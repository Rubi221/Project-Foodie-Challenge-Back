package com.example.foodiechallengeback.service.interfaces;

import com.example.foodiechallengeback.model.Subcategoria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ISubcategoriaService {
    List<Subcategoria> findAllSubcategoria();
}
