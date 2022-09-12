package com.example.foodiechallengeback.service.impl;

import com.example.foodiechallengeback.dto.InscritoRetoDTO;
import com.example.foodiechallengeback.dto.RetoDTO;
import com.example.foodiechallengeback.mapper.RetoMapper;
import com.example.foodiechallengeback.model.Chef;
import com.example.foodiechallengeback.model.InscripcionReto;
import com.example.foodiechallengeback.model.Miembro;
import com.example.foodiechallengeback.model.Reto;
import com.example.foodiechallengeback.repository.IChefRepository;
import com.example.foodiechallengeback.repository.IInscripcionRetoRepository;
import com.example.foodiechallengeback.repository.IMiembroRepository;
import com.example.foodiechallengeback.repository.IRetoRepository;
import com.example.foodiechallengeback.service.interfaces.IRetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Servicio que implementa la interfaz para manejar retos
 * @autor Rubi Utima
 */
@Service
public class RetoServiceImpl implements IRetoService {
    private IRetoRepository retoRepository;
    private IInscripcionRetoRepository inscripcionRetoRepository;
    private IMiembroRepository miembroRepository;
    private IChefRepository chefRepository;

    //Obtiene el usuario que crea un reto
    @Override
    public Chef obtenerAutorReto(Long idReto){
        List<Long> list = new ArrayList<>();
        Long idChef = this.retoRepository.findById(idReto).get().getIdChef();
        return this.chefRepository.findById(idChef).orElse(null);
    }

    // Obtiene un reto dado un idReto y un idUsuario
    @Override
    public InscritoRetoDTO obtenerRetoById(Long idReto, Long idUsuario){
        Miembro miembro = this.miembroRepository.findByIdUsuario(idUsuario);
        Reto reto = this.retoRepository.findById(idReto).orElse(null);
        InscritoRetoDTO retoDTO = RetoMapper.INSTANCE.toInscritoRetoDTO(reto);
        var inscripcion = this.inscripcionRetoRepository.findInscripcion(idReto, miembro.getId());
        retoDTO.setInscrito(inscripcion != null);
        return retoDTO;
    }

    // Obtiene la lista de retos abiertos
    @Override
    public List<Reto> obtenerRetosAbiertos(){
        return this.retoRepository.findAllAbiertas();
    }

    // Obtiene la lista de retos abiertos e inscritos dado un usuario
    @Override
    public List<InscritoRetoDTO> obtenerRetosAbiertosInscrito(Long idUsuario){
        var listaRetos = this.retoRepository.findAllAbiertas();
        Miembro miembro = this.miembroRepository.findByIdUsuario(idUsuario);
        var inscripciones = this.inscripcionRetoRepository.findInscripcionRetoByIdMiembro(miembro.getId());
        var listaRetosDTO = listaRetos.stream().map(RetoMapper.INSTANCE::toInscritoRetoDTO).collect(Collectors.toList());
        var idRetosList = inscripciones.stream().map(InscripcionReto::getIdReto).collect(Collectors.toList());
        for (InscritoRetoDTO reto:listaRetosDTO) {
            reto.setInscrito(idRetosList.contains(reto.getId()));
        }
        return listaRetosDTO;
    }

    //Crea un nuevo reto
    @Override
    @Transactional
    public Reto createReto(RetoDTO retoDTO) throws Exception {
        var reto = RetoMapper.INSTANCE.toReto(retoDTO);
        this.validateFechas(reto);
        return this.retoRepository.save(reto);
    }

    //Actualiza un nuevo reto
    @Override
    @Transactional
    public Reto updateReto(RetoDTO retoDTO) throws Exception {
        var retoBD = this.retoRepository.findById(retoDTO.getId()).orElse(null);
        this.validateFechas(RetoMapper.INSTANCE.toReto(retoDTO));
        if (retoBD != null){
            retoBD.setTitulo(retoDTO.getTitulo());
            retoBD.setContenido(retoDTO.getContenido());
            retoBD.setDificultad(retoDTO.getDificultad());
            retoBD.setVideo(retoDTO.getVideo());
            retoBD.setIdCategoria(retoDTO.getIdCategoria());
            retoBD.setFechaInicio(retoDTO.getFechaInicio());
            retoBD.setFechaFin(retoDTO.getFechaFin());
        }else{
            throw new Exception("Id no encontrado");
        }
        return this.retoRepository.save(retoBD);
    }

    //Valida las fechas ingresadas para creacion de un reto
    private void validateFechas(Reto reto) throws Exception {
        Long dias = ((reto.getFechaFin().getTime() - reto.getFechaInicio().getTime())/86400000L);
        if(reto.getFechaInicio().before(new Date())){
            throw new Exception("La fecha de inicio debe ser mayor a la fecha actual");
        } else if(reto.getFechaFin().before(reto.getFechaInicio())){
            throw new Exception("La fecha de fin debe ser mayor a la fecha de inicio");
        }else if (dias > 30) {
            throw new Exception("La duracion del reto debe ser menor a 30 dias");
        }
    }

    //Inyecciones
    @Autowired
    public void setRetoRepository(IRetoRepository retoRepository) {
        this.retoRepository = retoRepository;
    }
    @Autowired
    public void setInscripcionRetoRepository(IInscripcionRetoRepository inscripcionRetoRepository) {
        this.inscripcionRetoRepository = inscripcionRetoRepository;
    }
    @Autowired
    public void setMiembroRepository(IMiembroRepository miembroRepository) {
        this.miembroRepository = miembroRepository;
    }
    @Autowired
    public void setChefRepository(IChefRepository chefRepository) {
        this.chefRepository = chefRepository;
    }
}