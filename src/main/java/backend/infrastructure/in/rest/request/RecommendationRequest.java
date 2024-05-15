package backend.infrastructure.in.rest.request;

public class RecommendationRequest {
    private Long categoryId;
    private String highScoreRecommendation;
    private String middleScoreRecommendation;
    private String lowScoreRecommendation;

    public RecommendationRequest() {
    }

    public RecommendationRequest(Long categoryId, String highScoreRecommendation, String middleScoreRecommendation,
            String lowScoreRecommendation) {
        this.categoryId = categoryId;
        this.highScoreRecommendation = highScoreRecommendation;
        this.middleScoreRecommendation = middleScoreRecommendation;
        this.lowScoreRecommendation = lowScoreRecommendation;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getHighScoreRecommendation() {
        return highScoreRecommendation;
    }

    public void setHighScoreRecommendation(String highScoreRecommendation) {
        this.highScoreRecommendation = highScoreRecommendation;
    }

    public String getMiddleScoreRecommendation() {
        return middleScoreRecommendation;
    }

    public void setMiddleScoreRecommendation(String middleScoreRecommendation) {
        this.middleScoreRecommendation = middleScoreRecommendation;
    }

    public String getLowScoreRecommendation() {
        return lowScoreRecommendation;
    }

    public void setLowScoreRecommendation(String lowScoreRecommendation) {
        this.lowScoreRecommendation = lowScoreRecommendation;
    }
}
