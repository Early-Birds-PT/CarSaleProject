package repository.repository_impl;

import data.EntityManagerProvider;
import data.model.entity.Customer;
import data.model.entity.Order;
import data.model.entity.OrderDetail;
import repository.OrderDetailRepository;
import repository.OrderRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class OrderRepositoryImpl implements OrderRepository {

    private EntityManager entityManager = EntityManagerProvider.getEntityManager();
    private OrderDetailRepository orderDetailRepository = new OrderDetailRepositoryImpl();

    @Override
    public Order readOrder(int orderNumber) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();

        entityManager.getTransaction().begin();

        Order order = entityManager.find(Order.class,orderNumber);
        entityManager.getTransaction().commit();
        entityManager.close();

        return order;
    }

    @Override
    public Order createOrder(Order order) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();

        order = entityManager.merge(order);

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
        //orderList.forEach(order -> order.setCustomer(null));
        em.getTransaction().commit();

        em.close();
        return orderList;
    }

    @Override
    public Order updateOrder(Order order1) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();

        order1 = entityManager.merge(order1);

        entityManager.getTransaction().commit();
        entityManager.close();

        return order1;
    }

    @Override
    public boolean deleteOrder(int orderNumber) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        boolean isDeleted;

        entityManager.getTransaction().begin();
        Order order = entityManager.find(Order.class, orderNumber);

        if (order == null) {
            entityManager.getTransaction().rollback();
            entityManager.close();

            isDeleted = false;
            return isDeleted;
        }

        List<OrderDetail> orderDetails = orderDetailRepository.findAllOrderDetailsByOrder(order);
        // all related orderDetails should be deleted before deleting order
        orderDetails.forEach(orderDetail -> orderDetailRepository.deleteOrderDetail(orderDetail.getId()));

        entityManager.remove(order);
        entityManager.getTransaction().commit();
        entityManager.close();

        isDeleted = true;
        return isDeleted;
    }


}
