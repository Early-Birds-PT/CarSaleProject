package service;

import data.model.embeddable.OrderDetailId;
import data.model.entity.Order;
import data.model.entity.OrderDetail;
import data.model.entity.Product;

import java.util.List;

public interface OrderDetailService {

    OrderDetail readOrderDetail(OrderDetailId id);
    OrderDetail createOrderDetail(OrderDetail orderDetail);
    OrderDetail updateOrderDetail(OrderDetail orderDetail);
    boolean deleteOrderDetail(OrderDetailId id);
    List<OrderDetail> findAllOrderDetailsByProduct(Product product);
    List<OrderDetail> findAllOrderDetailsByOrder(Order order);
}
