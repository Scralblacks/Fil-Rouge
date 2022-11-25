package DAO;

import Entity.ActionEntity;
import Entity.RoleEntity;
import Utils.PersitantManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class RoleDao implements CrudDAO<RoleEntity> {
    @Override
    public List<RoleEntity> findAll() {
        return null;
    }

    @Override
    public Optional<RoleEntity> findById(Long id) {
        EntityManagerFactory emf = PersitantManager.getFactoryInstance();
        EntityManager em = emf.createEntityManager();
        return Optional.of(em.find(RoleEntity.class, id));
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public RoleEntity update(RoleEntity element) {
        return null;
    }

    @Override
    public RoleEntity create(RoleEntity element) {
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
    public Optional<RoleEntity> checkIfExists(RoleEntity element) {
        return Optional.empty();
    }
}