package com.solesasia.portfolio.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter @Getter
public class SkillLevel implements Serializable {
    
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String levelName;
    @JsonIgnore
    @OneToMany(mappedBy = "level")
    private List<HardSkill> hardSkills;

    public SkillLevel() {
    }

    public SkillLevel(Long id, String levelName) {
        this.id = id;
        this.levelName = levelName;
    }
}
