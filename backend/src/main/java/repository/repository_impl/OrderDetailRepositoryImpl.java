package repository.repository_impl;

import data.EntityManagerProvider;
import data.model.embeddable.OrderProductPK;
import data.model.entity.Employee;
import data.model.entity.OrderDetail;
import repository.OrderDetailRepository;

import javax.persistence.EntityManager;

public class OrderDetailRepositoryImpl implements OrderDetailRepository {

    private EntityManager entityManager = EntityManagerProvider.getEntityManager();

    @Override
    public OrderDetail readOrderDetail(OrderProductPK id) {

        entityManager.getTransaction().begin();

        OrderDetail order = entityManager.find(OrderDetail.class,id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return order;
    }

    @Override
    public OrderDetail createOrderDetail(OrderDetail orderDetail) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();

        orderDetail = entityManager.merge(orderDetail);

        entityManager.getTransaction().commit();
        entityManager.close();

        return orderDetail;
    }

    @Override
    public OrderDetail updateOrderDetail(OrderDetail orderDetail) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();

        orderDetail = entityManager.merge(orderDetail);

        entityManager.getTransaction().commit();
        entityManager.close();

        return orderDetail;
    }

    @Override
    public boolean deleteOrderDetail(OrderProductPK id) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        boolean isDeleted;

        entityManager.getTransaction().begin();
        OrderDetail orderDetail = entityManager.find(OrderDetail.class, id);


        if(orderDetail == null){
            entityManager.getTransaction().rollback();
            entityManager.close();

            isDeleted = false;
            return isDeleted;
        }

        entityManager.remove(orderDetail);
        entityManager.getTransaction().commit();
        entityManager.close();

        isDeleted = true;
        return isDeleted;
    }
}
