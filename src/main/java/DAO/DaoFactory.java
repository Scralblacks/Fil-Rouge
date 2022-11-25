package DAO;

import Entity.*;

public class DaoFactory {

    private DaoFactory() {

    }
    public static CrudDAO<UsersEntity> getUsersDao(){return new UsersDao();}
    public static CrudDAO<PlanningEntity> getPlanningDao(){return new PlanningDao();}
    public static CrudDAO<TaskEntity> getTaskDao(){return new TaskDao();}
    public static CrudDAO<ActionEntity> getActionDao(){return new ActionDao();}
    public static CrudDAO<AddressEntity> getAddressDao(){return new AddressDao();}
    public static CrudDAO<EventEntity> getEventDao(){return new EventDao();}
    public static CrudDAO<RoleEntity> getRoleDao(){return new RoleDao();}
    public static CrudDAO<ShareEntity> getShareDao(){return new ShareDao();}
}