package com.example.foodiechallengeback.service.interfaces;

import com.example.foodiechallengeback.dto.MensajeDTO;
import com.example.foodiechallengeback.model.Mensaje;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public interface IMensajeService {

    List<Mensaje> findAllMensaje();

    @Transactional
    Mensaje createMensaje(MensajeDTO mensajeDTO);

    @Transactional
    void deleteMensaje(Long aId);
}
