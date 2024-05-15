package backend.infrastructure.util.requestMapper;

import backend.infrastructure.builder.Built;
import backend.infrastructure.in.rest.request.CategoryRequest;
import backend.service.category.dto.CategoryDTO;
import backend.service.category.interfaces.in.ICategoryService;
import jakarta.inject.Inject;

public class CategoryRequestMapper {

    @Inject
    @Built
    private ICategoryService categoryService;

    public CategoryDTO toDTO(CategoryRequest categoryRequest) {
        if (categoryRequest == null) {
            return null;
        }

        Long parentCategoryId = categoryRequest.getParentCategoryId();

        CategoryDTO parentCategory = parentCategoryId == null ? null
                : categoryService.findCategoryById(parentCategoryId);

        return new CategoryDTO(
                categoryRequest.getName(),
                parentCategory);
    }
}
