package Domain;

import DAO.CrudDAO;
import DAO.DaoFactory;
import Entity.*;
import Utils.PersitantManager;
import jakarta.persistence.EntityManagerFactory;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.time.LocalDate;
import java.util.Optional;

public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {

        EntityManagerFactory emf = PersitantManager.getFactoryInstance();

        CrudDAO<UsersEntity> userDao = DaoFactory.getUsersDao();
        CrudDAO<PlanningEntity> planningDao = DaoFactory.getPlanningDao();
        CrudDAO<TaskEntity> taskDao = DaoFactory.getTaskDao();
        CrudDAO<RoleEntity> roleDao = DaoFactory.getRoleDao();
        CrudDAO<AddressEntity> addressDao = DaoFactory.getAddressDao();
        CrudDAO<ActionEntity> actionDao = DaoFactory.getActionDao();

        ActionEntity createAction = actionDao.create(new ActionEntity("CREATE"));
        ActionEntity updateAction = actionDao.create(new ActionEntity("UPDATE"));
        ActionEntity deleteAction = actionDao.create(new ActionEntity("DELETE"));

        RoleEntity basicRole = roleDao.create(new RoleEntity("BASIC"));
        RoleEntity adminRole = roleDao.create(new RoleEntity("ADMIN"));
        RoleEntity superAdminRole = roleDao.create(new RoleEntity("SUPERADMIN"));


        AddressEntity userAddress = new AddressEntity("Paris","75000");
        UsersEntity user = new UsersEntity("fabrice@fabrice.fr");

        Optional<UsersEntity> verifyUser = userDao.checkIfExists(user);

        if(!verifyUser.isPresent()) {

            PlanningEntity planning = planningDao.create(new PlanningEntity("Fabrice's planning", LocalDate.now()));
            RoleEntity role = roleDao.findById(1L).get();
            Optional<AddressEntity> address = addressDao.checkIfExists(userAddress);

            if (!address.isPresent()) {
                userAddress = addressDao.create(userAddress);
            } else {
                userAddress = address.get();
            }

            SecureRandom random = new SecureRandom();
            byte[] salt = new byte[16];
            random.nextBytes(salt);
            KeySpec spec = new PBEKeySpec("azerty".toCharArray(), salt, 65536, 128);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] hash = factory.generateSecret(spec).getEncoded();

            UsersEntity tempUser = new UsersEntity("Fabrice",
                    "fabrice@fabrice.fr",
                    hash,
                    null,
                    userAddress,
                    planning);
            tempUser.setRole(basicRole);

            UsersEntity newUser = userDao.create(tempUser);
            System.out.println("User created successfully !");

            System.out.println("GETTING THE USER : ");
            Optional<UsersEntity> gettingThisOne = userDao.findById(newUser.getIdUser());
            System.out.println(gettingThisOne);

        } else {
            System.out.println("User already exists !");
        }
    }
}
