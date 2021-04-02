package data.model.embeddable;

import data.model.entity.Customer;
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
public class PaymentId implements Serializable {

    private String checkNumber;

    @ManyToOne
    @JoinColumn(name= "customerNumber", insertable = false,updatable = false)
    private Customer customer;
}
