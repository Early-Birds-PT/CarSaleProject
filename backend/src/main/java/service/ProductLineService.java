package service;

import data.model.entity.ProductLine;

public interface ProductLineService {

    ProductLine createProductLine(ProductLine productLine);
    ProductLine readProductLine(String productLine);
    ProductLine updateProductLine(ProductLine pruductLine);
    boolean deleteProductLine(String productLine);

}
