package repository;

import data.model.embeddable.OrderProductPK;
import data.model.entity.Employee;
import data.model.entity.OrderDetail;

public interface OrderDetailRepository {

    OrderDetail readOrderDetail(OrderProductPK id);

    OrderDetail createOrderDetail(OrderDetail orderDetail);
    OrderDetail updateOrderDetail(OrderDetail orderDetail);
    boolean deleteOrderDetail(OrderProductPK id);
}
