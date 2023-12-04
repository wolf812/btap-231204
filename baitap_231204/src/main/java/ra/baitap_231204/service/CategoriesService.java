package ra.baitap_231204.service;

import ra.baitap_231204.dto.request.CategoriesRequestDTO;
import ra.baitap_231204.dto.response.CategoriesResponseDTO;


import java.util.List;

public interface CategoriesService {
    List<CategoriesResponseDTO> findAll();

    CategoriesResponseDTO findById(long catalogId);

    CategoriesResponseDTO save(CategoriesRequestDTO categoriesRequestDTO);

    CategoriesResponseDTO update(CategoriesRequestDTO categoriesRequestDTO, long catalogId);

    CategoriesResponseDTO delete(long catalogId);
}
