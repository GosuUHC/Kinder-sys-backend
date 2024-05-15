package backend.service.category.interfaces.in;

import java.util.List;

import backend.service.category.dto.CategoryDTO;
import backend.service.category.interfaces.out.repository.ICategoryRepository;

public interface ICategoryService {

    void saveCategory(CategoryDTO dto);

    void deleteCategory(CategoryDTO dto);

    CategoryDTO findCategoryById(Long id);

    List<CategoryDTO> findAllCategories();

    public void injectCategoryRepository(ICategoryRepository categoryRepository);
}