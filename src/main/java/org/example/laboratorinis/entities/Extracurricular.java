package org.example.laboratorinis.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Extracurriculars.findAll", query = "select t from Extracurricular as t")
})
@Table(name = "EXTRACURRICULAR")
@Getter
@Setter
public class Extracurricular {
    public Extracurricular(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic(optional = false)
    private String name;

    @ManyToMany(mappedBy = "extracurricular")
    private List<Student> students;

}

