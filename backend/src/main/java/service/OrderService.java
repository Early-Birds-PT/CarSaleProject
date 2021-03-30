package service;

import data.model.embeddable.OrderProductPK;
import data.model.entity.Order;
import data.model.entity.OrderDetail;

public interface OrderService {

    Order readOrder(int orderNumber);


}
