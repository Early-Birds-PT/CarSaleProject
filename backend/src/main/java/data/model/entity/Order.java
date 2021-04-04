package data.model.entity;

import lombok.*;
import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "orders")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    private Integer orderNumber;
    private Date orderDate;
    private Date requiredDate;
    private Date shippedDate;

   // @Enumerated(EnumType.STRING)
    //private OrderStatus status;
    private String status;

    @Column(length = 65535, columnDefinition="TEXT")
    @Type(type="text")
    private String comments;

    @ManyToOne
    @JoinColumn(name = "customerNumber")
    private Customer customer;
}
