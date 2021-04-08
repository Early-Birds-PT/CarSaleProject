package model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
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

    @Override
    public String toString() {

        return String.format("| %-14s |  %-45s |  %-18s |  %-13s |  %-30s |  %-20s  |  %-15s  |  %-10s |  %-10s |", productCode, productName, productLine.getProductLine(),
                productScale, productVendor, (productDescription.length()<20 ? productDescription:productDescription.substring(0,20)), quantityInStock, buyPrice,msrp);
    }
}
