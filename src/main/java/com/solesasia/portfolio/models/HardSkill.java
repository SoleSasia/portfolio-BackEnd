package com.solesasia.portfolio.models;

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
public class HardSkill implements Serializable {
    
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id; 
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "level_id")
    private SkillLevel level;
    private String skillName;
    private String iconUrl;

    public HardSkill() {
    }

    public HardSkill(Person person, SkillLevel level, String skillName, String iconUrl) {
        this.person = person;
        this.level = level;
        this.skillName = skillName;
        this.iconUrl = iconUrl;
    }
}
