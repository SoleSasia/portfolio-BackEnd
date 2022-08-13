package com.solesasia.portfolio.service;

import com.solesasia.portfolio.model.Educacion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.solesasia.portfolio.repository.EducacionRepository;

//esta clase implementa la interfaz donde están declarados los métodos CRUD
@Service
public class EducacionService implements IEducacionService {

    /* Inyecto el repositorio 
    La interfaz EducacionRepository (en la capa repository) será quien haga la conexion 
    con JPA y será la intermediaria entre la base de datos y todos los metodos de JPA*/
    @Autowired
    public EducacionRepository repoEdu;

    //Create - Alta
    @Override
    public void crearEducacion(Educacion edu) {
        repoEdu.save(edu);
    }

    //Read - Lectura
    @Override
    public List<Educacion> listarEducaciones() {
        return repoEdu.findAll();
    }

    //Update - Actualizar
    @Override
    public String editarEducacion(Long id, Educacion edu) {
        edu.setId(id);
        if (edu != null && repoEdu.existsById(edu.getId())) {
            repoEdu.save(edu);
            return "El elemento educación fue modificado satisfactoriamente.";
        }else {
            return "El elemento educación no fue encontrado en la base de datos.";
        }
    }

    //Delete - Baja
    @Override
    public void borrarEducacion(Long id) {
        repoEdu.deleteById(id);
    }
    /*public ResponseEntity<?> delete() {
        return new ResponseEntity (new Mensaje("La educacion ha sido elimindada"),HttpStatus.OK)
    };   */

    /*
    //Buscar
    @Override
    public Educacion buscarEducacion(Long id) {
        return repoEdu.findById(id).orElse(null);
    }
    */
}
