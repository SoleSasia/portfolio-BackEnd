
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

    @Override
    public List<Experiencia> listarExperiencias() {
       return repoExpe.findAll();
    }

    @Override
    public String editarExperiencia(Long id, Experiencia expe) {
        
        if (repoExpe.existsById(expe.getId())) {
            expe.setId(id);
            repoExpe.save(expe);
            return "El elemento experiencia fue modificado satisfactoriamente.";
        }else {
            return "El elemento experiencia no fue encontrado en la base de datos.";
        }
    }

    @Override
    public void borrarExperiencia(Long id) {
        repoExpe.deleteById(id);
    }
    
    
}
