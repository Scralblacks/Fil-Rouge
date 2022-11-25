package Entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "task", schema = "fil_rouge")
public class TaskEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_task")
    private int idTask;
    @Basic
    @Column(name = "name_task")
    private String nameTask;
    @Basic
    @Column(name = "date_created")
    private Timestamp dateCreated;
    @Basic
    @Column(name = "date_task_start")
    private Timestamp dateTaskStart;
    @Basic
    @Column(name = "date_task_end")
    private Timestamp dateTaskEnd;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "id_planning")
    private int idPlanning;
    @ManyToOne
    @JoinColumn(name = "id_planning", referencedColumnName = "id_planning", nullable = false)
    private PlanningEntity planning;
    @OneToMany(mappedBy = "task")
    private List<EventEntity> listEvent;

    public int getIdTask() {
        return idTask;
    }

    public void setIdTask(int idTask) {
        this.idTask = idTask;
    }

    public String getNameTask() {
        return nameTask;
    }

    public void setNameTask(String nameTask) {
        this.nameTask = nameTask;
    }

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Timestamp getDateTaskStart() {
        return dateTaskStart;
    }

    public void setDateTaskStart(Timestamp dateTaskStart) {
        this.dateTaskStart = dateTaskStart;
    }

    public Timestamp getDateTaskEnd() {
        return dateTaskEnd;
    }

    public void setDateTaskEnd(Timestamp dateTaskEnd) {
        this.dateTaskEnd = dateTaskEnd;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdPlanning() {
        return idPlanning;
    }

    public void setIdPlanning(int idPlanning) {
        this.idPlanning = idPlanning;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaskEntity that = (TaskEntity) o;

        if (idTask != that.idTask) return false;
        if (idPlanning != that.idPlanning) return false;
        if (nameTask != null ? !nameTask.equals(that.nameTask) : that.nameTask != null) return false;
        if (dateCreated != null ? !dateCreated.equals(that.dateCreated) : that.dateCreated != null) return false;
        if (dateTaskStart != null ? !dateTaskStart.equals(that.dateTaskStart) : that.dateTaskStart != null)
            return false;
        if (dateTaskEnd != null ? !dateTaskEnd.equals(that.dateTaskEnd) : that.dateTaskEnd != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTask;
        result = 31 * result + (nameTask != null ? nameTask.hashCode() : 0);
        result = 31 * result + (dateCreated != null ? dateCreated.hashCode() : 0);
        result = 31 * result + (dateTaskStart != null ? dateTaskStart.hashCode() : 0);
        result = 31 * result + (dateTaskEnd != null ? dateTaskEnd.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + idPlanning;
        return result;
    }

    public PlanningEntity getPlanning() {
        return planning;
    }

    public void setPlanning(PlanningEntity planning) {
        this.planning = planning;
    }

    public List<EventEntity> getListEvent() {
        return listEvent;
    }

    public void setListEvent(List<EventEntity> listEvent) {
        this.listEvent = listEvent;
    }
}
