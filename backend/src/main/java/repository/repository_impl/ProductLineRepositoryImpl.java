package repository.repository_impl;

import data.EntityManagerProvider;
import data.model.entity.Product;
import data.model.entity.ProductLine;
import repository.ProductLineRepository;

import javax.persistence.EntityManager;

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
}
