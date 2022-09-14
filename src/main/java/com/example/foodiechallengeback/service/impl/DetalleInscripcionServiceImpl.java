package com.example.foodiechallengeback.service.impl;

import com.example.foodiechallengeback.dto.DetalleInscripcionDTO;
import com.example.foodiechallengeback.mapper.DetalleInscripcionMapper;
import com.example.foodiechallengeback.model.DetalleInscripcion;
import com.example.foodiechallengeback.repository.IDetalleInscripcionRepository;
import com.example.foodiechallengeback.service.interfaces.IDetalleInscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Servicio que implementa la interfaz para manejar DetalleInscripcion
 * @autor Rubi Utima
 */
@Service
public class DetalleInscripcionServiceImpl implements IDetalleInscripcionService {

    private IDetalleInscripcionRepository detalleInscripcionRepository;

    // Obtiene un detalle de inscripcion
    @Override
    public DetalleInscripcion obtenerDetalleByIdInscripcion(Long idInscripcion){
        return this.detalleInscripcionRepository.findByIdInscripcionReto(idInscripcion);
    }

    // Obtiene todas las entregas de un reto
    @Override
    public List<DetalleInscripcion> obtenerDetallesByIdReto(Long idReto){
        return this.detalleInscripcionRepository.findAllDetallesByIdReto(idReto);
    }

    //Crea una detalle inscripcion
    @Override
    @Transactional
    public DetalleInscripcion createDetalleInscripcion(DetalleInscripcionDTO detalleInscripcionDTO) throws Exception {
        DetalleInscripcion detalleInscripcion = DetalleInscripcionMapper.INSTANCE.toDetalleInscripcion(detalleInscripcionDTO);
        this.validateEntregaHecha(detalleInscripcion);
        detalleInscripcion.setCalificacionFinal(0L);
        return this.detalleInscripcionRepository.save(detalleInscripcion);
    }

    //Actualiza una detalle inscripcion
    @Override
    @Transactional
    public DetalleInscripcion updateDetalleInscripcion(DetalleInscripcionDTO detalleInscripcionDTO) throws Exception {
        DetalleInscripcion detalleInscripcionBD = this.detalleInscripcionRepository.findById(detalleInscripcionDTO.getId()).orElse(null);
        if(detalleInscripcionBD != null){
            detalleInscripcionBD.setAdjuntoImg(detalleInscripcionDTO.getAdjuntoImg());
            detalleInscripcionBD.setVideo(detalleInscripcionDTO.getVideo());
            return this.detalleInscripcionRepository.save(detalleInscripcionBD);
        }else{
            throw new Exception("Id no encontrado");
        }
    }

    //Valida si un miembro ya creo una entrega a un reto
    private void validateEntregaHecha(DetalleInscripcion detalleInscripcion) throws Exception {
        var detalleBD = this.detalleInscripcionRepository.findByIdInscripcionReto(detalleInscripcion.getIdInscripcionReto());
        if(detalleBD != null){
            throw new Exception("El miembro ya ha creado una entrega para este reto");
        }
    }

    //Inyecciones
    @Autowired
    public void setDetalleInscripcionRepository(IDetalleInscripcionRepository detalleInscripcionRepository) {
        this.detalleInscripcionRepository = detalleInscripcionRepository;
    }
}
