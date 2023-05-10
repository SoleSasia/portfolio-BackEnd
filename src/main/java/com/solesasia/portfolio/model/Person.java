package com.solesasia.portfolio.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter @Getter
public class Person {
    
    @Id
    private Long id;
    private String name;
    private String occupation;
    private String homeBannerUrl;
    private String email;
    private String linkedinUrl;
    private String githubUrl;
    private String description;
    private String profilePicUrl;

    @OneToMany(mappedBy = "person")
    private List<Education> educations;
    @OneToMany(mappedBy = "person")
    private List<Experience> experiences;
    @OneToMany(mappedBy = "person")
    private List<HardSkill> hardSkills;
    @OneToMany(mappedBy = "person")
    private List<SoftSill> softSkills;
    @OneToMany(mappedBy = "person")
    private List<Project> projects;

    public Person() {
    }

    //constructor para ediciones de persona
    public Person(Long id, String name, String occupation, String homeBannerUrl, String email, String linkedinUrl,
                  String githubUrl, String description, String profilePicUrl) {
        this.id = id;
        this.name = name;
        this.occupation = occupation;
        this.homeBannerUrl = homeBannerUrl;
        this.email = email;
        this.linkedinUrl = linkedinUrl;
        this.githubUrl = githubUrl;
        this.description = description;
        this.profilePicUrl = profilePicUrl;
    }

    public Person(Long id, String name, String occupation, String homeBannerUrl, String email, String linkedinUrl,
                  String githubUrl, String description, String profilePicUrl, List<Education> educations,
                  List<Experience> experiences, List<HardSkill> hardSkills,
                  List<SoftSill> softSkills, List<Project> projects) {
        this.id = id;
        this.name = name;
        this.occupation = occupation;
        this.homeBannerUrl = homeBannerUrl;
        this.email = email;
        this.linkedinUrl = linkedinUrl;
        this.githubUrl = githubUrl;
        this.description = description;
        this.profilePicUrl = profilePicUrl;
        this.educations = educations;
        this.experiences = experiences;
        this.hardSkills = hardSkills;
        this.softSkills = softSkills;
        this.projects = projects;
    }

    

    

}