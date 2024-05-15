package backend.service.category.dto;

import java.io.Serializable;

public class CategoryDTO implements Serializable {
    private Long id;
    private String name;
    private CategoryDTO parentCategory;

    public CategoryDTO() {
    }

    public CategoryDTO(String name, CategoryDTO parentCategory) {
        this.name = name;
        this.parentCategory = parentCategory;
    }

    public CategoryDTO(Long id, String name, CategoryDTO parentCategory) {
        this.id = id;
        this.name = name;
        this.parentCategory = parentCategory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryDTO getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(CategoryDTO parentCategory) {
        this.parentCategory = parentCategory;
    }

}