package DAO;

import Entity.ActionEntity;
import Utils.PersitantManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.Optional;

public class ActionDao implements CrudDAO<ActionEntity> {
    @Override
    public List<ActionEntity> findAll() {
        return null;
    }

    @Override
    public Optional<ActionEntity> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public ActionEntity update(ActionEntity element) {
        return null;
    }

    @Override
    public ActionEntity create(ActionEntity element) {
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
    public Optional<ActionEntity> checkIfExists(ActionEntity element) {
        return Optional.empty();
    }
}