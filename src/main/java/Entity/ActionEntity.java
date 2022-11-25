package Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "action", schema = "fil_rouge")
public class ActionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_action")
    private int idAction;
    @Basic
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "action")
    private List<EventEntity> listEvent;

    public int getIdAction() {
        return idAction;
    }

    public void setIdAction(int idAction) {
        this.idAction = idAction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActionEntity that = (ActionEntity) o;

        if (idAction != that.idAction) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idAction;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public List<EventEntity> getListEvent() {
        return listEvent;
    }

    public void setListEvent(List<EventEntity> listEvent) {
        this.listEvent = listEvent;
    }
}
