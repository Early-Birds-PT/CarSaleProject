package model.embeddable;

import model.entity.Customer;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class PaymentId implements Serializable {

    private String checkNumber;

    @ManyToOne
    @JoinColumn(name= "customerNumber", insertable = false,updatable = false)
    private Customer customer;
}
