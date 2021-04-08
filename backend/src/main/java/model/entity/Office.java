package model.entity;

import lombok.*;
import javax.persistence.*;

@Data
@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name = "offices")
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

    public Office(String officeCode, String city, String phone, String addressLine1, String addressLine2, String state, String postalCode, String country, String territory) {
        this.officeCode = officeCode;
        this.city = city;
        this.phone = phone;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
        this.territory = territory;
    }
}