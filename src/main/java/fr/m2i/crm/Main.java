package fr.m2i.crm;

import fr.m2i.crm.helper.SessionHelper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

       /* EntityManagerFactory emf = Persistence.createEntityManagerFactory("crm2");
        EntityManager entityManager = emf.createEntityManager();*/

        SessionHelper.getEntityManager();
    }
}