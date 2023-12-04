package ra.baitap_231204.mapper;

import org.springframework.stereotype.Component;
import ra.baitap_231204.dto.request.ProductRequestDTO;
import ra.baitap_231204.dto.response.ProductResponseDTO;
import ra.baitap_231204.model.Product;

import java.util.Date;
@Component

public class ProductMapper implements GenericMapper<Product, ProductRequestDTO, ProductResponseDTO> {
    @Override
    public Product toEntity(ProductRequestDTO productRequestDTO) {
//Tạo constructor dùng 1 lần và khởi tạo luôn đối tượng từ constructor đó
        return Product.builder().productId(productRequestDTO.getProductId())
                .productName(productRequestDTO.getProductName())
                .price(productRequestDTO.getPrice())
                .created(productRequestDTO.getCreated())
                .catalog(productRequestDTO.getCatalog())
                .status(productRequestDTO.isStatus()).build();
    }


    @Override
    public ProductResponseDTO toResponse(Product product) {
        return ProductResponseDTO.builder().productId(product.getProductId())
                .productName(product.getProductName())
                .price(product.getPrice())
                .created(product.getCreated())
                .catalog(product.getCatalog())
                .status(product.isStatus()).build();
    }
}
