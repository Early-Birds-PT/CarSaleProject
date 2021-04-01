package data.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import data.model.embeddable.Person;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

@NamedNativeQuery(name="Employee.setOfficeCodeToNull",
        query="UPDATE employees e SET e.officeCode = null " +
        "WHERE e.officeCode = :officeCode")

@Entity(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeNumber;
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
}

