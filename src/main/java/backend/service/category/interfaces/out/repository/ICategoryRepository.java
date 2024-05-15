package backend.service.category.interfaces.out.repository;

import java.util.List;

import backend.service.category.dto.CategoryDTO;

public interface ICategoryRepository {

    void save(CategoryDTO dto);

    void delete(CategoryDTO dto);

    CategoryDTO findById(Long id);

    List<CategoryDTO> findAll();

}