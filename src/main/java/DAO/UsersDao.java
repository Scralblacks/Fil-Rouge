package DAO;

import Entity.UsersEntity;
import Utils.PersitantManager;
import jakarta.persistence.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UsersDao implements CrudDAO<UsersEntity> {
    @Override
    public List<UsersEntity> findAll() {
        return null;
    }

    @Override
    public Optional<UsersEntity> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public UsersEntity update(UsersEntity element) {
        return null;
    }

    @Override
    public UsersEntity create(UsersEntity element) {
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
    public Optional<UsersEntity> checkIfExists(UsersEntity element) {
        EntityManagerFactory emf = PersitantManager.getFactoryInstance();
        EntityManager em = emf.createEntityManager();
        TypedQuery<UsersEntity> query = em.createQuery("select u from UsersEntity u WHERE u.email=:e", UsersEntity.class);
        query.setParameter("e", element.getEmail());
        try {
            return Optional.of(query.getSingleResult());
        } catch (NoResultException e) {
            System.out.println("User doesn't exist. Need to create it first...");
        } finally {
            em.close();
        }
        return Optional.empty();
    }
}