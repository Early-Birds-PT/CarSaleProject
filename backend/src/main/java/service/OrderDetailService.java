package service;

import data.model.embeddable.OrderProductPK;
import data.model.entity.OrderDetail;

public interface OrderDetailService {

    OrderDetail readOrderDetails(OrderProductPK id);

}
