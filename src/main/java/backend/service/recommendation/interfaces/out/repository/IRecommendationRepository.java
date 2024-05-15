package backend.service.recommendation.interfaces.out.repository;

import java.util.List;

import backend.service.recommendation.dto.RecommendationDTO;

public interface IRecommendationRepository {

    void save(RecommendationDTO dto);

    void delete(RecommendationDTO dto);

    RecommendationDTO findById(Long id);

    List<RecommendationDTO> findAll();

    List<RecommendationDTO> findByCategoryId(Long categoryId);
}