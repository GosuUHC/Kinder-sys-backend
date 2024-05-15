package backend.service.category.impl;

import java.util.List;

import backend.service.category.dto.CategoryDTO;
import backend.service.category.interfaces.in.ICategoryService;
import backend.service.category.interfaces.out.repository.ICategoryRepository;

public class CategoryService implements ICategoryService {

    private ICategoryRepository categoryRepository;

    @Override
    public void saveCategory(CategoryDTO dto) {
        categoryRepository.save(dto);
    }

    @Override
    public void deleteCategory(CategoryDTO dto) {
        categoryRepository.delete(dto);
    }

    @Override
    public CategoryDTO findCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public List<CategoryDTO> findAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void injectCategoryRepository(ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
}
