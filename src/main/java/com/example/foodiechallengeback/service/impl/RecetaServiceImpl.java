package com.example.foodiechallengeback.service.impl;

import com.example.foodiechallengeback.dto.RecetaDTO;
import com.example.foodiechallengeback.mapper.RecetaMapper;
import com.example.foodiechallengeback.model.Receta;
import com.example.foodiechallengeback.repository.IRecetaRepository;
import com.example.foodiechallengeback.service.interfaces.IRecetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Servicio que implementa la interfaz para manejar recetas
 * @autor Rubi Utima
 */
@Service
public class RecetaServiceImpl implements IRecetaService {
    private IRecetaRepository recetaRepository;


    // Obtiene todas las recetas segun idTipoReceta
    @Override
    public List<Receta> obtenerAllReceta(){
        return this.recetaRepository.findAll();
    }

    // Obtiene una receta por id
    @Override
    public Receta obtenerRecetaById(Long aId){
        return this.recetaRepository.findById(aId).orElse(null);
    }

    //Crea una receta
    @Override
    @Transactional
    public Receta createReceta(RecetaDTO recetaDTO){
        var receta = RecetaMapper.INSTANCE.toReceta(recetaDTO);
        return this.recetaRepository.save(receta);
    }

    //Elimina un reto
    @Override
    @Transactional
    public void deleteReceta(Long aId) throws Exception {
        var recetaBD = recetaRepository.findById(aId).orElse(null);
        if(recetaBD != null){
            this.recetaRepository.deleteById(recetaBD.getId());
        }else{
            throw new Exception("Id no encontrado");
        }
    }


    //Inyecciones
    @Autowired
    public void setRecetaRepository(IRecetaRepository recetaRepository) {
        this.recetaRepository = recetaRepository;
    }
}
