package repository;

import data.model.entity.OrderDetail;
import data.model.entity.Product;
import data.model.entity.ProductLine;

import java.util.List;

public interface ProductRepository {
    Product createProduct(Product product);
    Product readProduct(String productCode);
    Product updateProduct(Product product);
    boolean deleteProduct(String productCode);
    List<Product> findAllProductsByProductLine(ProductLine productLine);
    List<Product> getAllProducts();
}
