package fr.m2i.crm.dao;

import fr.m2i.crm.helper.SessionHelper;
import fr.m2i.crm.model.Customer;
import fr.m2i.crm.state.CustomerState;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class CustomerDAO {
    public List<Customer> findAll(){
        EntityManager entityManager = SessionHelper.getEntityManager();
        // Je créée la requêt JPQL
        Query query = entityManager.createQuery("SELECT c FROM Customer c");
        List<Customer> results = query.getResultList();
        if (results == null){
            System.out.println("Le résultat est vide");
        }
        return results;
    }
    public Customer findById(Long id){
        EntityManager entityManager = SessionHelper.getEntityManager();
        Customer customerFindId = entityManager.find(Customer.class, id);
        if (customerFindId == null){
            System.out.println("Le customer avec l'id:" + id + " n'existe pas");
        }
        return customerFindId;
    }
    //VERSION JPSQL
    /*    public Customer findById(Long id) {
        EntityManager entityManager = SessionHelper.getEntityManager();
//        Customer customerFounded = entityManager.find(Customer.class, id);

        Query queryToFindCustomerById = entityManager.createQuery("select c from Customer c where c.id = ?1");
        queryToFindCustomerById.setParameter(1, id);

        Customer customerFounded = (Customer) queryToFindCustomerById.getSingleResult();

        if (customerFounded == null) {
            System.out.println("Attention le customer avec l'id: " + id + " n'existe pas !");
        }

        return customerFounded;
    }*/
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
    // Différente manière pour l'update :
// public void update(Long id, String address, String city, String companyName, ........) {
// => utiliser l'id en paramètre pour récupérer le customer que l'on souhaite modifier
// puis set les données :
// ...
// customerToUpdate.setAddress(address);
// customerToUpdate.setCity(address);
// customerToUpdate.setCompanyName(address);
// ...

// Différente manière pour l'update :
// public void update(Long id, Customer customerData) {
// => utiliser l'id en paramètre pour récupérer le customer que l'on souhaite modifier
// puis set les données :
// ...
// customerToUpdate.setNotNullData(customerData); -> on set les données uniquement si elle ne sont pas null
// ...

    // Différente manière pour l'update :
// public void update(Customer customerData) {
// => utiliser customer.getId(); pour récupérer le customer que l'on souhaite modifier
// puis set les données :
// ...
// customerToUpdate.setNotNullData(customerData); -> on set les données uniquement si elle ne sont pas null
// ...
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
