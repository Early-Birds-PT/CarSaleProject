package repository.repository_impl;

import data.EntityManagerProvider;
import data.model.entity.Product;
import data.model.entity.ProductLine;
import repository.ProductLineRepository;
import repository.ProductRepository;
import utils.RepositoryBeanFactory;

import javax.persistence.EntityManager;
import java.util.List;

public class ProductLineRepositoryImpl implements ProductLineRepository {

    private ProductRepository productRepository = RepositoryBeanFactory.getProductRepository();

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
        List<Product> products = productRepository.findAllProductsByProductLine(productLine1);
        // all related products should be deleted before deleting productLine
        products.forEach(product -> productRepository.deleteProduct(product.getProductCode()));
        entityManager.remove(productLine1);
        entityManager.getTransaction().commit();
        entityManager.close();

        isDeleted = true;
        return isDeleted;
    }
}
