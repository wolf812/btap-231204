package ra.baitap_231204.serviceImp;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.springframework.beans.factory.annotation.Autowired;
import ra.baitap_231204.dto.request.ProductRequestDTO;
import ra.baitap_231204.dto.response.ProductResponseDTO;
import ra.baitap_231204.mapper.ProductMapper;
import ra.baitap_231204.model.Product;
import ra.baitap_231204.repository.ProductRepository;
import ra.baitap_231204.service.ProductService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductServiceImp implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<ProductResponseDTO> findAll() {
        List<Product> productList = productRepository.findAll();
        List<ProductResponseDTO> responseDTOList = productList.stream()
                .map(product -> productMapper.toResponse(product)).collect(Collectors.toList()).reversed();
        return responseDTOList;    }

    @Override
    public ProductResponseDTO findById(String productId) {
        Optional<Product> otpProduct = productRepository.findById(productId);
        if (otpProduct.isPresent()) {
            return productMapper.toResponse(otpProduct.get());
        }
        return null;    }

    @Override
    public ProductResponseDTO save(ProductRequestDTO productRequestDTO) {
        return productMapper.toResponse(productRepository.save(productMapper.toEntity(productRequestDTO)));
    }


    @Override
    public ProductResponseDTO update(ProductRequestDTO productRequestDTO, String productId) {
        Optional<Product> optCatalog = productRepository.findById(productId);
        if (optCatalog.isPresent()){
            Product productUpdate = optCatalog.get();
            productUpdate.setProductName(productRequestDTO.getProductName());
            productUpdate.setPrice(productRequestDTO.getPrice());
            productUpdate.setCreated(productRequestDTO.getCreated());
            productUpdate.setCatalog(productRequestDTO.getCatalog());
            productUpdate.setStatus(productRequestDTO.isStatus());
            return productMapper.toResponse(productRepository.save(productUpdate));
        }
        return null;
    }

    @Override
    public ProductResponseDTO delete(String productId) {
        Optional<Product> optCatalog = productRepository.findById(productId);
        if (optCatalog.isPresent()){
            //Thực hiện xóa
            productRepository.deleteById(productId);
            return productMapper.toResponse(optCatalog.get());
        }
        return null;    }
}
