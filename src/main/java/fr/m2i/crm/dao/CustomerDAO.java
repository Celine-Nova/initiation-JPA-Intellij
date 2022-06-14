package fr.m2i.crm.dao;

import fr.m2i.crm.helper.SessionHelper;
import fr.m2i.crm.model.Customer;
import fr.m2i.crm.state.CustomerState;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class CustomerDAO {
    public Customer findById(Long id){
        EntityManager entityManager = SessionHelper.getEntityManager();
        Customer customerFindId = entityManager.find(Customer.class, id);
        if (customerFindId == null){
            System.out.println("Le customer avec l'id:" + id + " n'existe pas");
        }
        return customerFindId;
    }
    public void create() {
        //J'ouvre la session entity manager
        EntityManager entityManager = SessionHelper.getEntityManager();

        Customer customerToCreate = new Customer();
        customerToCreate.setAddress("une adresse");
        customerToCreate.setCity("une ville");
        customerToCreate.setCompanyName("Une company");
        customerToCreate.setState(CustomerState.ACTIVE);

        try {
            // j'appelle la transaction
            EntityTransaction tx = entityManager.getTransaction();
            // je commence la transaction
            tx.begin();
            // je l'envoie
            entityManager.persist(customerToCreate);
            // j'enregistre la transaction
            tx.commit();
        } catch (Exception e) {
            System.out.println("Une erreur est survenu lors de la création");
        }
    }
    public void update(Long id, Customer customerData) {
        EntityManager entityManager = SessionHelper.getEntityManager();
        Customer customerToUpdate = entityManager.find(Customer.class, id);

        if (customerToUpdate == null) {
            System.out.println("Le customer avec l'id:" + id + " n'existe pas");
            return;
        }

        customerToUpdate.setNotNullData(customerData);

        try {
            EntityTransaction tx = entityManager.getTransaction();
            tx.begin();
            entityManager.merge(customerToUpdate);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Une erreur est survenu lors de la création");
        }
    }
}
