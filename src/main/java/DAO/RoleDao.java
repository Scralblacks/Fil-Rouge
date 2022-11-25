package DAO;

import Entity.ActionEntity;
import Entity.RoleEntity;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class RoleDao implements CrudDAO<RoleEntity> {
    @Override
    public List<RoleEntity> findAll() throws SQLException {
        return null;
    }

    @Override
    public Optional<RoleEntity> findById(Long id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) throws SQLException {
        return false;
    }

    @Override
    public RoleEntity update(RoleEntity element) throws SQLException {
        return null;
    }

    @Override
    public RoleEntity create(RoleEntity element) throws SQLException {
        return null;
    }
}