package service.impl;

import data.model.entity.ProductLine;
import repository.ProductLineRepository;
import repository.repository_impl.ProductLineRepositoryImpl;
import service.ProductLineService;

import java.util.Random;

public class ProductLineServiceImpl implements ProductLineService {
    private ProductLineRepository productLineRepository = new ProductLineRepositoryImpl();

    @Override
    public ProductLine createProductLine(ProductLine productLine) {
        productLine.setProductLine(String.valueOf(generateUniqueID()));
        return productLineRepository.createProductLine(productLine);
    }

    @Override
    public ProductLine readProductLine(String productLine) {
        return productLineRepository.readProductLine(productLine);
    }

    @Override
    public ProductLine updateProductLine(ProductLine productLine) {
        return productLineRepository.updateProductLine(productLine);
    }

    @Override
    public boolean deleteProductLine(String productLine) {
        return deleteProductLine(productLine);
    }
    private int generateUniqueID() {
        int number = 0;
        do{
            number = new Random().nextInt(100000000);
        } while(productLineRepository.readProductLine(String.valueOf(number)) != null);
        return number;
    }
}
