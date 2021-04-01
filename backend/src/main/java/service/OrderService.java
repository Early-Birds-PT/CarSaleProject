package service;

import data.model.entity.Customer;
import data.model.entity.Order;

import java.util.List;

public interface OrderService {

    Order readOrder(int orderNumber);
    Order createOrder(Order order);
    List<Order> findAllOrdersByCustomer(Customer customer);
    Order updateOrder(Order order);
    boolean deleteOrder(int orderNumber);
}
