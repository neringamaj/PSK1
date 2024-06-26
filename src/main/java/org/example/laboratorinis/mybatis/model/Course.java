package org.example.laboratorinis.mybatis.model;

import java.util.List;

public class Course {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.COURSE.ID
     *
     * @mbg.generated Wed Apr 10 13:15:35 EEST 2024
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.COURSE.NAME
     *
     * @mbg.generated Wed Apr 10 13:15:35 EEST 2024
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.COURSE.YEAR
     *
     * @mbg.generated Wed Apr 10 13:15:35 EEST 2024
     */
    private Integer year;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.COURSE.ID
     *
     * @return the value of PUBLIC.COURSE.ID
     *
     * @mbg.generated Wed Apr 10 13:15:35 EEST 2024
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.COURSE.ID
     *
     * @param id the value for PUBLIC.COURSE.ID
     *
     * @mbg.generated Wed Apr 10 13:15:35 EEST 2024
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.COURSE.NAME
     *
     * @return the value of PUBLIC.COURSE.NAME
     *
     * @mbg.generated Wed Apr 10 13:15:35 EEST 2024
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.COURSE.NAME
     *
     * @param name the value for PUBLIC.COURSE.NAME
     *
     * @mbg.generated Wed Apr 10 13:15:35 EEST 2024
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.COURSE.YEAR
     *
     * @return the value of PUBLIC.COURSE.YEAR
     *
     * @mbg.generated Wed Apr 10 13:15:35 EEST 2024
     */
    public Integer getYear() {
        return year;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.COURSE.YEAR
     *
     * @param year the value for PUBLIC.COURSE.YEAR
     *
     * @mbg.generated Wed Apr 10 13:15:35 EEST 2024
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    //additionally setting one to many relationship
    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student){
        this.students.add(student);
    }
}