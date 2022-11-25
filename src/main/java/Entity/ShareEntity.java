package Entity;

import jakarta.persistence.*;


@Entity
@Table(name = "share", schema = "fil_rouge")
public class ShareEntity {

    @EmbeddedId
    private SharedId idShare = new SharedId();
    @Basic
    @Column(name = "is_read_only")
    private boolean isReadOnly;
    @ManyToOne
    @MapsId("usersId")
    private  UsersEntity users;
    @ManyToOne
    @MapsId("planningId")
    private PlanningEntity planning;

    public SharedId getIdShare() {
        return idShare;
    }

    public void setIdShare(SharedId idShare) {
        this.idShare = idShare;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShareEntity that = (ShareEntity) o;

        if (isReadOnly != that.isReadOnly) return false;

        return true;
    }

    public UsersEntity getUsers() {
        return users;
    }

    public void setUsers(UsersEntity users) {
        this.users = users;
    }

    public PlanningEntity getPlanning() {
        return planning;
    }

    public void setPlanning(PlanningEntity planning) {
        this.planning = planning;
    }
}
