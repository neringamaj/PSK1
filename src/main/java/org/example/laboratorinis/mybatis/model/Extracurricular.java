package org.example.laboratorinis.mybatis.model;

public class Extracurricular {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.EXTRACURRICULAR.ID
     *
     * @mbg.generated Tue Apr 09 00:46:41 EEST 2024
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.EXTRACURRICULAR.PAVADINIMAS
     *
     * @mbg.generated Tue Apr 09 00:46:41 EEST 2024
     */
    private String pavadinimas;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.EXTRACURRICULAR.ID
     *
     * @return the value of PUBLIC.EXTRACURRICULAR.ID
     *
     * @mbg.generated Tue Apr 09 00:46:41 EEST 2024
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.EXTRACURRICULAR.ID
     *
     * @param id the value for PUBLIC.EXTRACURRICULAR.ID
     *
     * @mbg.generated Tue Apr 09 00:46:41 EEST 2024
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.EXTRACURRICULAR.PAVADINIMAS
     *
     * @return the value of PUBLIC.EXTRACURRICULAR.PAVADINIMAS
     *
     * @mbg.generated Tue Apr 09 00:46:41 EEST 2024
     */
    public String getPavadinimas() {
        return pavadinimas;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.EXTRACURRICULAR.PAVADINIMAS
     *
     * @param pavadinimas the value for PUBLIC.EXTRACURRICULAR.PAVADINIMAS
     *
     * @mbg.generated Tue Apr 09 00:46:41 EEST 2024
     */
    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }
}