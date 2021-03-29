package data.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import data.model.embeddable.Person;

import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int employeeNumber;
    private String extension;
    private String officeCode;
    private int reportsTo;
    private String jobTitle;

    @Embedded
    private Person person;
}
