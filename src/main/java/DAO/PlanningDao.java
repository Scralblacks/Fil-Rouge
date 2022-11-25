package DAO;

import Entity.ActionEntity;
import Entity.PlanningEntity;
import Utils.PersitantManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class PlanningDao implements CrudDAO<PlanningEntity> {

    @Override
    public List<PlanningEntity> findAll() {
        return null;
    }

    @Override
    public Optional<PlanningEntity> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public PlanningEntity update(PlanningEntity element) {
        return null;
    }

    @Override
    public PlanningEntity create(PlanningEntity element) {
        EntityManagerFactory emf = PersitantManager.getFactoryInstance();
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(element);
            et.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if(et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }
        return element;
    }

    @Override
    public Optional<PlanningEntity> checkIfExists(PlanningEntity element) {
        return Optional.empty();
    }
}