package Entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "event", schema = "fil_rouge")
public class EventEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_event")
    private int idEvent;
    @Basic
    @Column(name = "date_created")
    private Timestamp dateCreated;
    @Basic
    @Column(name = "id_task")
    private int Task;
    @Basic
    @Column(name = "id_action")
    private int Action;
    @Basic
    @Column(name = "id_planning")
    private int Planning;
    @OneToOne(mappedBy = "idEvent")
    private TaskEntity idTask;
    @OneToOne(mappedBy = "idEvent")
    private ActionEntity idAction;
    @OneToOne
    @JoinColumn(name = "id_planning", referencedColumnName = "id_planning", nullable = false)
    private PlanningEntity idPlanning;

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    public int getTask() {
        return Task;
    }

    public void setTask(int task) {
        Task = task;
    }

    public int getAction() {
        return Action;
    }

    public void setAction(int action) {
        Action = action;
    }

    public int getPlanning() {
        return Planning;
    }

    public void setPlanning(int planning) {
        Planning = planning;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EventEntity that = (EventEntity) o;

        if (idEvent != that.idEvent) return false;
        if (Task != that.Task) return false;
        if (Action != that.Action) return false;
        if (Planning != that.Planning) return false;
        if (dateCreated != null ? !dateCreated.equals(that.dateCreated) : that.dateCreated != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEvent;
        result = 31 * result + (dateCreated != null ? dateCreated.hashCode() : 0);
        result = 31 * result + Task;
        result = 31 * result + Action;
        result = 31 * result + Planning;
        return result;
    }

    public TaskEntity getIdTask() {
        return idTask;
    }

    public void setIdTask(TaskEntity idTask) {
        this.idTask = idTask;
    }

    public ActionEntity getIdAction() {
        return idAction;
    }

    public void setIdAction(ActionEntity idAction) {
        this.idAction = idAction;
    }

    public PlanningEntity getIdPlanning() {
        return idPlanning;
    }

    public void setIdPlanning(PlanningEntity idPlanning) {
        this.idPlanning = idPlanning;
    }
}
