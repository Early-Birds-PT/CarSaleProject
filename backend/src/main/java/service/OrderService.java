package service;

import model.entity.Customer;
import model.entity.Order;

import java.util.List;

public interface OrderService {

    Order readOrder(int orderNumber);
    Order createOrder(Order order);
    List<Order> findAllOrdersByCustomer(Customer customer);
    Order updateOrder(Order order);
    boolean deleteOrder(int orderNumber);
}
