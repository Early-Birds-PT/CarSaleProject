package service.impl;

import data.model.embeddable.OrderProductPK;
import data.model.entity.OrderDetail;
import repository.OrderDetailRepository;
import repository.repository_impl.OrderDetailRepositoryImpl;
import service.OrderDetailService;

public class OrderDetailServiceImpl implements OrderDetailService {

    private OrderDetailRepository orderDetailRepository = new OrderDetailRepositoryImpl();

    @Override
    public OrderDetail readOrderDetail(OrderProductPK id) {
        return orderDetailRepository.readOrderDetail(id);
    }

    @Override
    public OrderDetail createOrderDetail(OrderDetail orderDetail) {
        return orderDetailRepository.createOrderDetail(orderDetail);
    }

    @Override
    public OrderDetail updateOrderDetail(OrderDetail orderDetail) {
        return orderDetailRepository.updateOrderDetail(orderDetail);
    }

    @Override
    public boolean deleteOrderDetail(OrderProductPK id) {
        return orderDetailRepository.deleteOrderDetail(id);
    }
}
