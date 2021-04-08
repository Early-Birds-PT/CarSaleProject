package repository;

import model.embeddable.OrderDetailId;
import model.entity.Order;
import model.entity.OrderDetail;
import model.entity.Product;
import java.util.List;

public interface OrderDetailRepository {

    OrderDetail readOrderDetail(OrderDetailId id);
    OrderDetail createOrderDetail(OrderDetail orderDetail);
    OrderDetail updateOrderDetail(OrderDetail orderDetail);
    boolean deleteOrderDetail(OrderDetailId id);
    List<OrderDetail> findAllOrderDetailsByProduct(Product product);
    List<OrderDetail> findAllOrderDetailsByOrder(Order order);
}
