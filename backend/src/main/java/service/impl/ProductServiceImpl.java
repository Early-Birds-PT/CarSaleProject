package service.impl;

import model.entity.Product;
import model.entity.ProductLine;
import repository.ProductRepository;
import service.ProductService;
import utils.RepositoryBeanFactory;
import java.util.List;
import java.util.Random;

public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository = RepositoryBeanFactory.getProductRepository();

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

    @Override
    public List<Product> findAllProductsByProductLine(ProductLine productLine) {
        return productRepository.findAllProductsByProductLine(productLine);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    private int generateUniqueID() {
        int number = 0;
        do{
            number = new Random().nextInt(100000000);
        } while(productRepository.readProduct(String.valueOf(number)) != null);
        return number;
    }
}
