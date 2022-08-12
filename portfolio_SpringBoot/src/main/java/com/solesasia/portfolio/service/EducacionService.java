package com.solesasia.portfolio.service;

//esta clase implementa la interfaz donde están declarados los métodos CRUD
import com.solesasia.portfolio.model.Educacion;
import com.solesasia.portfolio.repository.RepEducacion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EducacionService implements IEducacionService {

    /* Inyecto el repositorio 
    La interfaz RepEducacion (en la capa repository) será quien haga la conexion 
    con JPA y será la intermediaria entre la base de datos y todos los metodos de JPA*/
    @Autowired
    public RepEducacion repoEdu;

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
    public void editarEducacion(Educacion edu) {
        repoEdu.save(edu);
    }    

    //Delete - Baja
    @Override
    public void borrarEducacion(Long id) {
        repoEdu.deleteById(id);
    }
    /*public ResponseEntity<?> delete() {
        return new ResponseEntity (new Mensaje("La educacion ha sido elimindada"),HttpStatus.OK)
    };   */

    //Buscar
    @Override
    public Educacion buscarEducacion(Long id) {
        return repoEdu.findById(id).orElse(null);
    }

}
