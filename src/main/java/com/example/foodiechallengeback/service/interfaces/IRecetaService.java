package com.example.foodiechallengeback.service.interfaces;

import com.example.foodiechallengeback.dto.RecetaDTO;
import com.example.foodiechallengeback.model.Receta;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Interfaz para manejar recetas
 * @autor Rubi Utima
 */
@Service
public interface IRecetaService {
    // Obtiene todas las recetas segun idTipoReceta
    List<Receta> obtenerRecetaByIdTipoReceta(Long idTipoReceta);

    // Obtiene la lista de retos abiertos
    Receta obtenerRecetaById(Long aId);

    //Crea una receta
    @Transactional
    Receta createReceta(RecetaDTO recetaDTO);

    //Elimina un reto
    @Transactional
    void deleteReceta(Long aId) throws Exception;
}
