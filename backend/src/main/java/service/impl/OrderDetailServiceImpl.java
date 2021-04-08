package service.impl;

import model.embeddable.OrderDetailId;
import model.entity.Order;
import model.entity.OrderDetail;
import model.entity.Product;
import repository.OrderDetailRepository;
import service.OrderDetailService;
import utils.RepositoryBeanFactory;
import java.util.List;

public class OrderDetailServiceImpl implements OrderDetailService {

    private OrderDetailRepository orderDetailRepository = RepositoryBeanFactory.getOrderDetailRepository();

    @Override
    public OrderDetail readOrderDetail(OrderDetailId id) {
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
    public boolean deleteOrderDetail(OrderDetailId id) {
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
