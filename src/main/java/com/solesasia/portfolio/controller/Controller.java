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
public class Controller {
    
    //inyecta las dependencias necesarias para ejecutar las peticiones que vengan del cliente
    @Autowired private IEducationService eduService;
    @Autowired private IExperienceService expeService;
    @Autowired private IHardSkillService hardService;
    @Autowired private ISoftSkillService softService;
    @Autowired private IProjectService projectService;
    @Autowired private IPortfolioService portfolioService;

  // PORTFOLIO ML
    @GetMapping ("/portfolio")
    @ResponseBody
    public ResponseEntity<PortfolioDto> getPortfolio() {
        PortfolioDto portfolio = portfolioService.getPortfolio();
        return new ResponseEntity<>(portfolio, HttpStatus.OK);
    }

    @PutMapping ("/updatePerson")
    public ResponseEntity<ResponseDto> updatePerson(@RequestBody PersonDto personDto) {
        if (!portfolioService.updatePerson(personDto)){
            ResponseDto responseDto = new ResponseDto(false, "Ups! El id proporcionado no existe :(");
            return new ResponseEntity(responseDto, HttpStatus.NOT_FOUND);
        }
        ResponseDto responseDto = new ResponseDto(true, "¡La información personal ha sido actualizada!");
        return new ResponseEntity(responseDto, HttpStatus.OK);
    }
    
  // PROYECTO ABM
    @PostMapping ("/newProject")
    public ResponseEntity<ResponseDto> addProject(@RequestBody ProjectDto projectDto){
        projectService.createProject(projectDto);
        ResponseDto responseDto = new ResponseDto(true, "¡El elemento ha sido agregado!");
        return new ResponseEntity(responseDto, HttpStatus.CREATED);
    }
    
    @DeleteMapping ("/borrarProyecto/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProject(@PathVariable Long id){
        projectService.deleteProject(id);
    }
    
    @PutMapping ("/editarProyecto/{id}")
    public ResponseEntity<ResponseDto> updateProject(@PathVariable Long id, @RequestBody ProjectDto projectDto){
        if (!projectService.updateProject(id, projectDto)){
            ResponseDto responseDto = new ResponseDto(false, "Ups! El id proporcionado no existe :(");
            return new ResponseEntity(responseDto, HttpStatus.NOT_FOUND);
        }
        ResponseDto responseDto = new ResponseDto(true, "¡El elemento ha sido actualizado!");
        return new ResponseEntity(responseDto, HttpStatus.OK);
    }

  // HABILIDAD BLANDA ABM
    @PostMapping ("/nuevaHabBlanda")
    public ResponseEntity<ResponseDto> addSoftSkill(@RequestBody SoftSkillDto softSkillDto){
        softService.createSoftSkill(softSkillDto);
        ResponseDto responseDto = new ResponseDto(true, "¡El elemento ha sido agregado!");
        return new ResponseEntity(responseDto, HttpStatus.CREATED);
    }
    
    @DeleteMapping ("/borrarHabBlanda/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSoftSkill(@PathVariable Long id){
        softService.deleteSoftSkill(id);
    }
    
    @PutMapping ("/editarHabBlanda/{id}")
    public ResponseEntity<ResponseDto> updateSoftSkill(@PathVariable Long id, @RequestBody SoftSkillDto softSkillDto){
        if (!softService.updateSoftSkill(id, softSkillDto)) {
            ResponseDto responseDto = new ResponseDto(false, "Ups! El id proporcionado no existe :(");
            return new ResponseEntity(responseDto, HttpStatus.NOT_FOUND);
        }
        ResponseDto responseDto = new ResponseDto(true, "¡El elemento ha sido actualizado!");
        return new ResponseEntity(responseDto, HttpStatus.OK);
    }
    
  // HABILIDAD TECNICA ABM
    @PostMapping ("/nuevaHabTecnica")
    public ResponseEntity<ResponseDto> addHardSkill(@RequestBody HardSkillDto hardSkillDto){
        hardService.createHardSkill(hardSkillDto);
        ResponseDto responseDto = new ResponseDto(true, "¡El elemento ha sido agregado!");
        return new ResponseEntity(responseDto, HttpStatus.CREATED);
    }
    
    @DeleteMapping ("borrarHabTecnica/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteHardSkill(@PathVariable Long id) {
        hardService.deleteHardSkill(id);
    }   
    
    @PutMapping ("/editarHabTecnica/{id}")
    public ResponseEntity<ResponseDto> updateHardSkill(@PathVariable Long id, @RequestBody HardSkillDto hardSkillDto) {
        if (!hardService.updateHardSkill(id, hardSkillDto)) {
            ResponseDto responseDto = new ResponseDto(false, "Ups! El id proporcionado no existe :(");
            return new ResponseEntity(responseDto, HttpStatus.NOT_FOUND);
        }
        ResponseDto responseDto = new ResponseDto(true, "¡El elemento ha sido actualizado!");
        return new ResponseEntity(responseDto, HttpStatus.OK);
   
    }
    
  // EXPERIENCIA ABM
    @PostMapping ("/nuevaExpe")
    public ResponseEntity<ResponseDto> addExperience(@RequestBody ExperienceDto experienceDto){
        expeService.createExperience(experienceDto);
        ResponseDto resp = new ResponseDto(true, "¡El elemento ha sido agregado!");
        return new ResponseEntity(resp, HttpStatus.CREATED);
    }
    
    @DeleteMapping("/borrarExpe/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteExperience(@PathVariable Long id){
        expeService.deleteExperience(id);
    }
    
    @PutMapping ("/editarExpe/{id}")
    public ResponseEntity<ResponseDto> updateExperience(@PathVariable Long id, @RequestBody ExperienceDto experienceDto) {
        if (!expeService.updateExperience(id, experienceDto)) {
            ResponseDto responseDto = new ResponseDto(false, "Ups! El id proporcionado no existe :(");
            return new ResponseEntity(responseDto, HttpStatus.NOT_FOUND);
        }
        ResponseDto responseDto = new ResponseDto(true, "¡El elemento ha sido actualizado!.");
        return new ResponseEntity(responseDto, HttpStatus.OK);
    }
    
  // EDUCACION ABM
    @PostMapping ("/nuevaEdu")
    public ResponseEntity<ResponseDto> addEducation(@RequestBody EducationDto educationDto){
        eduService.createEducation(educationDto);
        ResponseDto responseDto = new ResponseDto(true, "¡El elemento ha sido agregado!");
        return new ResponseEntity(responseDto, HttpStatus.CREATED);
    }
    
    @DeleteMapping("/borrarEdu/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEducation(@PathVariable Long id){
        eduService.deleteEducation(id);
    }
    
    @PutMapping ("/editarEdu/{id}")
    public ResponseEntity<ResponseDto> updateEducation(@PathVariable Long id, @RequestBody EducationDto educationDto) {
        if (!eduService.updateEducation(id, educationDto)) {
            ResponseDto responseDto = new ResponseDto(false, "Ups! El id proporcionado no existe :(");
            return new ResponseEntity(responseDto, HttpStatus.NOT_FOUND);
        }
        ResponseDto responseDto = new ResponseDto(true, "¡El elemento ha sido actualizado!");
        return new ResponseEntity(responseDto, HttpStatus.OK);
    }

}