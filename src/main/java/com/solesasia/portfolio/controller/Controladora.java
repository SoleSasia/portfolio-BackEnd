package com.solesasia.portfolio.controller;

import com.solesasia.portfolio.dto.EducationDto;
import com.solesasia.portfolio.dto.ExperienceDto;
import com.solesasia.portfolio.dto.SoftSkillDto;
import com.solesasia.portfolio.dto.HardSkillDto;
import com.solesasia.portfolio.dto.PersonDto;
import com.solesasia.portfolio.dto.PortfolioDto;
import com.solesasia.portfolio.dto.ProjectDto;
import com.solesasia.portfolio.dto.ResponseDto;
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
import com.solesasia.portfolio.service.IEducationService;
import com.solesasia.portfolio.service.IExperienceService;
import com.solesasia.portfolio.service.ISoftSkillService;
import com.solesasia.portfolio.service.IHardSkillService;
import com.solesasia.portfolio.service.IPortfolioService;
import com.solesasia.portfolio.service.IProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;


@RestController
@CrossOrigin (origins = "http://localhost:4200/", maxAge = 3600)
public class Controladora {
    
    //inyecta las dependencias necesarias para ejecutar las peticiones que vengan del cliente
    @Autowired private IEducationService serviEdu;
    @Autowired private IExperienceService serviExpe;
    @Autowired private IHardSkillService serviHabTecnica;
    @Autowired private ISoftSkillService serviHabBlanda;
    @Autowired private IProjectService serviProyecto;
    @Autowired private IPortfolioService serviPortfolio;
        

  // PORTFOLIO ML
    
    @GetMapping ("/portfolio")
    @ResponseBody
    public ResponseEntity<PortfolioDto> getPortfolio() {
        PortfolioDto portfolio = serviPortfolio.getPortfolio();
        return new ResponseEntity<>(portfolio, HttpStatus.OK);
    }

    
    @PutMapping ("/editarPersona")
    public ResponseEntity<ResponseDto> editarPersona(@RequestBody PersonDto perso) {
        if (!serviPortfolio.updatePerson(perso)){
            ResponseDto resp = new ResponseDto(false, "Ups! El id proporcionado no existe :(");
            return new ResponseEntity(resp, HttpStatus.NOT_FOUND);
        }
        ResponseDto resp = new ResponseDto(true, "¡La información personal ha sido actualizada!");
        return new ResponseEntity(resp, HttpStatus.OK);
    }
    /*=============================================
    //para pruebas 
    @GetMapping ("/persona")
    @ResponseBody
    public ResponseEntity<Person> getPerson() {
        Person perso = serviPortfolio.getPerson();
        return new ResponseEntity<>(perso, HttpStatus.OK);
    }
     //para pruebas 
    @GetMapping ("/listaEdu")
    @ResponseBody
    public List<EducationDto> listarEduDto(){
        return serviPortfolio.listarEduDto();
    }
    //============================================*/
    
  // PROYECTO ABM 
    
    @PostMapping ("/nuevoProyecto")
    public ResponseEntity<ResponseDto> agregarProyecto(@RequestBody ProjectDto proyecto){
        serviProyecto.createProject(proyecto);
        ResponseDto resp = new ResponseDto(true, "¡El elemento ha sido agregado!");
        return new ResponseEntity(resp, HttpStatus.CREATED);
    }
    
    @DeleteMapping ("/borrarProyecto/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void borrarProyecto(@PathVariable Long id){
        serviProyecto.deleteProject(id);
    }
    
    @PutMapping ("/editarProyecto/{id}")
    public ResponseEntity<ResponseDto> editarProyecto(@PathVariable Long id, @RequestBody ProjectDto proyecto){
        if (!serviProyecto.updateProject(id, proyecto)){
            ResponseDto resp = new ResponseDto(false, "Ups! El id proporcionado no existe :(");
            return new ResponseEntity(resp, HttpStatus.NOT_FOUND);
        }
        ResponseDto resp = new ResponseDto(true, "¡El elemento ha sido actualizado!");
        return new ResponseEntity(resp, HttpStatus.OK);
    }
    
    
  // HABILIDAD BLANDA ABM
    
    @PostMapping ("/nuevaHabBlanda")
    public ResponseEntity<ResponseDto> agregarHabBlanda(@RequestBody SoftSkillDto habBlanda){
        serviHabBlanda.createSoftSkill(habBlanda);
        ResponseDto resp = new ResponseDto(true, "¡El elemento ha sido agregado!");
        return new ResponseEntity(resp, HttpStatus.CREATED);

    }
    
