package com.solesasia.portfolio.controllers;

import com.solesasia.portfolio.dto.ProjectDto;
import com.solesasia.portfolio.dto.ResponseDto;
import com.solesasia.portfolio.services.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "${url.front}", maxAge = 3600)
public class ProjectController {

    @Autowired
    private IProjectService projectService;

    @PostMapping("/newProject")
    public ResponseEntity<ResponseDto> addProject(@RequestBody ProjectDto projectDto){
        projectService.createProject(projectDto);
        ResponseDto responseDto = new ResponseDto(true, "¡El elemento ha sido agregado!");
        return new ResponseEntity(responseDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteProject/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProject(@PathVariable Long id){
        projectService.deleteProject(id);
    }

    @PutMapping ("/updateProject/{id}")
    public ResponseEntity<ResponseDto> updateProject(@PathVariable Long id, @RequestBody ProjectDto projectDto){
        if (!projectService.updateProject(id, projectDto)){
            ResponseDto responseDto = new ResponseDto(false, "Ups! El id proporcionado no existe :(");
            return new ResponseEntity(responseDto, HttpStatus.NOT_FOUND);
        }
        ResponseDto responseDto = new ResponseDto(true, "¡El elemento ha sido actualizado!");
        return new ResponseEntity(responseDto, HttpStatus.OK);
    }
}
