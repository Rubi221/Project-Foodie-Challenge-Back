package com.example.foodiechallengeback.service.interfaces;

import com.example.foodiechallengeback.dto.ComentarioDTO;
import com.example.foodiechallengeback.model.Comentario;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public interface IComentarioService {

    List<Comentario> findAllMensaje(Long idPublicacion, Long idReto);

    //Obtiene la lista de todos los mensajes hijos de un mensaje padre
    List<Comentario> findAllMensajesHijos(Long idPadre);

    @Transactional
    Comentario createMensaje(ComentarioDTO mensajeDTO);

    @Transactional
    void deleteMensaje(Long aId);
}
