package backend.infrastructure.util.entityMapper;

import backend.infrastructure.out.repository.db.category.ECategory;
import backend.service.category.dto.CategoryDTO;

public class CategoryMapper {

    public static CategoryDTO toDTO(ECategory entity) {
        if (entity == null) {
            return null;
        }
        return new CategoryDTO(
                entity.getId(),
                entity.getName(),
                toDTO(entity.getParentCategory()));
    }

    public static ECategory toEntity(CategoryDTO dto) {
        if (dto == null) {
            return null;
        }
        ECategory entity = new ECategory();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setParentCategory(toEntity(dto.getParentCategory()));
        return entity;
    }
}
