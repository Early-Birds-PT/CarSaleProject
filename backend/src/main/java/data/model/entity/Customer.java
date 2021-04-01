package data.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "customers")
public class Customer {

    @Id
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

    @ManyToOne
    @JoinColumn(name = "salesRepEmployeeNumber", insertable = false, updatable = false)
    private Employee employee;
}