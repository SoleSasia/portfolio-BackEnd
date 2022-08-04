package com.solesasia.portfolio.controller;

import com.solesasia.portfolio.model.Educacion;
import com.solesasia.portfolio.service.IServiceEducacion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin (origins = "http://localhost:4200")
@RestController
//AGREGAR REQUESTMAPPING EN FRONT
//@RequestMapping("/educacion")
public class EducacionControl {
    
    @Autowired
    private IServiceEducacion serviEdu;
    
    //Create
    @PostMapping ("/nueva")
    public void agregarEducacion(@RequestBody Educacion edu){
        serviEdu.crearEducacion(edu);
    }
    
    //Read - Lista
    @GetMapping ("/ver")
    @ResponseBody
    public List<Educacion> listarEducaciones(){
        return serviEdu.listarEducaciones();
    }
    
    //Buscar
    @GetMapping ("/ver/{id}")
    @ResponseBody
    public Educacion buscarEducacion(@PathVariable Long id){
        return serviEdu.buscarEducacion(id);
    }
    
    //Update
    @PutMapping ("/actualizar/{id}")
    public void editarEducacion(@PathVariable Long id, @RequestBody Educacion edu){
        serviEdu.crearEducacion(edu);
    }
    
    //Delete
    @DeleteMapping("/borrar/{id}")
    public void borrarEducacion(@PathVariable Long id){
        serviEdu.borrarEducacion(id);
    }
}
