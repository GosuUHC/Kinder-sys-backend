package backend.service.recommendation.dto;

import java.io.Serializable;

import backend.service.category.dto.CategoryDTO;

public class RecommendationDTO implements Serializable {
    private Long id;
    private CategoryDTO category;
    private String highScoreRecommendation;
    private String middleScoreRecommendation;
    private String lowScoreRecommendation;

    public RecommendationDTO() {
    }

    public RecommendationDTO(CategoryDTO category, String highScoreRecommendation, String middleScoreRecommendation,
            String lowScoreRecommendation) {
        this.category = category;
        this.highScoreRecommendation = highScoreRecommendation;
        this.middleScoreRecommendation = middleScoreRecommendation;
        this.lowScoreRecommendation = lowScoreRecommendation;
    }

    public RecommendationDTO(Long id, CategoryDTO category, String highScoreRecommendation,
            String middleScoreRecommendation,
            String lowScoreRecommendation) {
        this.id = id;
        this.category = category;
        this.highScoreRecommendation = highScoreRecommendation;
        this.middleScoreRecommendation = middleScoreRecommendation;
        this.lowScoreRecommendation = lowScoreRecommendation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
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