package ra.baitap_231204.mapper;

import org.springframework.stereotype.Component;
import ra.baitap_231204.dto.request.CategoriesRequestDTO;
import ra.baitap_231204.dto.response.CategoriesResponseDTO;
import ra.baitap_231204.model.Categories;
@Component

public class CategoriesMapper implements GenericMapper<Categories, CategoriesRequestDTO, CategoriesResponseDTO> {
    @Override
    public Categories toEntity(CategoriesRequestDTO categoriesRequestDTO) {
        //Tạo constructor dùng 1 lần và khởi tạo luôn đối tượng từ constructor đó
        return Categories.builder().catalogId(categoriesRequestDTO.getCatalogId())
                .catalogName(categoriesRequestDTO.getCatalogName())
                .status(categoriesRequestDTO.isStatus()).build();
    }

    @Override
    public CategoriesResponseDTO toResponse(Categories categories) {
        return CategoriesResponseDTO.builder().catalogId(categories.getCatalogId())
                .catalogName(categories.getCatalogName())
                .status(categories.isStatus()).build();
    }
}
