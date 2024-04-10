package org.example.laboratorinis.mybatis.dao;

import java.util.List;

import org.mybatis.cdi.Mapper;
import org.example.laboratorinis.mybatis.model.Course;

@Mapper
public interface CourseMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.COURSE
     *
     * @mbg.generated Tue Apr 09 00:46:41 EEST 2024
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.COURSE
     *
     * @mbg.generated Tue Apr 09 00:46:41 EEST 2024
     */
    int insert(Course record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.COURSE
     *
     * @mbg.generated Tue Apr 09 00:46:41 EEST 2024
     */
    Course selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.COURSE
     *
     * @mbg.generated Tue Apr 09 00:46:41 EEST 2024
     */
    List<Course> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.COURSE
     *
     * @mbg.generated Tue Apr 09 00:46:41 EEST 2024
     */
    int updateByPrimaryKey(Course record);
}