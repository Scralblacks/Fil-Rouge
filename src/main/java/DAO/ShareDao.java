package DAO;

import Entity.ActionEntity;
import Entity.ShareEntity;
import Utils.PersitantManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ShareDao implements CrudDAO<ShareEntity> {
    @Override
    public List<ShareEntity> findAll() {
        return null;
    }

    @Override
    public Optional<ShareEntity> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public ShareEntity update(ShareEntity element) {
        return null;
    }

    @Override
    public ShareEntity create(ShareEntity element) {
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
    public Optional<ShareEntity> checkIfExists(ShareEntity element) {
        return Optional.empty();
    }
}