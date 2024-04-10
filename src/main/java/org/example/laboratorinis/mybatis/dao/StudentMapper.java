package org.example.laboratorinis.mybatis.dao;

import java.util.List;

import org.mybatis.cdi.Mapper;
import org.example.laboratorinis.mybatis.model.Student;

@Mapper
public interface StudentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.STUDENT
     *
     * @mbg.generated Tue Apr 09 00:46:41 EEST 2024
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.STUDENT
     *
     * @mbg.generated Tue Apr 09 00:46:41 EEST 2024
     */
    int insert(Student record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.STUDENT
     *
     * @mbg.generated Tue Apr 09 00:46:41 EEST 2024
     */
    Student selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.STUDENT
     *
     * @mbg.generated Tue Apr 09 00:46:41 EEST 2024
     */
    List<Student> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.STUDENT
     *
     * @mbg.generated Tue Apr 09 00:46:41 EEST 2024
     */
    int updateByPrimaryKey(Student record);
}