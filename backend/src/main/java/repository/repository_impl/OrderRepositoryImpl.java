package repository.repository_impl;

import com.mysql.cj.Session;
import data.EntityManagerProvider;
import data.model.entity.Customer;
import data.model.entity.Order;
import repository.OrderRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class OrderRepositoryImpl implements OrderRepository {

    private EntityManager entityManager = EntityManagerProvider.getEntityManager();

    @Override
    public Order readOrder(int orderNumber) {
        entityManager.getTransaction().begin();

        Order order = entityManager.find(Order.class,orderNumber);
        entityManager.getTransaction().commit();
        entityManager.close();

        return order;
    }

    @Override
    public List<Order> findAllOrdersByCustomer(Customer customer) {


        String query = "SELECT o FROM Order o WHERE o.customer = :customer";
        EntityManager em = EntityManagerProvider.getEntityManager();

        em.getTransaction().begin();
        TypedQuery<Order> typedQuery = em.createQuery(query, Order.class);
        typedQuery.setParameter("customer", customer);
        List<Order> orderList = typedQuery.getResultList();
        em.getTransaction().commit();

        em.close();
        return orderList;



    }
}
