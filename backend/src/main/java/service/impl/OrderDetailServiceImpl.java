package service.impl;

import data.model.embeddable.OrderProductPK;
import data.model.entity.OrderDetail;
import repository.OrderDetailRepository;
import repository.repository_impl.OrderDetailRepositoryImpl;
import service.OrderDetailService;

public class OrderDetailServiceImpl implements OrderDetailService {

    private OrderDetailRepository orderDetailRepository = new OrderDetailRepositoryImpl();

    @Override
    public OrderDetail readOrderDetails(OrderProductPK id) {
        return orderDetailRepository.readOrderDetails(id);
    }
}
