package org.example.laboratorinis.mybatis.model;

import java.util.List;

public class Student {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.STUDENT.ID
     *
     * @mbg.generated Wed Apr 10 13:15:35 EEST 2024
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.STUDENT.NAME
     *
     * @mbg.generated Wed Apr 10 13:15:35 EEST 2024
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.STUDENT.SURNAME
     *
     * @mbg.generated Wed Apr 10 13:15:35 EEST 2024
     */
    private String surname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.STUDENT.COURSE_ID
     *
     * @mbg.generated Wed Apr 10 13:15:35 EEST 2024
     */
    private Integer courseId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.STUDENT.ID
     *
     * @return the value of PUBLIC.STUDENT.ID
     *
     * @mbg.generated Wed Apr 10 13:15:35 EEST 2024
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.STUDENT.ID
     *
     * @param id the value for PUBLIC.STUDENT.ID
     *
     * @mbg.generated Wed Apr 10 13:15:35 EEST 2024
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.STUDENT.NAME
     *
     * @return the value of PUBLIC.STUDENT.NAME
     *
     * @mbg.generated Wed Apr 10 13:15:35 EEST 2024
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.STUDENT.NAME
     *
     * @param name the value for PUBLIC.STUDENT.NAME
     *
     * @mbg.generated Wed Apr 10 13:15:35 EEST 2024
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.STUDENT.SURNAME
     *
     * @return the value of PUBLIC.STUDENT.SURNAME
     *
     * @mbg.generated Wed Apr 10 13:15:35 EEST 2024
     */
    public String getSurname() {
        return surname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.STUDENT.SURNAME
     *
     * @param surname the value for PUBLIC.STUDENT.SURNAME
     *
     * @mbg.generated Wed Apr 10 13:15:35 EEST 2024
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.STUDENT.COURSE_ID
     *
     * @return the value of PUBLIC.STUDENT.COURSE_ID
     *
     * @mbg.generated Wed Apr 10 13:15:35 EEST 2024
     */
    public Integer getCourseId() {
        return courseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.STUDENT.COURSE_ID
     *
     * @param courseId the value for PUBLIC.STUDENT.COURSE_ID
     *
     * @mbg.generated Wed Apr 10 13:15:35 EEST 2024
     */
    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    //additionally defining many to many relationship
    private List<Extracurricular> extracurriculars;

    public void setExtracurriculars(List<Extracurricular> extracurriculars) {
        this.extracurriculars = extracurriculars;
    }

    public void addExtracurricular(Extracurricular extracurriculars) {
        this.extracurriculars.add(extracurriculars);
    }

    public List<Extracurricular> getExtracurriculars() {
        return extracurriculars;
    }
}