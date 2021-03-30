package data.model.embeddable;

import data.model.entity.Order;
import data.model.entity.Product;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class OrderProductPK implements Serializable {

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
