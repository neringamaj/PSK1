package org.example.laboratorinis.persistence;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import org.example.laboratorinis.interceptors.LoggedInvocation;
import org.example.laboratorinis.entities.Course;
import org.example.laboratorinis.entities.Student;

@Model
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
        Integer teamId = Integer.parseInt(requestParameters.get("teamId"));
        this.course = coursesDao.findOne(teamId);
    }

    @Transactional
    @LoggedInvocation
    public void addStudentToCourse() {
        studentsToCreate.setGrupe(this.course);
        studentDao.persist(studentsToCreate);
    }

    public void deleteStudent(Integer id) {
    }
}
