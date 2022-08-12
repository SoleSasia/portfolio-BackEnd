package com.solesasia.portfolio.controller;

import com.solesasia.portfolio.model.Educacion;
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
import com.solesasia.portfolio.service.IEducacionService;

@CrossOrigin (origins = "http://localhost:4200")
@RestController
//AGREGAR REQUESTMAPPING EN FRONT
//@RequestMapping("/educacion")
public class Controladora {
    
    @Autowired
    private IEducacionService serviEdu;
    
    //Create
    @PostMapping ("/nuevaEdu")
    public String agregarEducacion(@RequestBody Educacion edu){
        serviEdu.crearEducacion(edu);
        return "El elemento educación fue creado satisfactoriamente";
    }
    
    //Read - Lista
    @GetMapping ("/listaEdu")
    @ResponseBody
    public List<Educacion> listarEducaciones(){
        return serviEdu.listarEducaciones();
    }
    
    //Buscar
    @GetMapping ("/verEdu/{id}")
    @ResponseBody
    public Educacion buscarEducacion(@PathVariable Long id){
        return serviEdu.buscarEducacion(id);
    }
    
    //Update
    @PutMapping ("/editarEdu/{id}")
    public void editarEducacion(@PathVariable Long id, @RequestBody Educacion edu){
        serviEdu.crearEducacion(edu);
    }
    
    //Delete
    @DeleteMapping("/borrarEdu/{id}")
    public String borrarEducacion(@PathVariable Long id){
        serviEdu.borrarEducacion(id);
        return "El elemento educación fue eliminado satisfactoriamente";
    }
}
