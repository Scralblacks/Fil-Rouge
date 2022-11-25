package DAO;

import Entity.ActionEntity;
import Entity.AddressEntity;
import Entity.UsersEntity;
import Utils.PersitantManager;
import jakarta.persistence.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class AddressDao implements CrudDAO<AddressEntity> {
    @Override
    public List<AddressEntity> findAll() {
        return null;
    }

    @Override
    public Optional<AddressEntity> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public AddressEntity update(AddressEntity element) {
        return null;
    }

    @Override
    public AddressEntity create(AddressEntity element) {
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
    public Optional<AddressEntity> checkIfExists(AddressEntity element) {
        EntityManagerFactory emf = PersitantManager.getFactoryInstance();
        EntityManager em = emf.createEntityManager();
        TypedQuery<AddressEntity> query = em.createQuery("select a from AddressEntity a WHERE a.city=:e and a.postalCode=:f", AddressEntity.class);
        query.setParameter("e", element.getCity())
                .setParameter("f", element.getPostalCode());
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

