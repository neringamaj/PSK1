package org.example.laboratorinis.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.Getter;
import lombok.Setter;

@Entity
@NamedQueries({
        @NamedQuery(name = "Course.findAll", query = "select t from Course as t")
})
@Table(name = "COURSE")
@Getter
@Setter
public class Course {
    public Course(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic(optional = false)
    private String specialty;

    @Basic(optional = false)
    private Integer kursas;

    @OneToMany(mappedBy = "grupe")
    private List<Student> students = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course team = (Course) o;
        return Objects.equals(specialty, team.specialty);
    }

    @Override
    public int hashCode() {

        return Objects.hash(specialty);
    }
}
