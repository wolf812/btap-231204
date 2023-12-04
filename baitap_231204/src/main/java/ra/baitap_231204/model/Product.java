package ra.baitap_231204.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "Product")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Product {
    @Id
    @Column(name = "product_id")
    private String productId;
    @Column(name = "product_name",unique = true,nullable = false)
    private String productName;
    @Column(name = "price",nullable = false)
    private float price;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date created;
    @Column(name = "product_status")
    private boolean status;
    @ManyToOne
    @JoinColumn(name = "catalog_id",referencedColumnName = "catalog_id")
    private Categories catalog;
}