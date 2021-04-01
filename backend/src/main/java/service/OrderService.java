package service;

import data.model.entity.Customer;
import data.model.entity.Order;

import java.util.List;

public interface OrderService {

    Order readOrder(int orderNumber);
    List<Order> findAllOrdersByCustomer(Customer customer);
}
