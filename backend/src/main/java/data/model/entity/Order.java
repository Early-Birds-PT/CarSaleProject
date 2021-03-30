package data.model.entity;

import data.model.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @JoinColumn(name = "customerNumber")
    private Customer customer;
}
