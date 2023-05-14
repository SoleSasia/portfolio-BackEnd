package com.solesasia.portfolio.dto;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class HardSkillDto {
    
    private Long id;
    private Long personId;
    private Long levelId;
    private String skillName;
    private String iconUrl;

    public HardSkillDto() {
    }

    public HardSkillDto(Long id, Long personId, Long levelId, String skillName, String iconUrl) {
        this.id = id;
        this.personId = personId;
        this.levelId = levelId;
        this.skillName = skillName;
        this.iconUrl = iconUrl;
    }
}
