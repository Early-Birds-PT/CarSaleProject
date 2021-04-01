package repository.repository_impl;

import data.EntityManagerProvider;
import data.model.entity.Customer;
import data.model.entity.Order;
import repository.CustomerRepository;
import repository.OrderRepository;
import service.OrderService;
import service.impl.OrderServiceImpl;

import javax.persistence.EntityManager;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {

    private OrderRepository orderRepository = new OrderRepositoryImpl();

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

        List<Order> orderList = orderRepository.findAllOrdersByCustomer(readCustomer(customerNumber));
        orderList.forEach(
                order -> order.setCustomer(null)
        );

        entityManager.remove(customer);
        entityManager.getTransaction().commit();
        entityManager.close();

        isDeleted = true;
        return isDeleted;
    }
}
