package data.model.entity;

import data.model.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Date;


//@NamedQuery(name = "Order.findAllOrdersByCustomer", query = "SELECT o FROM orders o  WHERE o.customerNumber = :customerNumber")
@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    private int orderNumber;
    private Date orderDate;
    private Date requiredDate;
    private Date shippedDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Column(length = 65535, columnDefinition="TEXT")
    @Type(type="text")
    private String comments;

    @ManyToOne
    @JoinColumn(name = "customerNumber",nullable = true)
    private Customer customer;
}
