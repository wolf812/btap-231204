package ra.baitap_231204.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ra.baitap_231204.model.Categories;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

public class ProductResponseDTO {
    private String productId;
    private String productName;
    private float price;
    private Date created;
    private Categories catalog;
    private boolean status;
}
