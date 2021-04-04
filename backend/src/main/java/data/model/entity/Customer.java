package data.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    private Integer customerNumber;
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
    private BigDecimal creditLimit;

    @ManyToOne
    @JoinColumn(name = "salesRepEmployeeNumber", referencedColumnName = "employeeNumber")
    private Employee employee;

    @Override
    public String toString() {

        return String.format("| %-14s |  %-34s |  %-15s |  %-16s |  %-18s |  %-32s  |  %-24s  |  %-17s | " +
                        "%-13s | %-10s | %-12s | %11s | %-15s |", customerNumber, customerName, contactLastName,
                contactFirstName, phone, addressLine1, addressLine2, city, state, postalCode, country, creditLimit,
                (employee != null ) ? employee.getEmployeeNumber() : null);
    }
}