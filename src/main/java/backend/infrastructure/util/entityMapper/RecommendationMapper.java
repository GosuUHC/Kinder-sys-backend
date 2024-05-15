package backend.infrastructure.util.entityMapper;

import backend.infrastructure.out.repository.db.recommendation.ERecommendation;
import backend.service.recommendation.dto.RecommendationDTO;

public class RecommendationMapper {

    public static RecommendationDTO toDTO(ERecommendation entity) {
        if (entity == null) {
            return null;
        }
        return new RecommendationDTO(
            entity.getId(),
            CategoryMapper.toDTO(entity.getCategory()),
            entity.getHighScoreRecommendation(),
            entity.getMiddleScoreRecommendation(),
            entity.getLowScoreRecommendation()
        );
    }

    public static ERecommendation toEntity(RecommendationDTO recommendationDto) {
        if (recommendationDto == null) {
            return null;
        }
        ERecommendation entity = new ERecommendation();
        entity.setId(recommendationDto.getId());
        entity.setHighScoreRecommendation(recommendationDto.getHighScoreRecommendation());
        entity.setMiddleScoreRecommendation(recommendationDto.getMiddleScoreRecommendation());
        entity.setLowScoreRecommendation(recommendationDto.getLowScoreRecommendation());
        entity.setCategory(CategoryMapper.toEntity(recommendationDto.getCategory()));
        return entity;
    }
}
