package Entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDate;
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
    private LocalDate dateCreated;
    @OneToOne(mappedBy = "planning")
    private UsersEntity owner;
    @OneToMany(mappedBy = "planning")
    private List<EventEntity> listEvent;
    @OneToMany(mappedBy = "planning")
    private List<TaskEntity> listTask;
    @OneToMany
    private List<ShareEntity> listShare;

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

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlanningEntity that = (PlanningEntity) o;

        if (idPlanning != that.idPlanning) return false;
        if (namePlanning != null ? !namePlanning.equals(that.namePlanning) : that.namePlanning != null) return false;
        if (dateCreated != null ? !dateCreated.equals(that.dateCreated) : that.dateCreated != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPlanning;
        result = 31 * result + (namePlanning != null ? namePlanning.hashCode() : 0);
        result = 31 * result + (dateCreated != null ? dateCreated.hashCode() : 0);
        return result;
    }

    public UsersEntity getOwner() {
        return owner;
    }

    public void setOwner(UsersEntity owner) {
        this.owner = owner;
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

    public List<ShareEntity> getLIstShare() {
        return listShare;
    }

    public void setShare(List<ShareEntity> listShare) {
        this.listShare = listShare;
    }

    public PlanningEntity(String namePlanning, LocalDate dateCreated) {
        this.namePlanning = namePlanning;
        this.dateCreated = dateCreated;
    }

    public PlanningEntity() {
    }

    public PlanningEntity(int idPlanning, String namePlanning, LocalDate dateCreated) {
        this.idPlanning = idPlanning;
        this.namePlanning = namePlanning;
        this.dateCreated = dateCreated;
    }

    public PlanningEntity(int idPlanning, String namePlanning, LocalDate dateCreated, UsersEntity user) {
        this.idPlanning = idPlanning;
        this.namePlanning = namePlanning;
        this.dateCreated = dateCreated;
        this.owner = user;
    }
}
