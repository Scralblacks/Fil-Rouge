package DAO;

import Entity.ActionEntity;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class RoleDao implements CrudDAO<ActionEntity>{
    @Override
    public List<ActionEntity> findAll() throws SQLException {
        return null;
    }

    @Override
    public Optional<ActionEntity> findById(Long id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) throws SQLException {
        return false;
    }

    @Override
    public ActionEntity update(ActionEntity element) throws SQLException {
        return null;
    }

    @Override
    public ActionEntity create(ActionEntity element) throws SQLException {
        return null;
    }
}
