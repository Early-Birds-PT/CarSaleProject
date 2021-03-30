package service.impl;

import data.model.embeddable.OrderProductPK;
import data.model.entity.OrderDetail;
import repository.OrderRepository;
import repository.repository_impl.OrderRepositoryImpl;
import service.OrderDetailService;

public class OrderDetailServiceImpl implements OrderDetailService {

    private OrderRepository orderRepository = new OrderRepositoryImpl();


    @Override
    public OrderDetail readOrderDetails(OrderProductPK id) {
        return orderRepository.readOrderDetails(id);
    }
}
