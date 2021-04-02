package data.model.embeddable;

import data.model.entity.Order;
import data.model.entity.Product;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class OrderDetailId implements Serializable {

    @ManyToOne
    @JoinColumn(name="orderNumber", insertable = false, updatable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name="productCode", insertable = false, updatable = false)
    private Product product;

    @Override
    public String toString() {
        return "orderNumber=" + order.getOrderNumber() +
                ", productCode=" + product.getProductCode();
    }
}
