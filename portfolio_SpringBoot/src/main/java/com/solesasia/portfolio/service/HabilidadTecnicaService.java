
package com.solesasia.portfolio.service;

import com.solesasia.portfolio.model.HabilidadTecnica;
import com.solesasia.portfolio.repository.HabilidadTecnicaRepository;
import java.util.List;
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
/*
    @Override
    public List<HabilidadTecnica> listarHabTecnicas() {
        return repoHabTecnica.findAll();
    }
*/                
                
    @Override
    public String editarHabTecnica(Long id, HabilidadTecnica habTecnica) {
        if(!repoHabTecnica.existsById(id)) {
            return "El elemento ha ser modificado no existe";
        } 
            habTecnica.setId(id);
            repoHabTecnica.save(habTecnica);
            return "El elemento Habilidad Técnica ha sido modificado satisfactoriamente.";     
    }

    @Override
    public void borrarHabTecnica(Long id) {
        repoHabTecnica.deleteById(id);
    }
    
    }
