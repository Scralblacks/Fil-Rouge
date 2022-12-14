package DAO;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface CrudDAO<E> {

        List<E> findAll();

        Optional<E> findById(Long id);

        boolean delete(Long id);

        E update(E element);

        E create(E element);

        Optional<E> checkIfExists(E element);
    }

