package data.model.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "offices")
public class Office {

    @Id
    private String officeCode;
    private String city;
    private String phone;
    private String addressLine1;
    private String addressLine2;
    private String state;
    private String postalCode;
    private String country;
    private String territory;


}