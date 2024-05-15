package backend.infrastructure.builder;

import backend.service.recommendation.interfaces.in.IRecommendationService;
import backend.service.recommendation.interfaces.out.repository.IRecommendationRepository;
import jakarta.enterprise.inject.Default;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;

public class RecommencdationBuilder {

    @Inject
    @Default
    private IRecommendationRepository recommendationRepository;

    @Inject
    @Default
    private IRecommendationService recommendationService;

    @Produces
    @Built
    public IRecommendationService builRecommendationService() {
        recommendationService.injectRecommendationRepository(recommendationRepository);
        return recommendationService;
    }
}
