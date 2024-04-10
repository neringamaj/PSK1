package org.example.laboratorinis.entities;

import javax.persistence.*;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.Objects;

@Entity
@NamedQueries({@NamedQuery(name = "Student.findAll", query = "select a from Student as a"), @NamedQuery(name = "Student.findAllCourseStudents", query = "select a from Student as a where a.course = :id")})
@Table(name = "STUDENT")
@Getter @Setter
public class Student implements Serializable {

    public Student(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic(optional = false)
    private String name;


    @Basic(optional = false)
    private String surname;


    @ManyToOne
    private Course course;


    @ManyToMany
    private List<Extracurricular> extracurricular;

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }*/
}

