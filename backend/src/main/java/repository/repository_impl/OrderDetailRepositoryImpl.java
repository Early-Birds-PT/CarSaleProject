package repository.repository_impl;

import data.EntityManagerProvider;
import data.model.embeddable.OrderProductPK;
import data.model.entity.OrderDetail;
import repository.OrderDetailRepository;

import javax.persistence.EntityManager;

public class OrderDetailRepositoryImpl implements OrderDetailRepository {

    private EntityManager entityManager = EntityManagerProvider.getEntityManager();


    @Override
    public OrderDetail readOrderDetails(OrderProductPK id) {

        entityManager.getTransaction().begin();

        OrderDetail order = entityManager.find(OrderDetail.class,id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return order;
    }
}
