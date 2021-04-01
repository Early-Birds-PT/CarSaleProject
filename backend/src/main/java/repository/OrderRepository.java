package repository;

import data.model.entity.Customer;
import data.model.entity.Order;

import java.util.List;

public interface OrderRepository {

    Order readOrder(int orderNumber);
    List<Order> findAllOrdersByCustomer(Customer customer);
}
