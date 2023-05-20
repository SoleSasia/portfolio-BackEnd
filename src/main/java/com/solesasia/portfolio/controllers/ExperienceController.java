package com.solesasia.portfolio.controllers;

import com.solesasia.portfolio.dto.ExperienceDto;
import com.solesasia.portfolio.dto.ResponseDto;
import com.solesasia.portfolio.services.IExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "${url.front}", maxAge = 3600)
public class ExperienceController {

    @Autowired
    private IExperienceService expeService;

    @PostMapping("/newExperience")
    public ResponseEntity<ResponseDto> addExperience(@RequestBody ExperienceDto experienceDto){
        expeService.createExperience(experienceDto);
        ResponseDto resp = new ResponseDto(true, "¡El elemento ha sido agregado!");
        return new ResponseEntity(resp, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteExperience/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteExperience(@PathVariable Long id){
        expeService.deleteExperience(id);
    }

    @PutMapping ("/updateExperience/{id}")
    public ResponseEntity<ResponseDto> updateExperience(@PathVariable Long id,
                                                        @RequestBody ExperienceDto experienceDto) {
        if (!expeService.updateExperience(id, experienceDto)) {
            ResponseDto responseDto = new ResponseDto(false, "Ups! El id proporcionado no existe :(");
            return new ResponseEntity(responseDto, HttpStatus.NOT_FOUND);
        }
        ResponseDto responseDto = new ResponseDto(true, "¡El elemento ha sido actualizado!.");
        return new ResponseEntity(responseDto, HttpStatus.OK);
    }

}
