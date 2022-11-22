package DAO;

import Entity.ActionEntity;

public class DaoFactory {

    private DaoFactory() {
    }

    public static CrudDAO<ActionEntity> getRecipeDao() {
        return new ActionDao();
    }
}