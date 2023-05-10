package com.solesasia.portfolio.dto;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class ExperienceDto {
    
    private Long id;
    private Long personId;
    private String position;
    private String period;
    private String company;
    private String description;
    private String logoUrl;

    public ExperienceDto() {
    }

    public ExperienceDto(Long id, Long personId, String position, String period, String organismoExpe, String description, String logoUrl) {
        this.id = id;
        this.personId = personId;
        this.position = position;
        this.period = period;
        this.company = organismoExpe;
        this.description = description;
        this.logoUrl = logoUrl;
    }
}
