package Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "share", schema = "fil_rouge")
public class ShareEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_user")
    private int idUser;
    @Basic
    @Column(name = "is_read_only")
    private byte isReadOnly;
    @Basic
    @Column(name = "id_planning")
    private int idPlanning;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public byte getIsReadOnly() {
        return isReadOnly;
    }

    public void setIsReadOnly(byte isReadOnly) {
        this.isReadOnly = isReadOnly;
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

        ShareEntity that = (ShareEntity) o;

        if (idUser != that.idUser) return false;
        if (isReadOnly != that.isReadOnly) return false;
        if (idPlanning != that.idPlanning) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idUser;
        result = 31 * result + (int) isReadOnly;
        result = 31 * result + idPlanning;
        return result;
    }
}
