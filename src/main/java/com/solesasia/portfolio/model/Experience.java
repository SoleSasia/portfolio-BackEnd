
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
public class Experience implements Serializable {
    
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
    private String position;
    private String period;
    private String company;
    private String description;
    private String logoUrl;

    public Experience() {
    }

    public Experience(Person person, String position, String period, String company, String description,
                      String logoUrl) {
        this.person = person;
        this.position = position;
        this.period = period;
        this.company = company;
        this.description = description;
        this.logoUrl = logoUrl;
    }
}
