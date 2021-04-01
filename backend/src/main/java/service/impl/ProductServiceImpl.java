package service.impl;

import data.model.entity.Product;
import repository.ProductRepository;
import repository.repository_impl.ProductRepositoryImpl;
import service.ProductService;

import java.util.Random;

public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository = new ProductRepositoryImpl();

        @Override
        public Product createProduct(Product product) {
            product.setProductCode(String.valueOf(generateUniqueID()));
            return productRepository.createProduct(product);
        }

        @Override
        public Product readProduct(String productCode) {
            return productRepository.readProduct(productCode);
        }

    @Override
    public Product updateProduct(Product product) {
       return  productRepository.updateProduct(product);
    }

    @Override
    public boolean deleteProduct(String productCode) {
        return productRepository.deleteProduct(productCode);
    }
    private int generateUniqueID() {
        int number = 0;
        do{
            number = new Random().nextInt(100000000);
        } while(productRepository.readProduct(String.valueOf(number)) != null);
        return number;
    }

}
