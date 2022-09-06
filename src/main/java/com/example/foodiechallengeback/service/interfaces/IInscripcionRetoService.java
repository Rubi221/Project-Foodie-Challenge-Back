package com.example.foodiechallengeback.service.interfaces;

import com.example.foodiechallengeback.model.InscripcionReto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Interfaz para manejar inscripcion Retos
 * @autor Rubi Utima
 */
@Service
public interface IInscripcionRetoService {
    // Obtiene la lista de inscripciones para un reto por IdReto
    List<InscripcionReto> obtenerInscripcionesReto(Long idReto);

    //Crea una inscripcion a un reto
    @Transactional
    InscripcionReto createInscripcionReto(Long idReto, Long idMiembro) throws Exception;

    //Asigna los valores para devolver en el DTO
    @Transactional
    InscripcionReto setValoresDTO(InscripcionReto inscripcionReto);
}
