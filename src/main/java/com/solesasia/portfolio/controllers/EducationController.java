package com.solesasia.portfolio.controllers;

import com.solesasia.portfolio.dto.EducationDto;
import com.solesasia.portfolio.dto.ResponseDto;
import com.solesasia.portfolio.services.IEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "${url.front}", maxAge = 3600)
public class EducationController {

    @Autowired
    private IEducationService eduService;

    @PostMapping("/newEducation")
    public ResponseEntity<ResponseDto> addEducation(@RequestBody EducationDto educationDto){
        eduService.createEducation(educationDto);
        ResponseDto responseDto = new ResponseDto(true, "¡El elemento ha sido agregado!");
        return new ResponseEntity(responseDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteEducation/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEducation(@PathVariable Long id){
        eduService.deleteEducation(id);
    }

    @PutMapping ("/updateEducation/{id}")
    public ResponseEntity<ResponseDto> updateEducation(@PathVariable Long id,
                                                       @RequestBody EducationDto educationDto){
        if (!eduService.updateEducation(id, educationDto)) {
            ResponseDto responseDto = new ResponseDto(false, "Ups! El id proporcionado no existe :(");
            return new ResponseEntity(responseDto, HttpStatus.NOT_FOUND);
        }
        ResponseDto responseDto = new ResponseDto(true, "¡El elemento ha sido actualizado!");
        return new ResponseEntity(responseDto, HttpStatus.OK);
    }
}
