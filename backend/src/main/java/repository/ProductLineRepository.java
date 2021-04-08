package repository;

import model.entity.ProductLine;

public interface ProductLineRepository {

    ProductLine createProductLine(ProductLine productLine);
    ProductLine readProductLine(String productLine);
    ProductLine updateProductLine(ProductLine pruductLine);
    boolean deleteProductLine(String productLine);
}

