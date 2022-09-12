package com.example.foodiechallengeback.service.interfaces;

import com.example.foodiechallengeback.dto.InscritoRetoDTO;
import com.example.foodiechallengeback.dto.RetoDTO;
import com.example.foodiechallengeback.model.Chef;
import com.example.foodiechallengeback.model.Reto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Interfaz para manejar retos
 * @autor Rubi Utima
 */
@Service
public interface IRetoService {
    //Obtiene el usuario que crea un reto
    Chef obtenerAutorReto(Long idReto);

    // Obtiene un reto dado un idReto y un idUsuario
    InscritoRetoDTO obtenerRetoById(Long idReto, Long idUsuario);

    List<Reto> obtenerRetosAbiertos();

    // Obtiene la lista de retos abiertos e inscritos dado un usuario
    List<InscritoRetoDTO> obtenerRetosAbiertosInscrito(Long idUsuario);

    @Transactional
    Reto createReto(RetoDTO retoDTO) throws Exception;

    //Actualiza un nuevo reto
    @Transactional
    Reto updateReto(RetoDTO retoDTO) throws Exception;
}
