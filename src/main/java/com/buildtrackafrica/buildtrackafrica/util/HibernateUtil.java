package com.buildtrackafrica.buildtrackafrica.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class HibernateUtil {
    private static final EntityManagerFactory EMF =
            Persistence.createEntityManagerFactory("buildtrackPU");

    public static EntityManager getEntityManager() {
        return EMF.createEntityManager();
    }
}