package backend.service.recommendation.interfaces.in;

import java.util.List;

import backend.service.recommendation.dto.RecommendationDTO;
import backend.service.recommendation.interfaces.out.repository.IRecommendationRepository;

public interface IRecommendationService {

    void saveRecommendation(RecommendationDTO dto);

    void deleteRecommendation(RecommendationDTO dto);

    RecommendationDTO findRecommendationById(Long id);

    List<RecommendationDTO> findAllRecommendations();

    List<RecommendationDTO> findRecommendationsByCategoryId(Long categoryId);

    List<RecommendationDTO> findRecommendationsByChildGroupId(Long childGroupId);

    public void injectRecommendationRepository(IRecommendationRepository recommendationRepository);
}