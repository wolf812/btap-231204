package ra.baitap_231204.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.baitap_231204.dto.request.CategoriesRequestDTO;
import ra.baitap_231204.dto.response.CategoriesResponseDTO;
import ra.baitap_231204.service.CategoriesService;

import java.util.List;

/** @noinspection SpringJavaInjectionPointsAutowiringInspection*/
@RestController
@RequestMapping("/api/v1/categories")
public class CategoriesController {
    @Autowired
    private CategoriesService categoriesService;
    @GetMapping("/find-catalog")
    public ResponseEntity<List<CategoriesResponseDTO>> getAllCatalog(){
        List<CategoriesResponseDTO> listCatalog = categoriesService.findAll();
        return  new ResponseEntity<>(listCatalog, HttpStatus.OK);
    }
    @GetMapping("/getById")
    public ResponseEntity<CategoriesResponseDTO> getCatalogById(@PathVariable long catalogId){
        CategoriesResponseDTO catalog = categoriesService.findById(catalogId);
        return new ResponseEntity<>(catalog,HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<CategoriesResponseDTO> createCatalog(@Valid @RequestBody CategoriesRequestDTO categoriesRequestDTO){
        CategoriesResponseDTO catalog = categoriesService.save(categoriesRequestDTO);
        return new ResponseEntity<>(catalog,HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<CategoriesResponseDTO> updateCatalog(@RequestBody CategoriesRequestDTO categoriesRequestDTO,@PathVariable  long catalogId){
        CategoriesResponseDTO catalog = categoriesService.update(categoriesRequestDTO,catalogId);
        return new ResponseEntity<>(catalog,HttpStatus.CREATED);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<CategoriesResponseDTO> deleteCatalog(@PathVariable long catalogId){
        CategoriesResponseDTO emp = categoriesService.delete(catalogId);
        return new ResponseEntity<>(emp,HttpStatus.OK);
    }
}
