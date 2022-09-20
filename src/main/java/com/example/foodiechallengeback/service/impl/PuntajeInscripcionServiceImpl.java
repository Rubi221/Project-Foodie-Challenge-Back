package com.example.foodiechallengeback.service.impl;

import com.example.foodiechallengeback.dto.PuntajeInscripcionDTO;
import com.example.foodiechallengeback.mapper.PuntajeInscripcionMapper;
import com.example.foodiechallengeback.model.PuntajeInscripcion;
import com.example.foodiechallengeback.repository.IDetalleInscripcionRepository;
import com.example.foodiechallengeback.repository.IPuntajeInscripcionRepository;
import com.example.foodiechallengeback.service.interfaces.IPuntajeInscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PuntajeInscripcionServiceImpl implements IPuntajeInscripcionService {

    private IPuntajeInscripcionRepository puntajeInscripcionRepository;

    private IDetalleInscripcionRepository detalleInscripcionRepository;

    //Obtiene todos los puntajes
    @Override
    public List<PuntajeInscripcion> findAllPuntajes(){
        return this.puntajeInscripcionRepository.findAll();
    }

    //Valida si se califico una inscripcion
    @Override
    public Boolean validateCalifica(Long idUsuario, Long idDetalle){
        Boolean califica = false;
        var puntaje = this.puntajeInscripcionRepository.findByIdDetalle(idDetalle, idUsuario);
        if(puntaje != null){
            califica = true;
        }
        return califica;
    }


    //Puntua una inscripcion
    @Override
    @Transactional
    public PuntajeInscripcion createPuntaje(PuntajeInscripcionDTO puntajeInscripcionDTO){
        var puntaje = PuntajeInscripcionMapper.INSTANCE.toPuntajeInscripcion(puntajeInscripcionDTO);
        var puntajeBD = this.puntajeInscripcionRepository.save(puntaje);
        var puntuacionFinal = this.puntajeInscripcionRepository.sumAllPuntajes(puntajeBD.getIdDetalle());
        var detalle = this.detalleInscripcionRepository.findById(puntajeBD.getIdDetalle()).orElse(null);
        detalle.setCalificacionFinal(puntuacionFinal);
        this.detalleInscripcionRepository.save(detalle);
        return puntajeBD;
    }

    //Inyecciones
    @Autowired
    public void setPuntajeInscripcionRepository(IPuntajeInscripcionRepository puntajeInscripcionRepository){
        this.puntajeInscripcionRepository = puntajeInscripcionRepository;
    }

    @Autowired
    public void setDetalleInscripcionRepository(IDetalleInscripcionRepository detalleInscripcionRepository) {
        this.detalleInscripcionRepository = detalleInscripcionRepository;
    }
}
