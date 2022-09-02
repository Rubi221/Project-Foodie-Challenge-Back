package com.example.foodiechallengeback.service.impl;

import com.example.foodiechallengeback.dto.RetoDTO;
import com.example.foodiechallengeback.mapper.RetoMapper;
import com.example.foodiechallengeback.model.Reto;
import com.example.foodiechallengeback.repository.IRetoRepository;
import com.example.foodiechallengeback.service.interfaces.IRetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Servicio que implementa la interfaz para manejar retos
 * @autor Rubi Utima
 */
@Service
public class RetoServiceImpl implements IRetoService {
    private IRetoRepository retoRepository;

    // Obtiene la lista de retos abiertos
    @Override
    public List<Reto> obtenerRetosAbiertos(){
        return this.retoRepository.findAllAbiertas();
    }

    //Crea un nuevo reto
    @Override
    @Transactional
    public Reto createReto(RetoDTO retoDTO) throws Exception {
        var reto = RetoMapper.INSTANCE.toReto(retoDTO);
        this.validateFechas(reto);
        return this.retoRepository.save(reto);
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
}
