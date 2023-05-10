package com.solesasia.portfolio.dto;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class EducationDto {
    
    private Long id;
    private Long personId;
    private String title;
    private String period;
    private String institution;
    private String description;
    private String logoUrl;

    public EducationDto() {
    }

    public EducationDto(Long id, Long personId, String title, String period, String institution,
                        String description, String logoUrl) {
        this.id = id;
        this.personId = personId;
        this.title = title;
        this.period = period;
        this.institution = institution;
        this.description = description;
        this.logoUrl = logoUrl;
    }
}
