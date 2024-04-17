package org.example.laboratorinis.entities;

import javax.persistence.*;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.Objects;

@Entity
@NamedQueries({@NamedQuery(name = "Student.findAll", query = "select a from Student as a"),
        @NamedQuery(name = "Student.findAllCourseStudents", query = "select a from Student as a where a.course = :id")})
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
}

