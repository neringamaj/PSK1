package org.example.laboratorinis.persistence.dao;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import org.example.laboratorinis.entities.Extracurricular;
import org.example.laboratorinis.entities.Student;
import org.example.laboratorinis.usecases.Extracurriculars;

@Model
public class extracurricularDetail implements Serializable {

    @Inject
    private ExtracurricularsDao extracurricularsDao;

    @Inject
    private StudentDao studentDao;

    @Getter @Setter
    private Extracurricular extracurriculars;

    @Getter @Setter
    private Student studentsToCreate = new Student();

    @Getter @Setter
    private Integer extracurricularId;

    @PostConstruct
    public void init() {
        if (extracurricularId != null) {
            this.extracurriculars = extracurricularsDao.findOne(extracurricularId);
        } else {
            Map<String, String> requestParameters =
                    FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
            String idStr = requestParameters.get("extracurricularId");
            Integer id = Integer.parseInt(idStr);
            this.extracurriculars = extracurricularsDao.findOne(id);
        }
    }

    @Transactional
    public String addStudentToExtracurricular() {
        Student student = studentDao.findByNameAndSurname(studentsToCreate.getName(), studentsToCreate.getSurname());

        if (student == null) {
            student = new Student();
            student.setName(studentsToCreate.getName());
            student.setSurname(studentsToCreate.getSurname());
        }

        student.getExtracurricular().add(extracurriculars); // Add this extracurricular to the student's list

        if (!extracurriculars.getStudents().contains(student)) {
            extracurriculars.getStudents().add(student);
        }

        studentDao.persist(student);

        return "index";
    }

    @Transactional
    public String deleteStudent(Integer studentId) {
        studentDao.deleteExtracurricular(studentId, this.extracurriculars);
        extracurriculars.getStudents().removeIf(student -> student.getId().equals(studentId));
        return "index";
    }
}
