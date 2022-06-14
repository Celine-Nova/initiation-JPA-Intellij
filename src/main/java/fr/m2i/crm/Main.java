package fr.m2i.crm;

import fr.m2i.crm.helper.SessionHelper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        // On ouvre la Session entityManager
        EntityManager entityManager =  SessionHelper.getEntityManager();
        /* TODO*/

        //On ferme la session
        entityManager.close();
    }
}