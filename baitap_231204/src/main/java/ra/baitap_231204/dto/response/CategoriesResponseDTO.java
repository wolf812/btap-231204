package ra.baitap_231204.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CategoriesResponseDTO {
    private long catalogId;
    private String catalogName;
    private boolean status;
}