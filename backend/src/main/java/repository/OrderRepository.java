package repository;

import data.model.embeddable.OrderProductPK;
import data.model.entity.Order;
import data.model.entity.OrderDetail;

public interface OrderRepository {

    Order readOrder(int orderNumber);
    OrderDetail readOrderDetails(OrderProductPK id);
}
