package Entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

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
    @OneToOne(mappedBy = "Planning")
    private UsersEntity Owner;
    @OneToOne(mappedBy = "idPanning")
    private TaskEntity idTask;
    @OneToOne(mappedBy = "idPlanning")
    private EventEntity idEvent;
    @ManyToOne
    @JoinTable(name = "share", schema = "fil_rouge", joinColumns = @JoinColumn(name = "id_planning", referencedColumnName = "id_planning", nullable = false), inverseJoinColumns = @JoinColumn(name = "id_user", referencedColumnName = "id_user", nullable = false))
    private UsersEntity idUser;

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
        return Owner;
    }

    public void setOwner(UsersEntity owner) {
        Owner = owner;
    }

    public TaskEntity getIdTask() {
        return idTask;
    }

    public void setIdTask(TaskEntity idTask) {
        this.idTask = idTask;
    }

    public EventEntity getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(EventEntity idEvent) {
        this.idEvent = idEvent;
    }

    public UsersEntity getIdUser() {
        return idUser;
    }

    public void setIdUser(UsersEntity idUser) {
        this.idUser = idUser;
    }
}
