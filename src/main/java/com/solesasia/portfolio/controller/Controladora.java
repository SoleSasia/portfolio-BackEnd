package com.solesasia.portfolio.controller;

import com.solesasia.portfolio.dto.EduDto;
import com.solesasia.portfolio.dto.ExpeDto;
import com.solesasia.portfolio.dto.HabBlandaDto;
import com.solesasia.portfolio.dto.HabTecnicaDto;
import com.solesasia.portfolio.dto.PersoDto;
import com.solesasia.portfolio.dto.PortfolioDto;
import com.solesasia.portfolio.dto.ProyeDto;
import com.solesasia.portfolio.dto.RespuestaDto;
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
@CrossOrigin (origins = "http://localhost:4200/", maxAge = 3600)
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
    public ResponseEntity<PortfolioDto> getPortfolio() {
        PortfolioDto portfolio = serviPortfolio.getPortfolio();
        return new ResponseEntity<>(portfolio, HttpStatus.OK);
    }

    
    @PutMapping ("/editarPersona")
    public ResponseEntity<RespuestaDto> editarPersona(@RequestBody PersoDto perso) {
        if (!serviPortfolio.editarPersona(perso)){
            RespuestaDto resp = new RespuestaDto(false, "Ups! El id proporcionado no existe :(");
            return new ResponseEntity(resp, HttpStatus.NOT_FOUND);
        }
        RespuestaDto resp = new RespuestaDto(true, "¡La información personal ha sido actualizada!");
        return new ResponseEntity(resp, HttpStatus.OK);
    }
    /*=============================================
    //para pruebas 
    @GetMapping ("/persona")
    @ResponseBody
    public ResponseEntity<Persona> getPersona() {
        Persona perso = serviPortfolio.getPersona();
        return new ResponseEntity<>(perso, HttpStatus.OK);
    }
     //para pruebas 
    @GetMapping ("/listaEdu")
    @ResponseBody
    public List<EduDto> listarEduDto(){
        return serviPortfolio.listarEduDto();
    }
    //============================================*/
    
  // PROYECTO ABM 
    
    @PostMapping ("/nuevoProyecto")
    public ResponseEntity<RespuestaDto> agregarProyecto(@RequestBody ProyeDto proyecto){
        serviProyecto.crearProyecto(proyecto);
        RespuestaDto resp = new RespuestaDto(true, "¡El elemento ha sido agregado!");
        return new ResponseEntity(resp, HttpStatus.CREATED);
    }
    
    @DeleteMapping ("/borrarProyecto/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void borrarProyecto(@PathVariable Long id){
        serviProyecto.borrarProyecto(id);
    }
    
    @PutMapping ("/editarProyecto/{id}")
    public ResponseEntity<RespuestaDto> editarProyecto(@PathVariable Long id, @RequestBody ProyeDto proyecto){
        if (!serviProyecto.editarProyecto(id, proyecto)){
            RespuestaDto resp = new RespuestaDto(false, "Ups! El id proporcionado no existe :(");
            return new ResponseEntity(resp, HttpStatus.NOT_FOUND);
        }
        RespuestaDto resp = new RespuestaDto(true, "¡El elemento ha sido actualizado!");
        return new ResponseEntity(resp, HttpStatus.OK);
    }
    
    
  // HABILIDAD BLANDA ABM
    
    @PostMapping ("/nuevaHabBlanda")
    public ResponseEntity<RespuestaDto> agregarHabBlanda(@RequestBody HabBlandaDto habBlanda){
        serviHabBlanda.crearHabBlanda(habBlanda);
        RespuestaDto resp = new RespuestaDto(true, "¡El elemento ha sido agregado!");
        return new ResponseEntity(resp, HttpStatus.CREATED);

    }
    
    @DeleteMapping ("/borrarHabBlanda/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void borrarHabBlanda(@PathVariable Long id){
        serviHabBlanda.borrarHabBlanda(id);
    }
    
    @PutMapping ("/editarHabBlanda/{id}")
    public ResponseEntity<RespuestaDto> editarHabBlanda(@PathVariable Long id, @RequestBody HabBlandaDto habBlanda){
        if (!serviHabBlanda.editarHabBlanda(id, habBlanda)) {
            RespuestaDto resp = new RespuestaDto(false, "Ups! El id proporcionado no existe :(");
            return new ResponseEntity(resp, HttpStatus.NOT_FOUND);
        }
        RespuestaDto resp = new RespuestaDto(true, "¡El elemento ha sido actualizado!");
        return new ResponseEntity(resp, HttpStatus.OK);
    }
   
    
  // HABILIDAD TECNICA ABM
    
    @PostMapping ("/nuevaHabTecnica")
    public ResponseEntity<RespuestaDto> agregarHabTecnica(@RequestBody HabTecnicaDto habTecnica){
        serviHabTecnica.crearHabTecnica(habTecnica);
        RespuestaDto resp = new RespuestaDto(true, "¡El elemento ha sido agregado!");
        return new ResponseEntity(resp, HttpStatus.CREATED);
    }
    
    @DeleteMapping ("borrarHabTecnica/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void borrarHabTecnica(@PathVariable Long id) {
        serviHabTecnica.borrarHabTecnica(id);
    }   
    
    @PutMapping ("/editarHabTecnica/{id}")
    public ResponseEntity<RespuestaDto> editarHabTecnica(@PathVariable Long id, @RequestBody HabTecnicaDto habTecnica) {
        if (!serviHabTecnica.editarHabTecnica(id, habTecnica)) {
            RespuestaDto resp = new RespuestaDto(false, "Ups! El id proporcionado no existe :(");
            return new ResponseEntity(resp, HttpStatus.NOT_FOUND);
        }
        RespuestaDto resp = new RespuestaDto(true, "¡El elemento ha sido actualizado!");
        return new ResponseEntity(resp, HttpStatus.OK);
   
    }
  
    
  // EXPERIENCIA ABM
    
    @PostMapping ("/nuevaExpe")
    public ResponseEntity<RespuestaDto> agregarExperiencia(@RequestBody ExpeDto expe){
        serviExpe.crearExperiencia(expe);
        RespuestaDto resp = new RespuestaDto(true, "¡El elemento ha sido agregado!");
        return new ResponseEntity(resp, HttpStatus.CREATED);
    }
    
    @DeleteMapping("/borrarExpe/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void borrarExperiencia(@PathVariable Long id){
        serviExpe.borrarExperiencia(id);
    }
    
    @PutMapping ("/editarExpe/{id}")
    public ResponseEntity<RespuestaDto> editarExperiencia(@PathVariable Long id, @RequestBody ExpeDto expe) {
        if (!serviExpe.editarExperiencia(id, expe)) {
            RespuestaDto resp = new RespuestaDto(false, "Ups! El id proporcionado no existe :(");
            return new ResponseEntity(resp, HttpStatus.NOT_FOUND);
        }
        RespuestaDto resp = new RespuestaDto(true, "¡El elemento ha sido actualizado!.");
        return new ResponseEntity(resp, HttpStatus.OK);
    }
    
    
  // EDUCACION ABM
  
    @PostMapping ("/nuevaEdu")
    public ResponseEntity<RespuestaDto> agregarEducacion(@RequestBody EduDto edu){
        serviEdu.crearEducacion(edu);
        RespuestaDto resp = new RespuestaDto(true, "¡El elemento ha sido agregado!");
        return new ResponseEntity(resp, HttpStatus.CREATED);
    }
    
    @DeleteMapping("/borrarEdu/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void borrarEducacion(@PathVariable Long id){
        serviEdu.borrarEducacion(id);
    }
    
    @PutMapping ("/editarEdu/{id}")
    public ResponseEntity<RespuestaDto> editarEducacion(@PathVariable Long id, @RequestBody EduDto edu) {
        if (!serviEdu.editarEducacion(id, edu)) {
            RespuestaDto resp = new RespuestaDto(false, "Ups! El id proporcionado no existe :(");
            return new ResponseEntity(resp, HttpStatus.NOT_FOUND);
        }
        RespuestaDto resp = new RespuestaDto(true, "¡El elemento ha sido actualizado!");
        return new ResponseEntity(resp, HttpStatus.OK);
    }
      
}
