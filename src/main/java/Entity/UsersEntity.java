package Entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "users", schema = "fil_rouge")
public class UsersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_user")
    private int idUser;
    @Basic
    @Column(name = "pseudo")
    private String pseudo;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "photo")
    private byte[] photo;
    @Basic
    @Column(name = "date_last_login")
    private Timestamp dateLastLogin;
    @Basic
    @Column(name = "id_role")
    private int idRole;
    @Basic
    @Column(name = "id_address")
    private int idAddress;
    @Basic
    @Column(name = "id_planning")
    private int idPlanning;
    @ManyToOne
    @JoinColumn(name = "id_address", referencedColumnName = "id_address", nullable = false)
    private AddressEntity address;
    @ManyToOne
    @JoinColumn(name = "id_role", referencedColumnName = "id_role", nullable = false)
    private RoleEntity role;
    @OneToOne
    @JoinColumn(name = "id_planning", referencedColumnName = "id_planning", nullable = false)
    private PlanningEntity planning;
    @ManyToMany
    @JoinTable(name = "share", schema = "fil_rouge", joinColumns = @JoinColumn(name = "id_user", referencedColumnName = "id_user", nullable = false), inverseJoinColumns = @JoinColumn(name = "id_planning", referencedColumnName = "id_planning", nullable = false))
    private List<PlanningEntity> listSharedPlanning;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public Timestamp getDateLastLogin() {
        return dateLastLogin;
    }

    public void setDateLastLogin(Timestamp dateLastLogin) {
        this.dateLastLogin = dateLastLogin;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public int getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(int idAddress) {
        this.idAddress = idAddress;
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

        UsersEntity that = (UsersEntity) o;

        if (idUser != that.idUser) return false;
        if (idRole != that.idRole) return false;
        if (idAddress != that.idAddress) return false;
        if (idPlanning != that.idPlanning) return false;
        if (pseudo != null ? !pseudo.equals(that.pseudo) : that.pseudo != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (!Arrays.equals(photo, that.photo)) return false;
        if (dateLastLogin != null ? !dateLastLogin.equals(that.dateLastLogin) : that.dateLastLogin != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idUser;
        result = 31 * result + (pseudo != null ? pseudo.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(photo);
        result = 31 * result + (dateLastLogin != null ? dateLastLogin.hashCode() : 0);
        result = 31 * result + idRole;
        result = 31 * result + idAddress;
        result = 31 * result + idPlanning;
        return result;
    }

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }

    public PlanningEntity getPlanning() {
        return planning;
    }

    public void setPlanning(PlanningEntity planning) {
        this.planning = planning;
    }

    public List<PlanningEntity> getListSharedPlanning() {
        return listSharedPlanning;
    }

    public void setListSharedPlanning(List<PlanningEntity> listSharedPlanning) {
        this.listSharedPlanning = listSharedPlanning;
    }
}
