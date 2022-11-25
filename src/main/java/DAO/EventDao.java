package DAO;

import Entity.ActionEntity;
import Entity.EventEntity;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class EventDao implements CrudDAO<EventEntity> {
    @Override
    public List<EventEntity> findAll() throws SQLException {
        return null;
    }

    @Override
    public Optional<EventEntity> findById(Long id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) throws SQLException {
        return false;
    }

    @Override
    public EventEntity update(EventEntity element) throws SQLException {
        return null;
    }

    @Override
    public EventEntity create(EventEntity element) throws SQLException {
        return null;
    }
}