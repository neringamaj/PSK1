package org.example.laboratorinis.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Studentas {
    @Id
    @GeneratedValue
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Basic(optional = false)
    private String vardas;

    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    @Basic(optional = false)
    private String pavarde;

    public String getPavarde() {
        return pavarde;
    }

    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }

    @ManyToOne
    private Grupe grupe;

    public Grupe getGrupe() {
        return grupe;
    }

    public void setGrupe(Grupe grupe) {
        this.grupe = grupe;
    }

    @ManyToMany
    private List<PasirenkamasKursas> pasirenkamiKursai;

    public List<PasirenkamasKursas> getPasirenkamiKursai() {
        return pasirenkamiKursai;
    }

    public void setPasirenkamiKursai(List<PasirenkamasKursas> pasirenkamiKursai) {
        this.pasirenkamiKursai = pasirenkamiKursai;
    }
}
