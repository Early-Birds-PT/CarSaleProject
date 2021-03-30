package repository;

import data.model.entity.Product;

public interface ProductRepository {
    Product createProduct(Product product);
    Product readProduct(String productCode);
}
