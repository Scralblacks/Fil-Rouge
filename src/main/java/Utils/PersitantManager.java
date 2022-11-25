package Utils;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.sql.SQLException;

public final class PersitantManager {

    private static EntityManagerFactory FACTORY_INSTANCE;

    private PersitantManager(){

    }

    public static EntityManagerFactory getFactoryInstance(){
        if (FACTORY_INSTANCE == null || !FACTORY_INSTANCE.isOpen() ) {
            FACTORY_INSTANCE = Persistence.createEntityManagerFactory("myPU");
        }
        return FACTORY_INSTANCE;
    }
}

