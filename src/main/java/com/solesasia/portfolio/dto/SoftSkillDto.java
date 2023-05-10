package com.solesasia.portfolio.dto;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class SoftSkillDto {
    
    private Long id;
    private Long personId;
    private String skillName;
    private String iconUrl;

    public SoftSkillDto() {
    }

    public SoftSkillDto(Long id, Long personId, String skillName, String iconUrl) {
        this.id = id;
        this.personId = personId;
        this.skillName = skillName;
        this.iconUrl = iconUrl;
    }
}