    @DeleteMapping ("/borrarHabBlanda/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void borrarHabBlanda(@PathVariable Long id){
        serviHabBlanda.deleteSoftSkill(id);
    }
    
    @PutMapping ("/editarHabBlanda/{id}")
    public ResponseEntity<ResponseDto> editarHabBlanda(@PathVariable Long id, @RequestBody SoftSkillDto habBlanda){
        if (!serviHabBlanda.updateSoftSkill(id, habBlanda)) {
            ResponseDto resp = new ResponseDto(false, "Ups! El id proporcionado no existe :(");
            return new ResponseEntity(resp, HttpStatus.NOT_FOUND);
        }
        ResponseDto resp = new ResponseDto(true, "¡El elemento ha sido actualizado!");
        return new ResponseEntity(resp, HttpStatus.OK);
    }
   
    
  // HABILIDAD TECNICA ABM
    
    @PostMapping ("/nuevaHabTecnica")
    public ResponseEntity<ResponseDto> agregarHabTecnica(@RequestBody HardSkillDto habTecnica){
        serviHabTecnica.createHardSkill(habTecnica);
        ResponseDto resp = new ResponseDto(true, "¡El elemento ha sido agregado!");
        return new ResponseEntity(resp, HttpStatus.CREATED);
    }
    
    @DeleteMapping ("borrarHabTecnica/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void borrarHabTecnica(@PathVariable Long id) {
        serviHabTecnica.deleteHardSkill(id);
    }   
    
    @PutMapping ("/editarHabTecnica/{id}")
    public ResponseEntity<ResponseDto> editarHabTecnica(@PathVariable Long id, @RequestBody HardSkillDto habTecnica) {
        if (!serviHabTecnica.updateHardSkill(id, habTecnica)) {
            ResponseDto resp = new ResponseDto(false, "Ups! El id proporcionado no existe :(");
            return new ResponseEntity(resp, HttpStatus.NOT_FOUND);
        }
        ResponseDto resp = new ResponseDto(true, "¡El elemento ha sido actualizado!");
        return new ResponseEntity(resp, HttpStatus.OK);
   
    }
  
    
  // EXPERIENCIA ABM
    
    @PostMapping ("/nuevaExpe")
    public ResponseEntity<ResponseDto> agregarExperiencia(@RequestBody ExperienceDto expe){
        serviExpe.createExperience(expe);
        ResponseDto resp = new ResponseDto(true, "¡El elemento ha sido agregado!");
        return new ResponseEntity(resp, HttpStatus.CREATED);
    }
    
    @DeleteMapping("/borrarExpe/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void borrarExperiencia(@PathVariable Long id){
        serviExpe.deleteExperience(id);
    }
    
    @PutMapping ("/editarExpe/{id}")
    public ResponseEntity<ResponseDto> editarExperiencia(@PathVariable Long id, @RequestBody ExperienceDto expe) {
        if (!serviExpe.updateExperience(id, expe)) {
            ResponseDto resp = new ResponseDto(false, "Ups! El id proporcionado no existe :(");
            return new ResponseEntity(resp, HttpStatus.NOT_FOUND);
        }
        ResponseDto resp = new ResponseDto(true, "¡El elemento ha sido actualizado!.");
        return new ResponseEntity(resp, HttpStatus.OK);
    }
    
    
  // EDUCACION ABM
  
    @PostMapping ("/nuevaEdu")
    public ResponseEntity<ResponseDto> agregarEducacion(@RequestBody EducationDto edu){
        serviEdu.createEducation(edu);
        ResponseDto resp = new ResponseDto(true, "¡El elemento ha sido agregado!");
        return new ResponseEntity(resp, HttpStatus.CREATED);
    }
    
    @DeleteMapping("/borrarEdu/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void borrarEducacion(@PathVariable Long id){
        serviEdu.deleteEducation(id);
    }
    
    @PutMapping ("/editarEdu/{id}")
    public ResponseEntity<ResponseDto> editarEducacion(@PathVariable Long id, @RequestBody EducationDto edu) {
        if (!serviEdu.updateEducation(id, edu)) {
            ResponseDto resp = new ResponseDto(false, "Ups! El id proporcionado no existe :(");
            return new ResponseEntity(resp, HttpStatus.NOT_FOUND);
        }
        ResponseDto resp = new ResponseDto(true, "¡El elemento ha sido actualizado!");
        return new ResponseEntity(resp, HttpStatus.OK);
    }
      
}
