package Entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "users", schema = "fil_rouge")
public class UsersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_user")
    private Long idUser;
    @Basic
    @Column(name = "pseudo")
    private String pseudo;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "password")
    private byte[] password;
    @Basic
    @Column(name = "photo")
    private String photo;
    @Basic
    @Column(name = "date_last_login")
    private LocalDate dateLastLogin;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_address", referencedColumnName = "id_address", nullable = false)
    private AddressEntity address;
    @ManyToOne
    @JoinColumn(name = "id_role", referencedColumnName = "id_role", nullable = false)
    private RoleEntity role;
    @OneToOne
    @JoinColumn(name = "id_planning", referencedColumnName = "id_planning", nullable = false)
    private PlanningEntity planning;
    @OneToMany
    private List<ShareEntity> listShare;

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
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

    public byte[] getPassword() {
        return password;
    }

    public void setPassword(byte[] password) {
        this.password = password;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public LocalDate getDateLastLogin() {
        return dateLastLogin;
    }

    public void setDateLastLogin(LocalDate dateLastLogin) {
        this.dateLastLogin = dateLastLogin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (idUser != that.idUser) return false;
        if (pseudo != null ? !pseudo.equals(that.pseudo) : that.pseudo != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (password != null ? !photo.equals(that.photo) : that.photo != null) return false;
        if (dateLastLogin != null ? !dateLastLogin.equals(that.dateLastLogin) : that.dateLastLogin != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idUser.intValue();
        result = 31 * result + (pseudo != null ? pseudo.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (photo != null ? photo.hashCode() : 0);
        result = 31 * result + (dateLastLogin != null ? dateLastLogin.hashCode() : 0);
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

    public List<ShareEntity> getShare() {
        return listShare;
    }

    public void setShare(List<ShareEntity> listShare) {
        this.listShare = listShare;
    }

    public UsersEntity() {
    }

    public UsersEntity(String email) {
        this.email = email;
    }

    public UsersEntity(Long idUser, String pseudo, String email, byte[] password, String photo, LocalDate dateLastLogin, AddressEntity address, PlanningEntity planning) {
        this.idUser = idUser;
        this.pseudo = pseudo;
        this.email = email;
        this.password = password;
        this.photo = photo;
        this.dateLastLogin = dateLastLogin;
        this.address = address;
        this.planning = planning;
    }


    public UsersEntity(Long idUser, String pseudo, String email, byte[] password, String photo, AddressEntity address, PlanningEntity planning) {
        this.idUser = idUser;
        this.pseudo = pseudo;
        this.email = email;
        this.password = password;
        this.photo = photo;
        this.address = address;
        this.planning = planning;
    }

    public UsersEntity(String pseudo, String email, byte[] password, String photo,  AddressEntity address, PlanningEntity planning) {
        this.pseudo = pseudo;
        this.email = email;
        this.password = password;
        this.photo = photo;
        this.address = address;
        this.planning = planning;
    }

    public UsersEntity(String pseudo, String email, byte[] password) {
        this.pseudo = pseudo;
        this.email = email;
        this.password = password;
    }
}
