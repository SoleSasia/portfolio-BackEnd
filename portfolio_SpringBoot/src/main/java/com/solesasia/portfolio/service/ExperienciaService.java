
package com.solesasia.portfolio.service;

import com.solesasia.portfolio.model.Experiencia;
import com.solesasia.portfolio.repository.ExperienciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaService implements IExperienciaService {
    
    @Autowired
    public ExperienciaRepository repoExpe;

    
    @Override
    public void crearExperiencia(Experiencia expe) {
        repoExpe.save(expe);
    }

/*
    @Override
    public List<Experiencia> listarExperiencias() {
       return repoExpe.findAll();
    }
*/

    @Override
    public boolean editarExperiencia(Long id, Experiencia expe) {
        if (!repoExpe.existsById(id)) {
            return false;
        } else {
            expe.setId(id);
            repoExpe.save(expe);
            return true;
        }
    }

    @Override
    public void borrarExperiencia(Long id) {
        repoExpe.deleteById(id);
    }
    
    
}
