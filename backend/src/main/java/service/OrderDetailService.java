package service;

import data.model.embeddable.OrderProductPK;
import data.model.entity.OrderDetail;

public interface OrderDetailService {

    OrderDetail readOrderDetail(OrderProductPK id);

    OrderDetail createOrderDetail(OrderDetail orderDetail);
    OrderDetail updateOrderDetail(OrderDetail orderDetail);
    boolean deleteOrderDetail(OrderProductPK id);
}
