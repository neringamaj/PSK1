package org.example.laboratorinis.persistence.dao;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import org.example.laboratorinis.entities.Course;
import org.example.laboratorinis.entities.Student;

@Model
@ViewScoped
public class courseDetails implements Serializable {

    @Inject
    private CoursesDao coursesDao;

    @Inject
    private StudentDao studentDao;

    @Getter @Setter
    private Course course;

    @Getter @Setter
    private Student studentsToCreate = new Student();

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String idStr = requestParameters.get("courseId");
        Integer id = null;
        id = Integer.parseInt(idStr);

        this.course = coursesDao.findOne(id);
    }

    @Transactional
    public String addStudentToCourse() {
        studentsToCreate.setCourse(this.course);
        studentDao.persist(studentsToCreate);
        studentsToCreate = new Student();
        return "students.xhtml?faces-redirect=true&courseId=" + course.getId();
    }

    @Transactional
    public String deleteStudent(Integer studentId) {
        studentDao.delete(studentId);
        course.getStudents().removeIf(student -> student.getId().equals(studentId));
        return "students.xhtml?faces-redirect=true&courseId=" + course.getId();
    }
}
