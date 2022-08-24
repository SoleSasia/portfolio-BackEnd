
package com.solesasia.portfolio.service;

import com.solesasia.portfolio.model.HabilidadBlanda;
import com.solesasia.portfolio.repository.HabilidadBlandaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HabilidadBlandaService implements IHabilidadBlandaService {

    @Autowired
    public HabilidadBlandaRepository repoHabBlanda;

    @Override
    public void crearHabBlanda(HabilidadBlanda habBlanda) {
        repoHabBlanda.save(habBlanda);
    }

    @Override
    public boolean editarHabBlanda(Long id, HabilidadBlanda habBlanda) {
        if (!repoHabBlanda.existsById(id)) {
            return false;
        } else {
            habBlanda.setId(id);
            repoHabBlanda.save(habBlanda);
            return true;
        }
    }

    @Override
    public void borrarHabBlanda(Long id) {
        repoHabBlanda.deleteById(id);
    }

    
}