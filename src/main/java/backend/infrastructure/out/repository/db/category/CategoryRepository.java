package backend.infrastructure.out.repository.db.category;

import java.util.List;
import java.util.stream.Collectors;

import backend.infrastructure.util.entityMapper.CategoryMapper;
import backend.service.category.dto.CategoryDTO;
import backend.service.category.interfaces.out.repository.ICategoryRepository;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class CategoryRepository implements ICategoryRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(CategoryDTO dto) {
        ECategory entity = CategoryMapper.toEntity(dto);
        entityManager.persist(entity);
    }

    @Override
    public void delete(CategoryDTO dto) {
        ECategory entity = CategoryMapper.toEntity(dto);
        entityManager.remove(entity);
    }

    @Override
    public CategoryDTO findById(Long id) {
        ECategory entity = entityManager.find(ECategory.class, id);
        return CategoryMapper.toDTO(entity);
    }

    @Override
    public List<CategoryDTO> findAll() {
        List<ECategory> entities = entityManager.createQuery("SELECT c FROM ECategory c", ECategory.class)
                .getResultList();
        return entities.stream()
                .map(CategoryMapper::toDTO)
                .collect(Collectors.toList());
    }

}
