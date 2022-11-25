package Entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SharedId implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long usersId;
    private Long planningId;

    public SharedId() {

    }

    public SharedId(Long usersId, Long planningId) {
        super();
        this.usersId = usersId;
        this.planningId = planningId;
    }

    public Long getUsersId() {
        return usersId;
    }

    public void setUsersId(Long usersId) {
        this.usersId = usersId;
    }

    public Long getPlanningId() {
        return planningId;
    }

    public void setPlanningId(Long planningId) {
        this.planningId = planningId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((usersId == null) ? 0 : usersId.hashCode());
        result = prime * result
                + ((planningId == null) ? 0 : planningId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SharedId other = (SharedId) obj;
        return Objects.equals(getUsersId(), other.getUsersId()) && Objects.equals(getPlanningId(), other.getPlanningId());
    }
}
