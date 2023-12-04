package ra.baitap_231204.service;

import ra.baitap_231204.dto.request.CategoriesRequestDTO;
import ra.baitap_231204.dto.request.ProductRequestDTO;
import ra.baitap_231204.dto.response.CategoriesResponseDTO;
import ra.baitap_231204.dto.response.ProductResponseDTO;

import java.util.List;

public interface ProductService {
    List<ProductResponseDTO> findAll();

    ProductResponseDTO findById(String productId);

    ProductResponseDTO save(ProductRequestDTO productRequestDTO);

    ProductResponseDTO update(ProductRequestDTO productRequestDTO, String productId);

    ProductResponseDTO delete(String productId);
}
