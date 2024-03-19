package com.project;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-hibernate-mysql");
        EntityManager em = emf.createEntityManager();

        System.out.println(em.isOpen());

        em.close();
        emf.close();
    }
}