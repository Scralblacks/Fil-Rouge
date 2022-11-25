package DAO;

import Entity.UsersEntity;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UsersDao implements CrudDAO<UsersEntity> {
    @Override
    public List<UsersEntity> findAll() throws SQLException {
        return null;
    }

    @Override
    public Optional<UsersEntity> findById(Long id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) throws SQLException {
        return false;
    }

    @Override
    public UsersEntity update(UsersEntity element) throws SQLException {
        return null;
    }

    @Override
    public UsersEntity create(UsersEntity element) throws SQLException {
        return null;
    }
}