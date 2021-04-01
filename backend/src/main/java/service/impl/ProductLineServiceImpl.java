package service.impl;

import data.model.entity.ProductLine;
import repository.ProductLineRepository;
import repository.repository_impl.ProductLineRepositoryImpl;
import service.ProductLineService;

public class ProductLineServiceImpl implements ProductLineService {

    private ProductLineRepository productLineRepository = new ProductLineRepositoryImpl();

    @Override
    public ProductLine createProductLine(ProductLine productLine) {
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
        return productLineRepository.deleteProductLine(productLine);
    }
}
