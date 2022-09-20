package com.example.foodiechallengeback.service.impl;

import com.example.foodiechallengeback.model.SeccionForo;
import com.example.foodiechallengeback.repository.ISeccionForoRepository;
import com.example.foodiechallengeback.service.interfaces.ISeccionForoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio que implementa la interfaz para manejar secciones
 * @autor Rubi Utima
 */
@Service
public class SeccionForoServiceImpl implements ISeccionForoService {

    private ISeccionForoRepository seccionForoRepository;

    //Obtiene todas las secciones
    @Override
    public List<SeccionForo> getAll(){
        return this.seccionForoRepository.findAll();
    }

    //Inyeccciones
    @Autowired
    public void setSeccionForoRepository(ISeccionForoRepository seccionForoRepository) {
        this.seccionForoRepository = seccionForoRepository;
    }
}
