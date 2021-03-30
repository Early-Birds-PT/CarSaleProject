package service;

import data.model.entity.Product;

public interface ProductService {
    Product createProduct(Product product);
    Product readProduct(String productCode);

}
