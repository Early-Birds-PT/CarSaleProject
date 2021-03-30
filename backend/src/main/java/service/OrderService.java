package service;

import data.model.entity.Order;

public interface OrderService {

    Order readOrder(int orderNumber);
}
