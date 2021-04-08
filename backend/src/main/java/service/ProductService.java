package service;

import model.entity.Product;
import model.entity.ProductLine;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product);
    Product readProduct(String productCode);
    Product updateProduct(Product pruduct);
    boolean deleteProduct(String productCode);
    List<Product> findAllProductsByProductLine(ProductLine productLine);
    List<Product> getAllProducts();
}
