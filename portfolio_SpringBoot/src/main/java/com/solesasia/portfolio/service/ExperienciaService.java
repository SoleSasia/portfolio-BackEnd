
package com.solesasia.portfolio.service;

import com.solesasia.portfolio.model.Experiencia;
import com.solesasia.portfolio.repository.ExperienciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaService {
    
    @Autowired
    public ExperienciaRepository repoExpe;
    
    public void crearExperiencia(Experiencia expe){
        repoExpe.save(expe);
    }
    
    public List<Experiencia> listarExperiencias(){
        return repoExpe.findAll();
    }
    
    public String editarExperiencia(Long id, Experiencia expe){
        expe.setId(id);
        if (expe != null && repoExpe.existsById(expe.getId())) {
            repoExpe.save(expe);
            return "El elemento experiencia fue modificado satisfactoriamente.";
        }else {
            return "El elemento experiencia no fue encontrado en la base de datos.";
        }
    }
    
    public void borrarExperiencia(Long id){
        repoExpe.deleteById(id);
    }
}
