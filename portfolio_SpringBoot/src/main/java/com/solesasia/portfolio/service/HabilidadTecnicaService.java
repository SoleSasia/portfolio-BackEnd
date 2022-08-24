
package com.solesasia.portfolio.service;

import com.solesasia.portfolio.model.HabilidadTecnica;
import com.solesasia.portfolio.repository.HabilidadTecnicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HabilidadTecnicaService implements IHabilidadTecnicaService {

    @Autowired
    public HabilidadTecnicaRepository repoHabTecnica;

    @Override
    public void crearHabTecnica(HabilidadTecnica habTecnica) {
        repoHabTecnica.save(habTecnica);
    }             
                
    @Override
    public boolean editarHabTecnica(Long id, HabilidadTecnica habTecnica) {
        if (!repoHabTecnica.existsById(id)) {
            return false;
        } else {
            habTecnica.setId(id);
            repoHabTecnica.save(habTecnica);
            return true;
        }
    }

    @Override
    public void borrarHabTecnica(Long id) {
        repoHabTecnica.deleteById(id);
    }
    
    }
