package service.impl;

import data.model.embeddable.OrderProductPK;
import data.model.entity.Order;
import data.model.entity.OrderDetail;
import data.model.entity.Product;
import repository.OrderDetailRepository;
import repository.repository_impl.OrderDetailRepositoryImpl;
import service.OrderDetailService;

import java.util.List;

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

    @Override
    public List<OrderDetail> findAllOrderDetailsByProduct(Product product) {
        return orderDetailRepository.findAllOrderDetailsByProduct(product);
    }

    @Override
    public List<OrderDetail> findAllOrderDetailsByOrder(Order order) {
        return orderDetailRepository.findAllOrderDetailsByOrder(order);
    }
}
