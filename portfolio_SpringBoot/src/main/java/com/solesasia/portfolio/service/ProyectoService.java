
package com.solesasia.portfolio.service;

import com.solesasia.portfolio.model.Proyecto;
import com.solesasia.portfolio.repository.ProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;


public class ProyectoService implements IProyectoService {

    @Autowired
    public ProyectoRepository repoProyecto;
    
    @Override
    public void crearProyecto(Proyecto proyecto) {
        repoProyecto.save(proyecto);
    }

    @Override
    public List<Proyecto> listarProyectos() {
        return repoProyecto.findAll();
    }

    @Override
    public String editarProyecto(Long id, Proyecto proyecto) {
        if (!repoProyecto.existsById(id)) {
            return "El id del elemento proyecto no existe.";
        } else {
            proyecto.setId(id);
            repoProyecto.save(proyecto);
            return "El elemento proyecto fue modificado satisfactoriamente.";
        }
    }

    @Override
    public void borrarProyecto(Long id) {
        repoProyecto.deleteById(id);
    }
    
}
