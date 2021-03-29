package repository;

import data.model.entity.Order;

public interface OrderRepository {

    Order readOrder(int orderNumber);
}
