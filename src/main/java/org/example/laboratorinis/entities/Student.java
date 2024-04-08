package org.example.laboratorinis.entities;

import javax.persistence.*;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Student.findAll", query = "select a from Student as a")
})
@Table(name = "STUDENT")
@Getter @Setter
public class Student implements Serializable {

    public Student(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic(optional = false)
    private String vardas;


    @Basic(optional = false)
    private String pavarde;


    @ManyToOne
    private Course grupe;


    @ManyToMany
    private List<Extracurricular> pasirenkamiKursai;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) &&
                Objects.equals(vardas, student.vardas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, vardas);
    }
}

