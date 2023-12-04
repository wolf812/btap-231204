package ra.baitap_231204.dto.request;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import ra.baitap_231204.model.Categories;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

public class ProductRequestDTO {
    private String productId;
    private String productName;
    private float price;
    private Date created;
    private Categories catalog;
    private boolean status;
}
