package com.solesasia.portfolio.dto;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class PersonDto {
    
    private Long id;
    private String name;
    private String occupation;
    private String homeBannerUrl;
    private String email;
    private String linkedinUrl;
    private String githubUrl;
    private String description;
    private String imgUrl;

    public PersonDto() {
    }

    public PersonDto(Long id, String name, String occupation, String homeBannerUrl, String email, String linkedinUrl,
                     String githubUrl, String description, String imgUrl) {
        this.id = id;
        this.name = name;
        this.occupation = occupation;
        this.homeBannerUrl = homeBannerUrl;
        this.email = email;
        this.linkedinUrl = linkedinUrl;
        this.githubUrl = githubUrl;
        this.description = description;
        this.imgUrl = imgUrl;
    }
}
