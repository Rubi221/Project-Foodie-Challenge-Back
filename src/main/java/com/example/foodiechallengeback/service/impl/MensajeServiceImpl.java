package com.example.foodiechallengeback.service.impl;

import com.example.foodiechallengeback.dto.MensajeDTO;
import com.example.foodiechallengeback.mapper.MensajeMapper;
import com.example.foodiechallengeback.model.Mensaje;
import com.example.foodiechallengeback.repository.IMensajeRepository;
import com.example.foodiechallengeback.service.interfaces.IMensajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MensajeServiceImpl implements IMensajeService{

    private IMensajeRepository mensajeRepository;

    //Obtiene la lista de todos los mensajes de una publicacion o reto
    @Override
    public List<Mensaje> findAllMensaje(Long idPublicacion, Long idReto){
        return this.mensajeRepository.findAllByIdPubliacionOrIdReto(idPublicacion, idReto);
    }

    //Obtiene la lista de todos los mensajes hijos de un mensaje padre
    @Override
    public List<Mensaje> findAllMensajesHijos(Long idPadre){
        return this.mensajeRepository.findAllByIdPadre(idPadre);
    }

    //Crea un mensaje
    @Override
    @Transactional
    public Mensaje createMensaje(MensajeDTO mensajeDTO){
        var mensaje = MensajeMapper.INSTANCE.toMensaje((mensajeDTO));
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
    public void setMensajeRepository(IMensajeRepository mensajeRepository){
        this.mensajeRepository = mensajeRepository;
    }
}
