package org.example.laboratorinis.persistence.dao;

import lombok.Getter;
import lombok.Setter;
import org.example.laboratorinis.mybatis.dao.CourseMapper;
import org.example.laboratorinis.mybatis.dao.StudentMapper;
import org.example.laboratorinis.mybatis.model.Course;
import org.example.laboratorinis.mybatis.model.Student;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@Model
@ViewScoped
@Named
@Getter @Setter
public class courseDetailsMyBatis implements Serializable {

    @Inject
    private CourseMapper coursesDao;

    @Inject
    private StudentMapper studentDao;

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

        this.course = coursesDao.selectByPrimaryKey(id);
    }

    @Transactional
    public String addStudentToCourse() {
        studentsToCreate.setCourseId(this.course.getId());
        studentDao.insert(studentsToCreate);
        studentsToCreate = new Student();
        return "http://localhost:8092/laboratorinis/";
    }

    @Transactional
    public String deleteStudent(Integer studentId) {
        studentDao.deleteByPrimaryKey(studentId);
        studentDao.selectAll();
        return "http://localhost:8092/laboratorinis/";
    }
}
