package com.example.foodiechallengeback.service.interfaces;

import com.example.foodiechallengeback.dto.RetoDTO;
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
    List<Reto> obtenerRetosAbiertos();

    @Transactional
    Reto createReto(RetoDTO retoDTO) throws Exception;
}
