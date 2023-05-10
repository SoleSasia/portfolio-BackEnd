package com.solesasia.portfolio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter @Getter
public class Project implements Serializable {
    
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
    private String nameProject;
    private String descriptionProject;
    private String imgUrl;
    private String sourceCodeUrl;
    private String liveUrl;

    public Project() {
    }

    public Project(Person person, String nameProject, String descriptionProject, String imgUrl,
                   String sourceCodeUrl, String liveUrl) {
        this.person = person;
        this.nameProject = nameProject;
        this.descriptionProject = descriptionProject;
        this.imgUrl = imgUrl;
        this.sourceCodeUrl = sourceCodeUrl;
        this.liveUrl = liveUrl;
    }
}
