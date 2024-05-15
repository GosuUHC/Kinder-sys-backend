package backend.infrastructure.builder;

import backend.service.category.interfaces.in.ICategoryService;
import backend.service.category.interfaces.out.repository.ICategoryRepository;
import jakarta.enterprise.inject.Default;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;

public class CategoryBuilder {

    @Inject
    @Default
    private ICategoryRepository categoryRepository;

    @Inject
    @Default
    private ICategoryService categoryService;

    @Produces
    @Built
    public ICategoryService buildCategoryService() {
        categoryService.injectCategoryRepository(categoryRepository);
        return categoryService;
    }
}
