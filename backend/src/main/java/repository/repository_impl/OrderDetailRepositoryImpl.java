package repository.repository_impl;

import data.EntityManagerProvider;
import data.model.embeddable.OrderDetailId;
import data.model.entity.Order;
import data.model.entity.OrderDetail;
import data.model.entity.Product;
import repository.OrderDetailRepository;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class OrderDetailRepositoryImpl implements OrderDetailRepository {

    @Override
    public OrderDetail readOrderDetail(OrderDetailId id) {

        EntityManager entityManager = EntityManagerProvider.getEntityManager();
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
    public boolean deleteOrderDetail(OrderDetailId id) {

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

    public List<OrderDetail> findAllOrderDetailsByProduct(Product product) {

        String query = "SELECT o FROM OrderDetail o WHERE o.id.product = :product";
        EntityManager em = EntityManagerProvider.getEntityManager();

        em.getTransaction().begin();
        TypedQuery<OrderDetail> typedQuery = em.createQuery(query, OrderDetail.class);
        typedQuery.setParameter("product", product);
        List<OrderDetail> orderDetailListList = typedQuery.getResultList();
        em.getTransaction().commit();

        em.close();
        return orderDetailListList;
    }

    @Override
    public List<OrderDetail> findAllOrderDetailsByOrder(Order order) {

        String query = "SELECT o FROM OrderDetail o WHERE o.id.order = :order";
        EntityManager em = EntityManagerProvider.getEntityManager();

        em.getTransaction().begin();
        TypedQuery<OrderDetail> typedQuery = em.createQuery(query, OrderDetail.class);
        typedQuery.setParameter("order", order);
        List<OrderDetail> orderDetailListList = typedQuery.getResultList();
        em.getTransaction().commit();

        em.close();
        return orderDetailListList;
    }
}
