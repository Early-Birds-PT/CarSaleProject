package repository;

import data.model.embeddable.OrderProductPK;
import data.model.entity.OrderDetail;

public interface OrderDetailRepository {

    OrderDetail readOrderDetails(OrderProductPK id);
}
