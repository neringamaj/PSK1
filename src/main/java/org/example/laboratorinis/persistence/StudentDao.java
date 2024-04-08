package org.example.laboratorinis.persistence;

import org.example.laboratorinis.entities.Student;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class StudentDao {

    @Inject
    private EntityManager em;

    public void persist(Student student){
        this.em.persist(student);
    }

    public Student findOne(Integer id){
        return em.find(Student.class, id);
    }

    public Student update(Student student){
        return em.merge(student);
    }
}
