package com.solesasia.portfolio.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class PortfolioDto {
    
    private PersonDto person;
    private List<EducationDto> educationDtos;
    private List<ExperienceDto> experienceDtos;
    private List<hardSkillDto> hardSkillDtos;
    private List<SoftSkillDto> softSkillDtos;
    private List<ProjectDto> projectDtos;

    public PortfolioDto() {
    }

    public PortfolioDto(PersonDto person, List<EducationDto> educationDtos, List<ExperienceDto> experienceDtos, List<hardSkillDto> hardSkillDtos, List<SoftSkillDto> softSkillDtos, List<ProjectDto> proyectos) {
        this.person = person;
        this.educationDtos = educationDtos;
        this.experienceDtos = experienceDtos;
        this.hardSkillDtos = hardSkillDtos;
        this.softSkillDtos = softSkillDtos;
        this.projectDtos = proyectos;
    }
}
