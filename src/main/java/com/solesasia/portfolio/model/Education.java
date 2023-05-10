
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
public class Education implements Serializable {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
    private String title;
    private String period;
    private String institution;
    private String description;
    private String logoUrl;

    public Education() {
    }

    public Education(Person person, String title, String period, String institution, String description,
                     String logoUrl) {
        this.person = person;
        this.title = title;
        this.period = period;
        this.institution = institution;
        this.description = description;
        this.logoUrl = logoUrl;
    }
}
