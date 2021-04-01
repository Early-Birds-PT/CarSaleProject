package repository.repository_impl;

import data.EntityManagerProvider;
import data.model.entity.Customer;
import repository.CustomerRepository;

import javax.persistence.EntityManager;

public class CustomerRepositoryImpl implements CustomerRepository {

    @Override
    public Customer createCustomer(Customer customer) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();
        customer = entityManager.merge(customer);
        entityManager.getTransaction().commit();
        entityManager.close();
        return customer;
    }

    @Override
    public Customer readCustomer(int customerNumber) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();
        Customer customer = entityManager.find(Customer.class, customerNumber);
        entityManager.getTransaction().commit();
        entityManager.close();
        return customer;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();

        customer = entityManager.merge(customer);

        entityManager.getTransaction().commit();
        entityManager.close();

        return customer;
    }

    @Override
    public boolean deleteCustomer(int customerNumber) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        boolean isDeleted;

        entityManager.getTransaction().begin();
        Customer customer = entityManager.find(Customer.class, customerNumber);

        if(customer == null){
            entityManager.getTransaction().rollback();
            entityManager.close();

            isDeleted = false;
            return isDeleted;
        }
        entityManager.remove(customer);
        entityManager.getTransaction().commit();
        entityManager.close();

        isDeleted = true;
        return isDeleted;
    }
}
