package data.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    private Integer employeeNumber;
    private String lastName;
    private String firstName;
    private String extension;
    private String email;
    private String jobTitle;

    @ManyToOne
    @JoinColumn(name = "reportsTo" )
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "officeCode")
    private Office office;

   /* @Override
    public String toString() {

        return String.format("| %-14s |  %-34s |  %-15s |  %-16s |  %-18s |  %-32s  |  %-24s  |  %-17s | " +
                        "%-13s | %-10s | %-12s | %11s | %-15s |", employeeNumber, lastName, firstName,
                extension, email, jobTitle, (employee != null ) ? employee.getEmployeeNumber() : null), (employee != null ) ? employee.getEmployeeNumber() : null)office.getOfficeCode(), state, postalCode, country, creditLimit,
                (employee != null ) ? employee.getEmployeeNumber() : null);
    }

    */
}

