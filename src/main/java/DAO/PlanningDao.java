package DAO;

import Entity.ActionEntity;
import Entity.PlanningEntity;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class PlanningDao implements CrudDAO<PlanningEntity> {

    @Override
    public List<PlanningEntity> findAll() throws SQLException {
        return null;
    }

    @Override
    public Optional<PlanningEntity> findById(Long id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) throws SQLException {
        return false;
    }

    @Override
    public PlanningEntity update(PlanningEntity element) throws SQLException {
        return null;
    }

    @Override
    public PlanningEntity create(PlanningEntity element) throws SQLException {
        return null;
    }
}