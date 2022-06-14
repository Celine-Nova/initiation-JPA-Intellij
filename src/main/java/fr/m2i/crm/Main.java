package fr.m2i.crm;

import fr.m2i.crm.dao.CustomerDAO;
import fr.m2i.crm.helper.SessionHelper;
import fr.m2i.crm.model.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        // On ouvre la Session entityManager
        EntityManager entityManager =  SessionHelper.getEntityManager();
        /* TODO*/
        CustomerDAO customerDAO = new CustomerDAO();
        customerDAO.create();
        //Customer customerData = new Customer();
        //customerData.setZipCode("75001");
        //customerDAO.update(1L, customerData);
        Customer customer = customerDAO.findById(1L);
        if (customer != null) {
            System.out.println("les données : " + customer.getAddress());
        }
        //On ferme la session
        entityManager.close();
    }
}