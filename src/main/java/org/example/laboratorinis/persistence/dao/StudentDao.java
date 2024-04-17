package org.example.laboratorinis.persistence.dao;

import org.example.laboratorinis.entities.Extracurricular;
import org.example.laboratorinis.entities.Student;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

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

    public void delete(Integer studentId) {
        Student student = findOne(studentId);

        if (!em.contains(student)) {
            student = em.merge(student);
        }
        em.remove(student);
    }

    public void deleteExtracurricular(Integer studentId, Extracurricular extracurricular) {
        Student student = findOne(studentId);

        if (!em.contains(student)) {
            student = em.merge(student);
        }

        student.getExtracurricular().remove(extracurricular);
        em.merge(student);
    }

    public List<Student> loadAll() {return em.createNamedQuery("Student.findAll", Student.class).getResultList();}

    public List<Student> loadAllCourseStudents(Integer id) {
        return em.createNamedQuery("Student.findAllCourseStudents", Student.class)
                .setParameter("id", id)
                .getResultList();}
}
