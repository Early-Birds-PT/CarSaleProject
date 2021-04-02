package repository.repository_impl;

import data.EntityManagerProvider;
import data.model.entity.Customer;
import data.model.entity.Order;
import data.model.entity.OrderDetail;
import repository.CustomerRepository;
import repository.OrderRepository;
import utils.RepositoryBeanFactory;

import javax.persistence.EntityManager;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {

    private OrderRepository orderRepository = RepositoryBeanFactory.getOrderRepository();

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


        List<Order> orders = orderRepository.findAllOrdersByCustomer(customer);
        // all related orders should be deleted before deleting customer
        orders.forEach(order -> orderRepository.deleteOrder(order.getOrderNumber()));



        entityManager.remove(customer);
        entityManager.getTransaction().commit();
        entityManager.close();

        isDeleted = true;
        return isDeleted;
    }
}
