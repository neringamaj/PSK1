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
    private String pavadinimas;

    @ManyToMany(mappedBy = "pasirenkamiKursai")
    private List<Student> studentai;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Extracurricular team = (Extracurricular) o;
        return Objects.equals(pavadinimas, team.pavadinimas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pavadinimas);
    }
}

