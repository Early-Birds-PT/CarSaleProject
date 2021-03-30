package repository.repository_impl;

import data.EntityManagerProvider;
import data.model.embeddable.OrderProductPK;
import data.model.entity.Order;
import data.model.entity.OrderDetail;
import repository.OrderRepository;

import javax.persistence.EntityManager;

public class OrderRepositoryImpl implements OrderRepository {

    private EntityManager entityManager = EntityManagerProvider.getEntityManager();

    @Override
    public Order readOrder(int orderNumber) {
        entityManager.getTransaction().begin();

        Order order = entityManager.find(Order.class,orderNumber);
        entityManager.getTransaction().commit();
        //entityManager.close();

        return order;
    }

    @Override
    public OrderDetail readOrderDetails(OrderProductPK id) {

        entityManager.getTransaction().begin();

        OrderDetail order = entityManager.find(OrderDetail.class,id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return order;
    }
}
