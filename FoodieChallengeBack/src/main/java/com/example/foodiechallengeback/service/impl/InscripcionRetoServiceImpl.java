package com.example.foodiechallengeback.service.impl;

import com.example.foodiechallengeback.model.InscripcionReto;
import com.example.foodiechallengeback.repository.IInscripcionRetoRepository;
import com.example.foodiechallengeback.repository.IMiembroRepository;
import com.example.foodiechallengeback.repository.IRetoRepository;
import com.example.foodiechallengeback.service.interfaces.IInscripcionRetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Servicio que implementa la interfaz para manejar inscripcion retos
 * @autor Rubi Utima
 */
@Service
public class InscripcionRetoServiceImpl implements IInscripcionRetoService {
    private IInscripcionRetoRepository inscripcionRetoRepository;
    private IRetoRepository retoRepository;
    private IMiembroRepository miembroRepository;

    // Obtiene la lista de inscripciones para un reto por IdReto
    @Override
    public List<InscripcionReto> obtenerInscripcionesReto(Long idReto){
        return this.inscripcionRetoRepository.findAllByIdReto(idReto);
    }

    //Crea una inscripcion a un reto
    @Override
    @Transactional
    public InscripcionReto createInscripcionReto(Long idReto, Long idMiembro) throws Exception {
        InscripcionReto inscripcionReto = new InscripcionReto();
        inscripcionReto.setIdReto(idReto);
        inscripcionReto.setIdMiembro(idMiembro);
        this.validateInscripcionHecha(inscripcionReto);
        this.inscripcionRetoRepository.save(inscripcionReto);
        return this.setValoresDTO(inscripcionReto);
    }

    //Asigna los valores para devolver en el DTO
    @Override
    @Transactional
    public InscripcionReto setValoresDTO(InscripcionReto inscripcionReto){
        var miembro = this.miembroRepository.findById(inscripcionReto.getIdMiembro()).orElse(null);
        var reto = this.retoRepository.findById(inscripcionReto.getIdReto()).orElse(null);
        if (miembro != null){
            inscripcionReto.setMiembro(miembro);
        }
        if (reto != null){
            inscripcionReto.setReto(reto);
        }
        return inscripcionReto;
    }

    //Valida si un miembro ya esta inscrito en un reto
    private void validateInscripcionHecha(InscripcionReto inscripcion) throws Exception {
        var inscripcionBD = this.inscripcionRetoRepository.findInscripcion(inscripcion.getIdReto(), inscripcion.getIdMiembro());
        if(inscripcionBD != null){
            throw new Exception("El miembro ya se ha inscrito a este reto");
        }
    }

    //Inyecciones
    @Autowired
    public void setInscripcionRetoRepository(IInscripcionRetoRepository inscripcionRetoRepository) {
        this.inscripcionRetoRepository = inscripcionRetoRepository;
    }
    @Autowired
    public void setRetoRepository(IRetoRepository retoRepository) {
        this.retoRepository = retoRepository;
    }
    @Autowired
    public void setMiembroRepository(IMiembroRepository miembroRepository) {
        this.miembroRepository = miembroRepository;
    }
}