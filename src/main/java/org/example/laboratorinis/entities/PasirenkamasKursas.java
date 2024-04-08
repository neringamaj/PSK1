package org.example.laboratorinis.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class PasirenkamasKursas {
    @Id
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic(optional = false)
    private String pavadinimas;

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    @ManyToMany(mappedBy = "pasirenkamiKursai")
    private List<Studentas> studentai;

    public List<Studentas> getStudentai() {
        return studentai;
    }

    public void setStudentai(List<Studentas> studentai) {
        this.studentai = studentai;
    }
}
