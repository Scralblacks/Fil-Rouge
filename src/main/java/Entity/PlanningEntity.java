package Entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "planning", schema = "fil_rouge")
public class PlanningEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_planning")
    private int idPlanning;
    @Basic
    @Column(name = "name_planning")
    private String namePlanning;
    @Basic
    @Column(name = "date_created")
    private Timestamp dateCreated;
    @Basic
    @Column(name = "id_owner")
    private int idOwner;
    @OneToOne(mappedBy = "planning")
    private UsersEntity owner;
    @ManyToMany(mappedBy = "listSharedPlanning")
    private List<UsersEntity> listShareToUsers;
    @OneToMany(mappedBy = "planning")
    private List<EventEntity> listEvent;
    @OneToMany(mappedBy = "planning")
    private List<TaskEntity> listTask;

    public int getIdPlanning() {
        return idPlanning;
    }

    public void setIdPlanning(int idPlanning) {
        this.idPlanning = idPlanning;
    }

    public String getNamePlanning() {
        return namePlanning;
    }

    public void setNamePlanning(String namePlanning) {
        this.namePlanning = namePlanning;
    }

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    public int getIdOwner() {
        return idOwner;
    }

    public void setIdOwner(int idOwner) {
        this.idOwner = idOwner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlanningEntity that = (PlanningEntity) o;

        if (idPlanning != that.idPlanning) return false;
        if (idOwner != that.idOwner) return false;
        if (namePlanning != null ? !namePlanning.equals(that.namePlanning) : that.namePlanning != null) return false;
        if (dateCreated != null ? !dateCreated.equals(that.dateCreated) : that.dateCreated != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPlanning;
        result = 31 * result + (namePlanning != null ? namePlanning.hashCode() : 0);
        result = 31 * result + (dateCreated != null ? dateCreated.hashCode() : 0);
        result = 31 * result + idOwner;
        return result;
    }

    public UsersEntity getOwner() {
        return owner;
    }

    public void setOwner(UsersEntity owner) {
        this.owner = owner;
    }

    public List<UsersEntity> getListShareToUsers() {
        return listShareToUsers;
    }

    public void setListShareToUsers(List<UsersEntity> listShareToUsers) {
        this.listShareToUsers = listShareToUsers;
    }

    public List<EventEntity> getListEvent() {
        return listEvent;
    }

    public void setListEvent(List<EventEntity> listEvent) {
        this.listEvent = listEvent;
    }

    public List<TaskEntity> getListTask() {
        return listTask;
    }

    public void setListTask(List<TaskEntity> listTask) {
        this.listTask = listTask;
    }
}
