package com.solesasia.portfolio.controller;

import com.solesasia.portfolio.dto.PortfolioDTO;
import com.solesasia.portfolio.dto.RespuestaDTO;
import com.solesasia.portfolio.model.Educacion;
import com.solesasia.portfolio.model.Experiencia;
import com.solesasia.portfolio.model.HabilidadBlanda;
import com.solesasia.portfolio.model.HabilidadTecnica;
import com.solesasia.portfolio.model.Persona;
import com.solesasia.portfolio.model.Proyecto;
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
import com.solesasia.portfolio.service.IPortfolioService;
import com.solesasia.portfolio.service.IProyectoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;


@RestController
@CrossOrigin (origins = "http://localhost:4200", maxAge = 3600)
public class Controladora {
    
    @Autowired private IEducacionService serviEdu;
    @Autowired private IExperienciaService serviExpe;
    @Autowired private IHabilidadTecnicaService serviHabTecnica;
    @Autowired private IHabilidadBlandaService serviHabBlanda;
    @Autowired private IProyectoService serviProyecto;
    @Autowired private IPortfolioService serviPortfolio;
    
    

  // PORTFOLIO
    
    @GetMapping ("/port/{id}")
    @ResponseBody
    public ResponseEntity<PortfolioDTO> getPortfolio(@PathVariable Long personaId) {
        PortfolioDTO portfolio = serviPortfolio.getPortfolio(personaId);
        return new ResponseEntity<> (portfolio, HttpStatus.OK);
    }
    
    public boolean editarPersona(Long id, Persona perso) {
        return serviPortfolio.editarPersona(id, perso);
    }
    
/*    
    public Persona getPersona(Long id) {
        return serviPortfolio.getPersona(id);
    }
*/    
  // ABM PROYECTO // LLEVAR R A PORTFOLIODTO

    @PostMapping ("/nuevoProyecto")
    public void crearProyecto(@RequestBody Proyecto proyecto){
        serviProyecto.crearProyecto(proyecto);
    }
    
/*
    @GetMapping ("/listaProyectos")
    @ResponseBody
    public List<Proyecto> listarProyectos(){
        return serviProyecto.listarProyectos();
    }
*/    
    @PutMapping ("/editarProyecto/{id}")
    public String editarProyecto(@PathVariable Long id, @RequestBody Proyecto proyecto){
        return serviProyecto.editarProyecto(id, proyecto);
    }
    
    @DeleteMapping ("/borrarProyecto/{id}")
    public void borrarProyecto(@PathVariable Long id){
        serviProyecto.borrarProyecto(id);
    }
    
    
// ABM HABILIDAD BLANDA // LLEVAR R A PORTFOLIODTO
    
    @PostMapping ("/nuevaHabBlanda")
    public void crearHabBlanda(@RequestBody HabilidadBlanda habBlanda){
        serviHabBlanda.crearHabBlanda(habBlanda);
    }
/*
    @GetMapping ("/listaHabBlandas")
    @ResponseBody
    public List<HabilidadBlanda> listarHabBlandas(){
        return serviHabBlanda.listarHabBlandas();
    }
*/    
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
/*    
    @GetMapping ("/listaHabTecnicas")
    @ResponseBody
    public List<HabilidadTecnica> listarHabTecnicas(){
        return serviHabTecnica.listarHabTecnicas();
    }
*/    
    @PutMapping ("/editarHabTecnica/{id}")
    public String editarHabTecnica(@PathVariable Long id, @RequestBody HabilidadTecnica habTecnica) {
        return serviHabTecnica.editarHabTecnica(id, habTecnica);
    }
    
    @DeleteMapping ("borrarHabTecnica/{id}")
    public void borrarHabTecnica(@PathVariable Long id) {
        serviHabTecnica.borrarHabTecnica(id);
    }    


// CRUD EDUCACION //

/*    
    @GetMapping ("/listaEdu")
    @ResponseBody
    public ResponseEntity<List<Educacion>> listarEducaciones(){
        List<Educacion> listaEdu = serviEdu.listarEducaciones();
        return new ResponseEntity(listaEdu, HttpStatus.OK);
    }
*/    
    @PostMapping ("/nuevaEdu")
    @ResponseStatus(HttpStatus.CREATED)
    public void agregarEducacion(@RequestBody Educacion edu){
        serviEdu.crearEducacion(edu);
    }
    
    @PutMapping ("/editarEdu/{id}")
    public ResponseEntity<RespuestaDTO> editarEducacion(@PathVariable Long id, @RequestBody Educacion edu) {
        if (!serviEdu.editarEducacion(id, edu)) {
            return new ResponseEntity(new RespuestaDTO("El id proporcionado no existe."), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(new RespuestaDTO("El elemento ha sido actualizado."), HttpStatus.OK);
    }
    
    @DeleteMapping("/borrarEdu/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void borrarEducacion(@PathVariable Long id){
        serviEdu.borrarEducacion(id);
    }
    

// CRUD EXPERIENCIA //
    
    @PostMapping ("/nuevaExpe")
    public String agregarExperiencia(@RequestBody Experiencia expe){
        serviExpe.crearExperiencia(expe);
        return "El elemento experiencia fue creado satisfactoriamente.";
    }
/*    
    @GetMapping ("/listaExpe")
    @ResponseBody
    public List<Experiencia> listarExperiencias(){
        return serviExpe.listarExperiencias();
    }
*/    
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
