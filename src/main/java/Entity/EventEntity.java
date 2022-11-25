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
    @ManyToOne
    @JoinColumn(name = "id_planning", referencedColumnName = "id_planning", nullable = false)
    private PlanningEntity planning;
    @ManyToOne
    @JoinColumn(name = "id_task", referencedColumnName = "id_task", nullable = false)
    private TaskEntity task;
    @ManyToOne
    @JoinColumn(name = "id_action", referencedColumnName = "id_action", nullable = false)
    private ActionEntity action;

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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EventEntity that = (EventEntity) o;

        if (idEvent != that.idEvent) return false;
        if (dateCreated != null ? !dateCreated.equals(that.dateCreated) : that.dateCreated != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEvent;
        result = 31 * result + (dateCreated != null ? dateCreated.hashCode() : 0);
        return result;
    }

    public PlanningEntity getPlanning() {
        return planning;
    }

    public void setPlanning(PlanningEntity planning) {
        this.planning = planning;
    }

    public TaskEntity getTask() {
        return task;
    }

    public void setTask(TaskEntity task) {
        this.task = task;
    }

    public ActionEntity getAction() {
        return action;
    }

    public void setAction(ActionEntity action) {
        this.action = action;
    }
}
