package Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "role", schema = "fil_rouge")
public class RoleEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_role")
    private int idRole;
    @Basic
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "role")
    private List<UsersEntity> listUsers;

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
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

        RoleEntity that = (RoleEntity) o;

        if (idRole != that.idRole) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idRole;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public List<UsersEntity> getListUsers() {
        return listUsers;
    }

    public void setListUsers(List<UsersEntity> listUsers) {
        this.listUsers = listUsers;
    }
}
