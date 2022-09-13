package com.example.foodiechallengeback.service.interfaces;


import com.example.foodiechallengeback.dto.PublicacionDTO;
import com.example.foodiechallengeback.model.Publicacion;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public interface IPublicacionService {


    //Obtiene una lista de publicaciones
    List<Publicacion> findAllPublicacion(Long idSeccion, Long idUsuario);

    @Transactional
    Publicacion createPublicacion(PublicacionDTO publicacionDTO);

    @Transactional
    Publicacion updatePublicacion(PublicacionDTO publicacionDTO) throws Exception;
    @Transactional
    void deletePublicacion(Long aId);
}
