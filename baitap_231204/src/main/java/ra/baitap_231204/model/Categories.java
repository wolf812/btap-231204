package ra.baitap_231204.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Categories")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "catalog_id")
    private long catalogId;

    @Column(name = "catalog_name",unique = true,columnDefinition = "varchar(100)",nullable = false)
    private String catalogName;

    private String descriptions;

    private int priority;

    @Column(name = "catalog_status",columnDefinition = "bit default 1")
    private boolean status;

    @OneToMany(mappedBy = "catalog")
    private List<Product> listProduct;
}
