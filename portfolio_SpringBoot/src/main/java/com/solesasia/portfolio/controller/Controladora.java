package com.solesasia.portfolio.controller;

import com.solesasia.portfolio.model.Educacion;
import com.solesasia.portfolio.model.Experiencia;
import com.solesasia.portfolio.model.HabilidadBlanda;
import com.solesasia.portfolio.model.HabilidadTecnica;
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
import com.solesasia.portfolio.service.IExperienciaService;
import com.solesasia.portfolio.service.IHabilidadBlandaService;
import com.solesasia.portfolio.service.IHabilidadTecnicaService;

@CrossOrigin (origins = "http://localhost:4200")
@RestController
public class Controladora {
    
    @Autowired private IEducacionService serviEdu;
    @Autowired private IExperienciaService serviExpe;
    @Autowired private IHabilidadTecnicaService serviHabTecnica;
    @Autowired private IHabilidadBlandaService serviHabBlanda;
    

// ABM HABILIDAD BLANDA // LLEVAR R A PORTFOLIODTO
    
    @PostMapping ("/nuevaHabBlanda")
    public void crearHabBlanda(@RequestBody HabilidadBlanda habBlanda){
        serviHabBlanda.crearHabBlanda(habBlanda);
    }
    
    @GetMapping ("ListaHabBlandas")
    @ResponseBody
    public List<HabilidadBlanda> listarHabBlandas(){
        return serviHabBlanda.listarHabBlandas();
    }
    
    @PutMapping ("/editarHabBlanda/{id}")
    public String editarHabBlanda(@PathVariable Long id, @RequestBody HabilidadBlanda habBlanda){
        return serviHabBlanda.editarHabBlanda(id, habBlanda);
    }
    
    @DeleteMapping ("/borrarHabBlanda/{id}")
    public void borrarHabBlanda(@PathVariable Long id){
        serviHabBlanda.borrarHabBlanda(id);
    }
    
    
// CRUD HABILIDAD TECNICA //
    
    @PostMapping ("/nuevaHabTecnica")
    public void crearHabTecnica(@RequestBody HabilidadTecnica habTecnica){
        serviHabTecnica.crearHabTecnica(habTecnica);
    }
    
    @GetMapping ("/listaHabTecnicas")
    @ResponseBody
    public List<HabilidadTecnica> listarHabTecnicas(){
        return serviHabTecnica.listarHabTecnicas();
    }
    
    @PutMapping ("/editarHabTecnica/{id}")
    public String editarHabTecnica(@PathVariable Long id, @RequestBody HabilidadTecnica habTecnica) {
        return serviHabTecnica.editarHabTecnica(id, habTecnica);
    }
    
    @DeleteMapping ("borrarHabTecnica/{id}")
    public void borrarHabTecnica(@PathVariable Long id) {
        serviHabTecnica.borrarHabTecnica(id);
    }    


// CRUD EDUCACION //
    
    @PostMapping ("/nuevaEdu")
    public String agregarEducacion(@RequestBody Educacion edu){
        serviEdu.crearEducacion(edu);
        return "El elemento educación fue creado satisfactoriamente.";
    }
    
    @GetMapping ("/listaEdu")
    @ResponseBody
    public List<Educacion> listarEducaciones(){
        return serviEdu.listarEducaciones();
    }
    
    @PutMapping ("/editarEdu/{id}")
    public String editarEducacion(@PathVariable Long id, @RequestBody Educacion edu){
        return serviEdu.editarEducacion(id, edu);
    }
    
    @DeleteMapping("/borrarEdu/{id}")
    public String borrarEducacion(@PathVariable Long id){
        serviEdu.borrarEducacion(id);
        return "El elemento educación fue eliminado satisfactoriamente.";
    }
    

// CRUD EXPERIENCIA //
    
    @PostMapping ("/nuevaExpe")
    public String agregarExperiencia(@RequestBody Experiencia expe){
        serviExpe.crearExperiencia(expe);
        return "El elemento experiencia fue creado satisfactoriamente.";
    }
    
    @GetMapping ("/listaExpe")
    @ResponseBody
    public List<Experiencia> listarExperiencias(){
        return serviExpe.listarExperiencias();
    }
    
    @PutMapping ("/editarExpe/{id}")
    public String editarExperiencia(@PathVariable Long id, @RequestBody Experiencia expe){
        return serviExpe.editarExperiencia(id, expe);
    }
    
    @DeleteMapping("/borrarExpe/{id}")
    public String borrarExperiencia(@PathVariable Long id){
        serviExpe.borrarExperiencia(id);
        return "El elemento experiencia fue eliminado satisfactoriamente.";
    }
}
