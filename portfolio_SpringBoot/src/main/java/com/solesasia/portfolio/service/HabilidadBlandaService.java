
package com.solesasia.portfolio.service;

import com.solesasia.portfolio.model.HabilidadBlanda;
import com.solesasia.portfolio.repository.HabilidadBlandaRepository;
import java.util.List;
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
    public List<HabilidadBlanda> listarHabBlandas() {
        return repoHabBlanda.findAll();
    }

    @Override
    public String editarHabBlanda(Long id, HabilidadBlanda habBlanda) {
        if (!repoHabBlanda.existsById(id)) {
            return "El id del elemento habilidad blanda no existe.";
        }
        habBlanda.setId(id);
        repoHabBlanda.save(habBlanda);
        return "El elemento habilidad blanda fue modificado satisfactoriamente.";
    }

    @Override
    public void borrarHabBlanda(Long id) {
        repoHabBlanda.deleteById(id);
    }

    
}