
package com.solesasia.portfolio.service;

import com.solesasia.portfolio.model.Proyecto;
import com.solesasia.portfolio.repository.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService implements IProyectoService {

    @Autowired
    public ProyectoRepository repoProyecto;
    
    @Override
    public void crearProyecto(Proyecto proyecto) {
        repoProyecto.save(proyecto);
    }

    @Override
    public boolean editarProyecto(Long id, Proyecto proyecto) {
        if (!repoProyecto.existsById(id)) {
            return false;
        } else {
            proyecto.setId(id);
            repoProyecto.save(proyecto);
            return true;
        }
    }

    @Override
    public void borrarProyecto(Long id) {
        repoProyecto.deleteById(id);
    }
    
}
