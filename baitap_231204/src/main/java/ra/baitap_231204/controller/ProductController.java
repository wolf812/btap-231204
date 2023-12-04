package ra.baitap_231204.controller;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.baitap_231204.dto.request.CategoriesRequestDTO;
import ra.baitap_231204.dto.request.ProductRequestDTO;
import ra.baitap_231204.dto.response.CategoriesResponseDTO;
import ra.baitap_231204.dto.response.ProductResponseDTO;
import ra.baitap_231204.service.ProductService;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/product")
public class ProductController {
    private final ProductService productService;


    @PostMapping("create")
    public ResponseEntity<ProductResponseDTO> createProduct(@Valid @RequestBody ProductRequestDTO productRequestDTO) {

        return ResponseEntity.ok(productService.save(productRequestDTO));
    }
    @PutMapping("/update")
    public ResponseEntity<ProductResponseDTO> updateCatalog(@RequestBody ProductRequestDTO productRequestDTO,@PathVariable  String productId){
        ProductResponseDTO productResponseDTO = productService.update(productRequestDTO,productId);
        return new ResponseEntity<>(productResponseDTO,HttpStatus.CREATED);
    }


    @GetMapping("/list-product")
    public ResponseEntity<List<ProductResponseDTO>> getAllProduct() {
        List<ProductResponseDTO> product = productService.findAll();
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ProductResponseDTO> deleteProduct(@PathVariable String productId) {
        return ResponseEntity.ok(productService.delete(productId));
    }
}

