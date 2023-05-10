package com.solesasia.portfolio.dto;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class ProjectDto {
    
    private Long id;
    private Long personId;
    private String name;
    private String description;
    private String imgUrl;
    private String sourceCodeUrl;
    private String liveUrl;

    public ProjectDto() {
    }

    public ProjectDto(Long id, Long personId, String name, String description, String imgUrl, String sourceCodeUrl,
                      String liveUrl) {
        this.id = id;
        this.personId = personId;
        this.name = name;
        this.description = description;
        this.imgUrl = imgUrl;
        this.sourceCodeUrl = sourceCodeUrl;
        this.liveUrl = liveUrl;
    }
}
