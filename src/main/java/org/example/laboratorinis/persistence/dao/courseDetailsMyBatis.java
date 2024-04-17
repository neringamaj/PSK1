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
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@Model
@ViewScoped
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

        this.course = coursesDao.selectCourseById(id);
        this.course.setStudents(coursesDao.selectStudentsForCourse(id));
    }

    @Transactional
    public String addStudentToCourse() {
        studentsToCreate.setCourseId(this.course.getId());
        int studentId = studentDao.insert(studentsToCreate);
        studentsToCreate = new Student();
        course.addStudent(studentDao.selectByPrimaryKey(studentId));
        return "studentsMyBatis.xhtml?faces-redirect=true&courseId=" + course.getId();
    }

    @Transactional
    public String deleteStudent(Integer id) {
        studentDao.deleteByPrimaryKey(id);
        course.setStudents(coursesDao.selectStudentsForCourse(this.course.getId()));
        return "studentsMyBatis.xhtml?faces-redirect=true&courseId=" + course.getId();
    }
}
