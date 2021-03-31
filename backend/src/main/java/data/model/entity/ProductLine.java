package data.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import javax.persistence.*;

@Entity(name = "productlines")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ProductLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String productLine;
    @Column(length = 4000)
    private String textDescription;
    @Column(length = 65535, columnDefinition = "TEXT")
    @Type(type="text")
    private String htmlDescription;
    @Lob
    @Type(type="org.hibernate.type.ImageType")
    private byte[] image;
}
