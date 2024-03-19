package com.project.configs;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerConfig {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-hibernate-mysql");

    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
}
