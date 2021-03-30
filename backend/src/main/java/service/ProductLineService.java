package service;

import data.model.entity.ProductLine;

public interface ProductLineService {

    ProductLine createProductLine(ProductLine productLine);
    ProductLine readProductLine(String productLine);
}
