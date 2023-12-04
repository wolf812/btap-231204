package ra.baitap_231204.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.baitap_231204.dto.request.CategoriesRequestDTO;
import ra.baitap_231204.dto.response.CategoriesResponseDTO;
import ra.baitap_231204.mapper.CategoriesMapper;
import ra.baitap_231204.model.Categories;
import ra.baitap_231204.repository.CategoriesRepository;
import ra.baitap_231204.service.CategoriesService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service

public class CategoriesServiceImp implements CategoriesService {
    @Autowired
    private CategoriesRepository categoriesRepository;
    @Autowired
    private CategoriesMapper categoriesMapper;

    @Override
    public List<CategoriesResponseDTO> findAll() {
        List<Categories> categoriesList = categoriesRepository.findAll();
        List<CategoriesResponseDTO> responseDTOList = categoriesList.stream()
                .map(categories -> categoriesMapper.toResponse(categories)).collect(Collectors.toList());
        return responseDTOList;
    }

    @Override
    public CategoriesResponseDTO findById(long catalogId) {
        Optional<Categories> otpCatalog = categoriesRepository.findById(catalogId);
        if (otpCatalog.isPresent()) {
            return categoriesMapper.toResponse(otpCatalog.get());
        }
        return null;
    }

    @Override
    public CategoriesResponseDTO save(CategoriesRequestDTO categoriesRequestDTO) {
        return categoriesMapper.toResponse(categoriesRepository.save(categoriesMapper.toEntity(categoriesRequestDTO)));
    }

    @Override
    public CategoriesResponseDTO update(CategoriesRequestDTO categoriesRequestDTO, long catalogId) {
        Optional<Categories> optCatalog = categoriesRepository.findById(catalogId);
        if (optCatalog.isPresent()){
            Categories categoriesUpdate = optCatalog.get();
            categoriesUpdate.setCatalogName(categoriesRequestDTO.getCatalogName());
            categoriesUpdate.setStatus(categoriesRequestDTO.isStatus());
            return categoriesMapper.toResponse(categoriesRepository.save(categoriesUpdate));
        }
        return null;
    }

    @Override
    public CategoriesResponseDTO delete(long catalogId) {
        Optional<Categories> optCatalog = categoriesRepository.findById(catalogId);
        if (optCatalog.isPresent()){
            //Thực hiện xóa
            categoriesRepository.deleteById(catalogId);
            return categoriesMapper.toResponse(optCatalog.get());
        }
        return null;
    }
}
