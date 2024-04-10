package org.example.laboratorinis.usecases;

import lombok.Getter;
import lombok.Setter;
import org.example.laboratorinis.entities.Course;
import org.example.laboratorinis.persistence.dao.CoursesDao;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Courses {

    @Inject
    private CoursesDao coursesDao;

    @Getter @Setter
    private Course courseToCreate = new Course();

    @Getter
    private List<Course> allCourses;

    @PostConstruct
    public void init(){
        loadAllCourses();
    }

    @Transactional
    public void createCourse(){
        this.coursesDao.persist(courseToCreate);
    }

    private void loadAllCourses(){
        this.allCourses = coursesDao.loadAll();
    }
}
