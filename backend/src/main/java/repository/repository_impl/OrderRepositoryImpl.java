package repository.repository_impl;

import data.EntityManagerProvider;
import data.model.entity.Order;
import repository.OrderRepository;

import javax.persistence.EntityManager;

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
}
