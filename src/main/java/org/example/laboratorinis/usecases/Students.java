package org.example.laboratorinis.usecases;

import lombok.Getter;
import lombok.Setter;
import org.example.laboratorinis.entities.Course;
import org.example.laboratorinis.entities.Student;
import org.example.laboratorinis.persistence.dao.CoursesDao;
import org.example.laboratorinis.persistence.dao.StudentDao;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Students {

    @Inject
    private StudentDao studentDao;

    @Inject
    private CoursesDao coursesDao;

    @Getter @Setter
    private Course course = new Course();

    @Getter @Setter
    private Student studentToCreate = new Student();

    @Getter
    private List<Student> allStudents, allCourseStudents;

    @PostConstruct
    public void init(){
        loadAllStudents();
    }

    @Transactional
    public void createStudent(){
        studentToCreate.setCourse(coursesDao.findOne(course.getId()));
        this.studentDao.persist(studentToCreate);
    }

    private void loadAllStudents(){
        this.allStudents = studentDao.loadAll();
    }

    @Transactional
    public String deleteStudent(Integer id){
        this.studentDao.delete(id);
        return "studentsList?faces-redirect=true";
    }

}
