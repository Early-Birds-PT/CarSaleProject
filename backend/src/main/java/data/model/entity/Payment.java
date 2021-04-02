package data.model.entity;

import data.model.embeddable.PaymentId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "payments")
public class Payment {

    @EmbeddedId
    private PaymentId paymentId;

    @ManyToOne
    @JoinColumn(name = "customerNumber", insertable = false, updatable = false)
    private Customer customer;
    private Date paymentDate;
    private BigDecimal amount;

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId.getCustomer().getCustomerName() + "_" + paymentId.getCheckNumber()  +
                ", customer=" + customer.getCustomerName() +
                ", paymentDate=" + paymentDate +
                ", amount=" + amount +
                '}';
    }
}
