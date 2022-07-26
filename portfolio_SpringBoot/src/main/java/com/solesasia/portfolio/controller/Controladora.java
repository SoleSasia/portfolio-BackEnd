package com.solesasia.portfolio.controller;

import com.solesasia.portfolio.model.Educacion;
import com.solesasia.portfolio.service.IServiceEducacion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controladora {
    
    @Autowired
    private IServiceEducacion serviEdu;
    
    //Create
    @PostMapping ("/new/educacion")
    public void agregarEdu(@RequestBody Educacion edu){
        serviEdu.crearEducacion(edu);
    }
    
    //Read
    @GetMapping ("/ver/educaciones")
    @ResponseBody
    public List<Educacion> verEducaciones(){
        return serviEdu.verEducaciones();
    }
    
    //Update
    @PutMapping ("/actualizar/educacion")
    public void actualizarEdu(@RequestBody Educacion edu){
        serviEdu.crearEducacion(edu);
    }
    
    //Delete
    @DeleteMapping("/delete/{id}")
    public void borrarEducacion(@PathVariable Long id){
        serviEdu.borrarEducacion(id);
    }
}
