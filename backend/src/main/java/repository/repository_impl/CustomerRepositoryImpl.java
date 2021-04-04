package repository.repository_impl;

import data.EntityManagerProvider;
import data.model.entity.Customer;
import data.model.entity.Employee;
import data.model.entity.Order;
import data.model.entity.Payment;
import repository.CustomerRepository;
import repository.OrderRepository;
import repository.PaymentRepository;
import utils.RepositoryBeanFactory;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {

    private OrderRepository orderRepository = RepositoryBeanFactory.getOrderRepository();
    private PaymentRepository paymentRepository = RepositoryBeanFactory.getPaymentRepository();

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

        List<Payment> payments = paymentRepository.findAllPaymentsByCustomer(customer);
        // all related payments should be deleted before deleting customer
        payments.forEach(payment -> paymentRepository.deletePayment(payment.getPaymentId()));

        entityManager.remove(customer);
        entityManager.getTransaction().commit();
        entityManager.close();

        isDeleted = true;
        return isDeleted;
    }

    @Override
    public List<Customer> getAllCustomers() {

        String query = "SELECT c FROM Customer c";
        EntityManager em = EntityManagerProvider.getEntityManager();

        em.getTransaction().begin();
        TypedQuery<Customer> typedQuery = em.createQuery(query, Customer.class);
        List<Customer> customers = typedQuery.getResultList();

        em.getTransaction().commit();
        em.close();
        return customers;
    }

    @Override
    public List<Customer> findAllCustomersByEmployee(Employee employee) {
        String query = "SELECT c FROM Customer c WHERE c.employee = :employee";
        EntityManager em = EntityManagerProvider.getEntityManager();

        em.getTransaction().begin();
        TypedQuery<Customer> typedQuery = em.createQuery(query, Customer.class);
        typedQuery.setParameter("employee", employee);
        List<Customer> customers = typedQuery.getResultList();

        em.getTransaction().commit();

        em.close();
        return customers;
    }


}
