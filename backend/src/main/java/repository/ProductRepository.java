package repository;

import data.model.entity.Product;
import data.model.entity.ProductLine;

public interface ProductRepository {
    Product createProduct(Product product);
    Product readProduct(String productCode);
    Product updateProduct(Product pruduct);
    boolean deleteProduct(String productCode);
}
