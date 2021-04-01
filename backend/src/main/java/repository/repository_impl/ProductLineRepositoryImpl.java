package repository.repository_impl;

import data.EntityManagerProvider;
import data.model.entity.*;
import repository.ProductLineRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class ProductLineRepositoryImpl implements ProductLineRepository {
    @Override
    public ProductLine createProductLine(ProductLine productLine) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();
        productLine = entityManager.merge(productLine);
        entityManager.getTransaction().commit();
        entityManager.close();
        return productLine;
    }

    @Override
    public ProductLine readProductLine(String productLine) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();
        ProductLine productLine1 = entityManager.find(ProductLine.class, productLine);
        entityManager.getTransaction().commit();
        entityManager.close();
        return productLine1;
    }

    @Override
    public ProductLine updateProductLine(ProductLine pruductLine) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();

        pruductLine = entityManager.merge(pruductLine);

        entityManager.getTransaction().commit();
        entityManager.close();

        return pruductLine;
    }

    @Override
    public boolean deleteProductLine(String productLine) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        boolean isDeleted;

        entityManager.getTransaction().begin();
        ProductLine productLine1 = entityManager.find(ProductLine.class, productLine);


        if(productLine == null){
            entityManager.getTransaction().rollback();
            entityManager.close();

            isDeleted = false;
            return isDeleted;
        }

        entityManager.remove(productLine);
        entityManager.getTransaction().commit();
        entityManager.close();

        isDeleted = true;
        return isDeleted;
    }
}
