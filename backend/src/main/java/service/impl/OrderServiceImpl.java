package service.impl;

import data.model.embeddable.OrderProductPK;
import data.model.entity.Order;
import data.model.entity.OrderDetail;
import repository.OrderRepository;
import repository.repository_impl.OrderRepositoryImpl;
import service.OrderService;

public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository = new OrderRepositoryImpl();

    @Override
    public Order readOrder(int orderNumber) {
        return orderRepository.readOrder(orderNumber);
    }
}
