package repository;

import data.model.entity.ProductLine;

public interface ProductLineRepository {
    ProductLine createProductLine(ProductLine productLine);
    ProductLine readProductLine(String productLine);
}

