package org.example.laboratorinis.persistence.dao;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import lombok.Getter;
import lombok.Setter;
import org.example.laboratorinis.entities.Extracurricular;
import org.example.laboratorinis.entities.Student;

@Model
@ViewScoped
public class extracurricularDetail implements Serializable {

    @Inject
    private ExtracurricularsDao extracurricularsDao;

    @Inject
    private StudentDao studentDao;

    @Getter @Setter
    private Extracurricular extracurriculars;

    @Getter @Setter
    private Student studentsToCreate = new Student();

    @PostConstruct
    public void init() {
            Map<String, String> requestParameters =
                    FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
            String idStr = requestParameters.get("extracurricularId");
            Integer id = null;
            id = Integer.parseInt(idStr);

            this.extracurriculars = extracurricularsDao.findOne(id);
    }

    @Transactional
    public String addStudentToExtracurricular() {
        Student student = studentDao.findOne(studentsToCreate.getId());
        List<Extracurricular> studentsextracurriculars = student.getExtracurricular();

        for(int i = 0; i < studentsextracurriculars.size(); ++i)
            if (Objects.equals(studentsextracurriculars.get(i).getName(), extracurriculars.getName()))
                return "studentsExtracurriculars.xhtml?faces-redirect=true&extracurricularId=" + extracurriculars.getId();

        if(!student.getExtracurricular().contains(this.extracurriculars))
        {
            student.getExtracurricular().add(this.extracurriculars);
            if (!this.extracurriculars.getStudents().contains(student)) {
                this.extracurriculars.getStudents().add(student);
            }

            studentDao.update(student);
        }

        return "studentsExtracurriculars.xhtml?faces-redirect=true&extracurricularId=" + extracurriculars.getId();
    }

    @Transactional
    public String deleteStudent(Integer studentId) {
        studentDao.deleteExtracurricular(studentId, this.extracurriculars);
        extracurriculars.getStudents().removeIf(student -> student.getId().equals(studentId));
        return "studentsExtracurriculars.xhtml?faces-redirect=true&extracurricularId=" + extracurriculars.getId();
    }
}
