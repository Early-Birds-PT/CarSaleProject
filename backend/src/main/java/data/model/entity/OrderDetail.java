package data.model.entity;

import data.model.embeddable.OrderDetailId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "orderdetails")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail {

    @EmbeddedId
    private OrderDetailId id;
    private int quantityOrdered;
    private BigDecimal priceEach;
    private Short orderLineNumber;
}
