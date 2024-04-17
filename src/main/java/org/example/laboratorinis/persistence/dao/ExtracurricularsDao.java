package org.example.laboratorinis.persistence.dao;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

import org.example.laboratorinis.entities.Extracurricular;

@ApplicationScoped
public class ExtracurricularsDao {

    @Inject
    private EntityManager em;

    public List<Extracurricular> loadAll() {
        return em.createNamedQuery("Extracurriculars.findAll", Extracurricular.class).getResultList();
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void persist(Extracurricular extracurricular){
        this.em.persist(extracurricular);
    }

    public Extracurricular findOne(Integer id) {
        return em.find(Extracurricular.class, id);
    }
}
