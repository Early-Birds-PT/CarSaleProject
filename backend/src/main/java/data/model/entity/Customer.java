package data.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerNumber;
    private String customerName;
    private String contactLastName;
    private String contactFirstName;
    private String phone;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private int salesRepEmployeeNumber;
    private BigDecimal creditLimit;

    //bi-directional many-to-one association to Employee
    @ManyToOne
    @JoinColumn(name="salesRepEmployeeNumber",  insertable = false, updatable = false)
    private Employee employee;

    /*//bi-directional many-to-one association to Order
    @OneToMany(mappedBy="customer",fetch = FetchType.EAGER)
    private List<Order> orders;*/

    //bi-directional many-to-one association to Payment
    /*@OneToMany(mappedBy="customer", fetch = FetchType.LAZY)
    private List<Payment> payments;*/

}