package com.example.foodiechallengeback.service.impl;

import com.example.foodiechallengeback.dto.ComentarioDTO;
import com.example.foodiechallengeback.mapper.ComentarioMapper;
import com.example.foodiechallengeback.model.Comentario;
import com.example.foodiechallengeback.repository.IComentarioRepository;
import com.example.foodiechallengeback.service.interfaces.IComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ComentarioServiceImpl implements IComentarioService {

    private IComentarioRepository mensajeRepository;

    //Obtiene la lista de todos los mensajes de una publicacion o reto
    @Override
    public List<Comentario> findAllMensaje(Long idPublicacion, Long idReto){
        return this.mensajeRepository.findAllByIdPubliacionOrIdReto(idPublicacion, idReto);
    }

    //Obtiene la lista de todos los mensajes hijos de un mensaje padre
    @Override
    public List<Comentario> findAllMensajesHijos(Long idPadre){
        return this.mensajeRepository.findAllByIdPadre(idPadre);
    }

    //Crea un mensaje
    @Override
    @Transactional
    public Comentario createMensaje(ComentarioDTO mensajeDTO){
        var mensaje = ComentarioMapper.INSTANCE.toMensaje((mensajeDTO));
        return this.mensajeRepository.save(mensaje);
    }

    //Elimina un mensaje
    @Override
    @Transactional
    public void deleteMensaje(Long aId) {
        var mensajeBD = mensajeRepository.findById(aId).orElse(null);
        this.mensajeRepository.deleteById(mensajeBD.getId());
    }

    //Inyecciones
    @Autowired
    public void setMensajeRepository(IComentarioRepository mensajeRepository){
        this.mensajeRepository = mensajeRepository;
    }
}
