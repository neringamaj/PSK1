package org.example.laboratorinis.usecases;

import lombok.Getter;
import lombok.Setter;
import org.example.laboratorinis.mybatis.dao.CourseMapper;
import org.example.laboratorinis.mybatis.model.Course;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
@Model
@SessionScoped
public class CoursesMyBatis implements Serializable {
    @Inject
    private CourseMapper courseMapper;

    @Getter
    private List<Course> allCourses;

    @Getter @Setter
    private Course courseToCreate = new Course();

    @PostConstruct
    public void init(){loadAllCourses();}

    private void loadAllCourses(){this.allCourses = courseMapper.selectAll();}

    @Transactional
    public void createCourse() {
        this.courseMapper.insert(courseToCreate);
        loadAllCourses();
        courseToCreate = new Course();
    }

}
