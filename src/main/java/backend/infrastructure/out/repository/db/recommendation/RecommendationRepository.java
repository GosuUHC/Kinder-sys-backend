package backend.infrastructure.out.repository.db.recommendation;

import java.util.List;
import java.util.stream.Collectors;

import backend.infrastructure.util.entityMapper.RecommendationMapper;
import backend.service.recommendation.dto.RecommendationDTO;
import backend.service.recommendation.interfaces.out.repository.IRecommendationRepository;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class RecommendationRepository implements IRecommendationRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(RecommendationDTO dto) {
        ERecommendation entity = RecommendationMapper.toEntity(dto);
        entityManager.persist(entity);
    }

    @Override
    public void delete(RecommendationDTO dto) {
        ERecommendation entity = RecommendationMapper.toEntity(dto);
        entityManager.remove(entity);
    }

    @Override
    public RecommendationDTO findById(Long id) {
        ERecommendation entity = entityManager.find(ERecommendation.class, id);
        return RecommendationMapper.toDTO(entity);
    }

    @Override
    public List<RecommendationDTO> findAll() {
        List<ERecommendation> entities = entityManager
                .createQuery("SELECT r FROM ERecommendation r", ERecommendation.class)
                .getResultList();
        return entities.stream()
                .map(RecommendationMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<RecommendationDTO> findByCategoryId(Long categoryId) {
        List<ERecommendation> entities = entityManager.createQuery(
                "SELECT r FROM ERecommendation r WHERE r.category.id=:categoryId", ERecommendation.class)
                .setParameter("categoryId", categoryId)
                .getResultList();
        return entities.stream()
                .map(RecommendationMapper::toDTO)
                .collect(Collectors.toList());
    }

}
