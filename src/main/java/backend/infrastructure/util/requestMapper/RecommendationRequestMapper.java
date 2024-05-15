package backend.infrastructure.util.requestMapper;

import backend.infrastructure.builder.Built;
import backend.infrastructure.in.rest.request.RecommendationRequest;
import backend.service.category.dto.CategoryDTO;
import backend.service.category.interfaces.in.ICategoryService;
import backend.service.recommendation.dto.RecommendationDTO;
import jakarta.inject.Inject;

public class RecommendationRequestMapper {

    @Inject
    @Built
    private ICategoryService categoryService;

    public RecommendationDTO toDTO(RecommendationRequest recommendationRequest) {
        if (recommendationRequest == null) {
            return null;
        }

        Long categoryId = recommendationRequest.getCategoryId();

        CategoryDTO category = categoryId == null ? null
                : categoryService.findCategoryById(categoryId);

        return new RecommendationDTO(category, recommendationRequest.getHighScoreRecommendation(),
                recommendationRequest.getMiddleScoreRecommendation(),
                recommendationRequest.getLowScoreRecommendation());
    }
}
