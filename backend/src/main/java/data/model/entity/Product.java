package data.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 15)
    private String productCode;
    @Column(length = 70)
    private String productName;
    @ManyToOne
    @JoinColumn(name="productLine")
    private ProductLine productLine;
    @Column(length = 10)
    private String productScale;
    @Column(length = 50)
    private String productVendor;
    @Column(length = 65535, columnDefinition = "TEXT")
    @Type(type="text")
    private String productDescription;
    private Short quantityInStock;
    private BigDecimal buyPrice;
    private BigDecimal msrp;
}
