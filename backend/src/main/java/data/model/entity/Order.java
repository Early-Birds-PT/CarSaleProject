package data.model.entity;

import data.model.enums.OrderStatus;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Date;


//@NamedQuery(name = "Order.findAllOrdersByCustomer", query = "SELECT o FROM orders o  WHERE o.customerNumber = :customerNumber")
@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    private int orderNumber;
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
