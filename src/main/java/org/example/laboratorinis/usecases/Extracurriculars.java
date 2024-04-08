package org.example.laboratorinis.usecases;

import lombok.Getter;
import lombok.Setter;
import org.example.laboratorinis.entities.Extracurricular;
import org.example.laboratorinis.persistence.ExtracurricularsDao;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Extracurriculars {

    @Inject
    private ExtracurricularsDao extracurricularsDao;

    @Getter @Setter
    private Extracurricular extracurricularToCreate = new Extracurricular();

    @Getter
    private List<Extracurricular> extracurricularsAll;

    @PostConstruct
    public void init(){
        loadAllExtracurriculars();
    }

    @Transactional
    public void createExtracurricular(){
        this.extracurricularsDao.persist(extracurricularToCreate);
    }

    private void loadAllExtracurriculars(){
        this.extracurricularsAll = extracurricularsDao.loadAll();
    }
}
