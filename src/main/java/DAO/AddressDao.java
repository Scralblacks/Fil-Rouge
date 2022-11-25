package DAO;

import Entity.ActionEntity;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class AddressDao implements CrudDAO<AddressDao> {
    @Override
    public List<AddressDao> findAll() throws SQLException {
        return null;
    }

    @Override
    public Optional<AddressDao> findById(Long id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) throws SQLException {
        return false;
    }

    @Override
    public AddressDao update(AddressDao element) throws SQLException {
        return null;
    }

    @Override
    public AddressDao create(AddressDao element) throws SQLException {
        return null;
    }
}