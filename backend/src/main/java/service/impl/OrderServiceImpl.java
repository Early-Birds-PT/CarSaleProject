package service.impl;

import data.model.entity.Customer;
import data.model.entity.Order;
import repository.OrderRepository;
import repository.repository_impl.OrderRepositoryImpl;
import service.OrderService;

import java.util.List;
import java.util.Random;

public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository = new OrderRepositoryImpl();

    @Override
    public Order readOrder(int orderNumber) {
        return orderRepository.readOrder(orderNumber);
    }

    @Override
    public Order createOrder(Order order) {
        order.setOrderNumber(generateUniqueID());
        return orderRepository.createOrder(order);
    }

    @Override
    public List<Order> findAllOrdersByCustomer(Customer customer) {
        return orderRepository.findAllOrdersByCustomer(customer);
    }

    @Override
    public Order updateOrder(Order order) {
        return orderRepository.updateOrder(order);
    }

    @Override
    public boolean deleteOrder(int orderNumber) {
        return orderRepository.deleteOrder(orderNumber);
    }

    private int generateUniqueID() {
        int number = 0;
        do{
            number = new Random().nextInt(100000000);
        } while(orderRepository.readOrder(number) != null);
        return number;
    }


}
