package repository.repository_impl;

import data.EntityManagerProvider;
import data.model.entity.Product;
import data.model.entity.ProductLine;
import jdk.dynalink.linker.LinkerServices;
import org.hibernate.Transaction;
import repository.ProductRepository;
import service.OrderDetailService;
import service.impl.OrderDetailServiceImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Transient;

public class ProductRepositoryImpl implements ProductRepository {

    private OrderDetailService orderDetailService = new OrderDetailServiceImpl();

    @Override
    public Product createProduct(Product product) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();
        product = entityManager.merge(product);
        entityManager.getTransaction().commit();
        entityManager.close();
        return product;
    }

    @Override
    public Product readProduct(String productCode) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Product product = entityManager.find(Product.class, productCode);
        transaction.commit();
        entityManager.close();
        return product;
    }

    @Override
    public Product updateProduct(Product product) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();

        product = entityManager.merge(product);

        entityManager.getTransaction().commit();
        entityManager.close();

        return product;
    }

    @Override
    public boolean deleteProduct(String productCode) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        boolean isDeleted;

        entityManager.getTransaction().begin();
        Product product = entityManager.find(Product.class, productCode);


        if(product== null){
            entityManager.getTransaction().rollback();
            entityManager.close();

            isDeleted = false;
            return isDeleted;
        }

       orderDetailService.findAllOrderDetailsByProduct(product).forEach(orderDetail ->orderDetailService.deleteOrderDetail(orderDetail.getId()));

        entityManager.remove(product);
        entityManager.getTransaction().commit();
        entityManager.close();

        isDeleted = true;
        return isDeleted;
    }
}
