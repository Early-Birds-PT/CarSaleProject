package repository;

import data.model.embeddable.OrderProductPK;
import data.model.entity.Employee;
import data.model.entity.Order;
import data.model.entity.OrderDetail;
import data.model.entity.Product;

import java.util.List;

public interface OrderDetailRepository {

    OrderDetail readOrderDetail(OrderProductPK id);

    OrderDetail createOrderDetail(OrderDetail orderDetail);
    OrderDetail updateOrderDetail(OrderDetail orderDetail);
    boolean deleteOrderDetail(OrderProductPK id);
    List<OrderDetail> findAllOrderDetailsByProduct(Product product);
    List<OrderDetail> findAllOrderDetailsByOrder(Order order);
}
