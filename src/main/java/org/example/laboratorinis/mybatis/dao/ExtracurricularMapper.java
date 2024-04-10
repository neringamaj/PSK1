package org.example.laboratorinis.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.example.laboratorinis.mybatis.model.Extracurricular;

@Mapper
public interface ExtracurricularMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.EXTRACURRICULAR
     *
     * @mbg.generated Wed Apr 10 13:15:35 EEST 2024
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.EXTRACURRICULAR
     *
     * @mbg.generated Wed Apr 10 13:15:35 EEST 2024
     */
    int insert(Extracurricular record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.EXTRACURRICULAR
     *
     * @mbg.generated Wed Apr 10 13:15:35 EEST 2024
     */
    Extracurricular selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.EXTRACURRICULAR
     *
     * @mbg.generated Wed Apr 10 13:15:35 EEST 2024
     */
    List<Extracurricular> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.EXTRACURRICULAR
     *
     * @mbg.generated Wed Apr 10 13:15:35 EEST 2024
     */
    int updateByPrimaryKey(Extracurricular record);
}