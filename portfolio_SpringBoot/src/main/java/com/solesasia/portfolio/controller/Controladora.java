package com.solesasia.portfolio.controller;

import com.solesasia.portfolio.dto.PortfolioDTO;
import com.solesasia.portfolio.dto.RespuestaDTO;
import com.solesasia.portfolio.model.Educacion;
import com.solesasia.portfolio.model.Experiencia;
import com.solesasia.portfolio.model.HabilidadBlanda;
import com.solesasia.portfolio.model.HabilidadTecnica;
import com.solesasia.portfolio.model.Persona;
import com.solesasia.portfolio.model.Proyecto;
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
import com.solesasia.portfolio.service.IPortfolioService;
import com.solesasia.portfolio.service.IProyectoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;


@RestController
@CrossOrigin (origins = "http://localhost:4200", maxAge = 3600)
public class Controladora {
    
    //inyecta las dependencias necesarias para ejecutar las peticiones que vengan del cliente
    @Autowired private IEducacionService serviEdu;
    @Autowired private IExperienciaService serviExpe;
    @Autowired private IHabilidadTecnicaService serviHabTecnica;
    @Autowired private IHabilidadBlandaService serviHabBlanda;
    @Autowired private IProyectoService serviProyecto;
    @Autowired private IPortfolioService serviPortfolio;
        

  // PORTFOLIO ML
    
    @GetMapping ("/portfolio")
    @ResponseBody
    public ResponseEntity<PortfolioDTO> getPortfolio() {
        PortfolioDTO portfolio = serviPortfolio.getPortfolio();
        return new ResponseEntity<>(portfolio, HttpStatus.OK);
    }
    
    @PutMapping ("/editarPersona")
    public boolean editarPersona(@RequestBody Persona perso) {
        return serviPortfolio.editarPersona(perso);
    }
    
    /*    
        public Persona getPersona(Long id) {
            return serviPortfolio.getPersona(id);
        }
    */
    
  // PROYECTO ABM 
    
    @PostMapping ("/nuevoProyecto")
    public void crearProyecto(@RequestBody Proyecto proyecto){
        serviProyecto.crearProyecto(proyecto);
    }
    
    @DeleteMapping ("/borrarProyecto/{id}")
    public void borrarProyecto(@PathVariable Long id){
        serviProyecto.borrarProyecto(id);
    }
    
    @PutMapping ("/editarProyecto/{id}")
    public ResponseEntity<RespuestaDTO> editarProyecto(@PathVariable Long id, @RequestBody Proyecto proyecto){
        if (!serviProyecto.editarProyecto(id, proyecto)){
            return new ResponseEntity(new RespuestaDTO("El id proporcionado no existe."), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(new RespuestaDTO("El elemento ha sido actualizado."), HttpStatus.OK);
    }
    
    
  // HABILIDAD BLANDA ABM
    
    @PostMapping ("/nuevaHabBlanda")
    public void crearHabBlanda(@RequestBody HabilidadBlanda habBlanda){
        serviHabBlanda.crearHabBlanda(habBlanda);
    }
    
    @DeleteMapping ("/borrarHabBlanda/{id}")
    public void borrarHabBlanda(@PathVariable Long id){
        serviHabBlanda.borrarHabBlanda(id);
    }
    
    @PutMapping ("/editarHabBlanda/{id}")
    public ResponseEntity<RespuestaDTO> editarHabBlanda(@PathVariable Long id, @RequestBody HabilidadBlanda habBlanda){
        if (!serviHabBlanda.editarHabBlanda(id, habBlanda)) {
            return new ResponseEntity(new RespuestaDTO("El id proporcionado no existe."), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(new RespuestaDTO("El elemento ha sido actualizado."), HttpStatus.OK);
    }
   
    
  // HABILIDAD TECNICA ABM
    
    @PostMapping ("/nuevaHabTecnica")
    public void crearHabTecnica(@RequestBody HabilidadTecnica habTecnica){
        serviHabTecnica.crearHabTecnica(habTecnica);
    }
    
    @DeleteMapping ("borrarHabTecnica/{id}")
    public void borrarHabTecnica(@PathVariable Long id) {
        serviHabTecnica.borrarHabTecnica(id);
    }   
    
    @PutMapping ("/editarHabTecnica/{id}")
    public ResponseEntity<RespuestaDTO> editarHabTecnica(@PathVariable Long id, @RequestBody HabilidadTecnica habTecnica) {
        if (!serviHabTecnica.editarHabTecnica(id, habTecnica)) {
            return new ResponseEntity(new RespuestaDTO("El id proporcionado no existe."), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(new RespuestaDTO("El elemento ha sido actualizado."), HttpStatus.OK);
   
    }
  
    
  // EXPERIENCIA ABM
    
    @PostMapping ("/nuevaExpe")
    public String agregarExperiencia(@RequestBody Experiencia expe){
        serviExpe.crearExperiencia(expe);
        return "El elemento experiencia fue creado satisfactoriamente.";
    }
    
    @DeleteMapping("/borrarExpe/{id}")
    public String borrarExperiencia(@PathVariable Long id){
        serviExpe.borrarExperiencia(id);
        return "El elemento experiencia fue eliminado satisfactoriamente.";
    }
    
    @PutMapping ("/editarExpe/{id}")
    public ResponseEntity<RespuestaDTO> editarExperiencia(@PathVariable Long id, @RequestBody Experiencia expe) {
        if (!serviExpe.editarExperiencia(id, expe)) {
            return new ResponseEntity(new RespuestaDTO("El id proporcionado no existe."), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(new RespuestaDTO("El elemento ha sido actualizado."), HttpStatus.OK);
    }
    
     // EDUCACION ABM (CON RESPONSEENTITY)
  
    @PostMapping ("/nuevaEdu")
    @ResponseStatus(HttpStatus.CREATED)
    public void agregarEducacion(@RequestBody Educacion edu){
        serviEdu.crearEducacion(edu);
    }
    
    @DeleteMapping("/borrarEdu/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void borrarEducacion(@PathVariable Long id){
        serviEdu.borrarEducacion(id);
    }
    
    @PutMapping ("/editarEdu/{id}")
    public ResponseEntity<RespuestaDTO> editarEducacion(@PathVariable Long id, @RequestBody Educacion edu) {
        if (!serviEdu.editarEducacion(id, edu)) {
            return new ResponseEntity(new RespuestaDTO("El id proporcionado no existe."), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(new RespuestaDTO("El elemento ha sido actualizado."), HttpStatus.OK);
    }
      
}
