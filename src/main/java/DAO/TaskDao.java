package DAO;

import Entity.ActionEntity;
import Entity.TaskEntity;
import Utils.PersitantManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class TaskDao implements CrudDAO<TaskEntity> {
    @Override
    public List<TaskEntity> findAll() {
        return null;
    }

    @Override
    public Optional<TaskEntity> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public TaskEntity update(TaskEntity element) {
        return null;
    }

    @Override
    public TaskEntity create(TaskEntity element) {
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
    public Optional<TaskEntity> checkIfExists(TaskEntity element) {
        return Optional.empty();
    }
}