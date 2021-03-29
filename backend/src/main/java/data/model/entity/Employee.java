package data.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import data.model.embeddable.Person;

import javax.persistence.*;


@Entity(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeNumber;
    private String extension;
    private String officeCode;
    private int reportsTo;
    private String jobTitle;

    private String lastName;
    private String firstName;
    private String email;

    //@Embedded
    //private Person person;
}
