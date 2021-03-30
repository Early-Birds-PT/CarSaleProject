package service.impl;

import data.model.entity.Product;
import repository.ProductRepository;
import repository.repository_impl.ProductRepositoryImpl;
import service.ProductService;

public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository = new ProductRepositoryImpl();

        @Override
        public Product createProduct(Product product) {
            return productRepository.createProduct(product);
        }

        @Override
        public Product readProduct(String productCode) {
            return productRepository.readProduct(productCode);
        }

}
