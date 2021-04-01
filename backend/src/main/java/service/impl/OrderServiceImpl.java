package service.impl;

import data.model.entity.Customer;
import data.model.entity.Order;
import repository.OrderRepository;
import repository.repository_impl.OrderRepositoryImpl;
import service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository = new OrderRepositoryImpl();

    @Override
    public Order readOrder(int orderNumber) {
        return orderRepository.readOrder(orderNumber);
    }

    @Override
    public List<Order> findAllOrdersByCustomer(Customer customer) {
        return orderRepository.findAllOrdersByCustomer(customer);
    }
}
