package data.model.entity;


import data.model.embeddable.OrderProductPK;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity(name = "orderdetails")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail {

    @EmbeddedId
    private OrderProductPK id;

    private int quantityOrdered;
    private BigDecimal priceEach;
    private Short orderLineNumber;

}
