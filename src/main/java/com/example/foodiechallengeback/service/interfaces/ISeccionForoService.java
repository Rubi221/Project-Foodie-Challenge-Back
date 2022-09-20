package com.example.foodiechallengeback.service.interfaces;

import com.example.foodiechallengeback.model.SeccionForo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Interfaz para manejar secciones
 * @autor Rubi Utima
 */
@Service
public interface ISeccionForoService {
    //Obtiene todas las secciones
    List<SeccionForo> getAll();
}
