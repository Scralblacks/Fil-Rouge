package DAO;

import Entity.ActionEntity;
import Entity.EventEntity;
import Utils.PersitantManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class EventDao implements CrudDAO<EventEntity> {
    @Override
    public List<EventEntity> findAll() {
        return null;
    }

    @Override
    public Optional<EventEntity> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public EventEntity update(EventEntity element) {
        return null;
    }

    @Override
    public EventEntity create(EventEntity element) {
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
    public Optional<EventEntity> checkIfExists(EventEntity element) {
        return Optional.empty();
    }
}