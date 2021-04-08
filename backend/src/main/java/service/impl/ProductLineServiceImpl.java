package service.impl;

import model.entity.ProductLine;
import repository.ProductLineRepository;
import service.ProductLineService;
import utils.RepositoryBeanFactory;

public class ProductLineServiceImpl implements ProductLineService {

    private ProductLineRepository productLineRepository = RepositoryBeanFactory.getProductLineRepository();

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
