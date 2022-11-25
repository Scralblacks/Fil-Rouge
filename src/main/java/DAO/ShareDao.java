package DAO;

import Entity.ActionEntity;
import Entity.ShareEntity;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ShareDao implements CrudDAO<ShareEntity> {
    @Override
    public List<ShareEntity> findAll() throws SQLException {
        return null;
    }

    @Override
    public Optional<ShareEntity> findById(Long id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) throws SQLException {
        return false;
    }

    @Override
    public ShareEntity update(ShareEntity element) throws SQLException {
        return null;
    }

    @Override
    public ShareEntity create(ShareEntity element) throws SQLException {
        return null;
    }
}