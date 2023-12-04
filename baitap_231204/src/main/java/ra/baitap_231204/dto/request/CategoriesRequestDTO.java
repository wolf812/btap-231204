package ra.baitap_231204.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CategoriesRequestDTO {
    private long catalogId;

//    @NotNull(message = "Tên danh mục không được null")
    private String catalogName;

    private boolean status;
}
