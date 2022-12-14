package com.example.foodiechallengeback.service.impl;

import com.example.foodiechallengeback.dto.PublicacionDTO;
import com.example.foodiechallengeback.mapper.PublicacionMapper;
import com.example.foodiechallengeback.model.Publicacion;
import com.example.foodiechallengeback.repository.IPublicacionRepository;
import com.example.foodiechallengeback.repository.ISeccionForoRepository;
import com.example.foodiechallengeback.repository.IUsuarioRepository;
import com.example.foodiechallengeback.service.interfaces.IPublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PublicacionServiceImpl implements IPublicacionService {

    private IPublicacionRepository publicacionRepository;
    private ISeccionForoRepository seccionForoRepository;
    private IUsuarioRepository usuarioRepository;

    //Obtiene una lista de publicaciones
    @Override
    public List<Publicacion> findAllPublicacion(Long idSeccion, Long idUsuario){
        return this.publicacionRepository.findAllByIdSeccionOrIdUsuario(idSeccion, idUsuario);
    }

    //Crea una publicacion
    @Override
    @Transactional
    public Publicacion createPublicacion(PublicacionDTO publicacionDTO){
        var mensaje = PublicacionMapper.INSTANCE.toPublicacion((publicacionDTO));
        var publicacionBD =  this.publicacionRepository.save(mensaje);
        var seccion = this.seccionForoRepository.findById(publicacionBD.getIdSeccionForo()).orElse(null);
        var usuario = this.usuarioRepository.findById(publicacionBD.getIdUsuario()).orElse(null);
        publicacionBD.setSeccionForo(seccion);
        publicacionBD.setUsuario(usuario);
        return publicacionBD;
    }

    //Actualiza una publicacion
    @Override
    @Transactional
    public Publicacion updatePublicacion(PublicacionDTO publicacionDTO) throws Exception {
        Publicacion publicacionBD = this.publicacionRepository.findById(publicacionDTO.getId()).orElse(null);
        if(publicacionBD != null){
            publicacionBD.setContenido(publicacionDTO.getContenido());
            publicacionBD.setIdSeccionForo(publicacionDTO.getIdSeccionForo());
            publicacionBD.setFecha(publicacionDTO.getFecha());
            publicacionBD.setAdjunto(publicacionDTO.getAdjunto());
            this.publicacionRepository.save(publicacionBD);
            var seccion = this.seccionForoRepository.findById(publicacionBD.getIdSeccionForo()).orElse(null);
            var usuario = this.usuarioRepository.findById(publicacionBD.getIdUsuario()).orElse(null);
            publicacionBD.setSeccionForo(seccion);
            publicacionBD.setUsuario(usuario);
            return publicacionBD;
        }else{
            throw new Exception("Id no encontrado");
        }
    }

    //Elimina una publicacion
    @Override
    @Transactional
    public void deletePublicacion(Long aId) {
        var publicacionBD = publicacionRepository.findById(aId).orElse(null);
        this.publicacionRepository.deleteById(publicacionBD.getId());
    }

    //Inyecciones
    @Autowired
    public void setPublicacionRepository(IPublicacionRepository publicacionRepository){
        this.publicacionRepository = publicacionRepository;
    }
    @Autowired
    public void setSeccionForoRepository(ISeccionForoRepository seccionForoRepository){
        this.seccionForoRepository = seccionForoRepository;
    }
    @Autowired
    public void setUsuarioRepository(IUsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
}
