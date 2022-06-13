package fr.m2i.crm.helper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SessionHelper {
     private static EntityManager entityManager;

    public static EntityManager getEntityManager() {
        // Si l'instance n'hésite pas alors j'en crée une
       if(entityManager == null) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("crm2");
           // Je créer mon Entity Manager
            entityManager = emf.createEntityManager();
            //On ferme la factory
           // emf.close();
        }
        System.out.println("connectée");
        return entityManager;
    }

}
