package com.example.foodiechallengeback.service.interfaces;

import com.example.foodiechallengeback.dto.DetalleInscripcionDTO;
import com.example.foodiechallengeback.model.DetalleInscripcion;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Interfaz para manejar DetalleInscripcion
 * @autor Rubi Utima
 */
@Service
public interface IDetalleInscripcionService {
    // Obtiene un detalle de inscripcion
    DetalleInscripcion obtenerDetalleByIdInscripcion(Long idInscripcion);

    //Crea una detalle inscripcion
    @Transactional
    DetalleInscripcion createDetalleInscripcion(DetalleInscripcionDTO detalleInscripcionDTO) throws Exception;

    //Actualiza una detalle inscripcion
    @Transactional
    DetalleInscripcion updateDetalleInscripcion(DetalleInscripcionDTO detalleInscripcionDTO) throws Exception;
}
