package DAO;

import Entity.ActionEntity;
import Entity.TaskEntity;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class TaskDao implements CrudDAO<TaskEntity> {
    @Override
    public List<TaskEntity> findAll() throws SQLException {
        return null;
    }

    @Override
    public Optional<TaskEntity> findById(Long id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) throws SQLException {
        return false;
    }

    @Override
    public TaskEntity update(TaskEntity element) throws SQLException {
        return null;
    }

    @Override
    public TaskEntity create(TaskEntity element) throws SQLException {
        return null;
    }
}