package com.solesasia.portfolio.controllers;

import com.solesasia.portfolio.dto.ResponseDto;
import com.solesasia.portfolio.dto.SoftSkillDto;
import com.solesasia.portfolio.services.ISoftSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "${url.front}", maxAge = 3600)
public class SoftSkillController {

    @Autowired
    private ISoftSkillService softService;

    @PostMapping("/newSoftskill")
    public ResponseEntity<ResponseDto> addSoftSkill(@RequestBody SoftSkillDto softSkillDto){
        softService.createSoftSkill(softSkillDto);
        ResponseDto responseDto = new ResponseDto(true, "¡El elemento ha sido agregado!");
        return new ResponseEntity(responseDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteSoftskill/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSoftSkill(@PathVariable Long id){
        softService.deleteSoftSkill(id);
    }

    @PutMapping ("/updateSoftskill/{id}")
    public ResponseEntity<ResponseDto> updateSoftSkill(@PathVariable Long id,
                                                       @RequestBody SoftSkillDto softSkillDto){
        if (!softService.updateSoftSkill(id, softSkillDto)) {
            ResponseDto responseDto = new ResponseDto(false, "Ups! El id proporcionado no existe :(");
            return new ResponseEntity(responseDto, HttpStatus.NOT_FOUND);
        }
        ResponseDto responseDto = new ResponseDto(true, "¡El elemento ha sido actualizado!");
        return new ResponseEntity(responseDto, HttpStatus.OK);
    }
}
