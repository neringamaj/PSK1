package org.example.laboratorinis.entities;

import javax.persistence.*;
import java.util.List;
import lombok.EqualsAndHashCode;

@Entity
public class Grupe {
    @GeneratedValue
    @Id
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic(optional = false)
    private String specialybe;

    public String getSpecialybe() {
        return specialybe;
    }

    public void setSpecialybe(String specialybe) {
        this.specialybe = specialybe;
    }

    @Basic(optional = false)
    private Integer kursas;

    public Integer getKursas() {
        return kursas;
    }

    public void setKursas(Integer kursas) {
        this.kursas = kursas;
    }

    @OneToMany(mappedBy = "grupe")
    private List<Studentas> studentai;

    public List<Studentas> getStudentai() {
        return studentai;
    }

    public void setStudentai(List<Studentas> studentai) {
        this.studentai = studentai;
    }
}
