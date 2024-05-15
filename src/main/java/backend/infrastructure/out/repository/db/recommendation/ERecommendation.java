package backend.infrastructure.out.repository.db.recommendation;

import backend.infrastructure.out.repository.db.category.ECategory;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "recommendations")
public class ERecommendation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private ECategory category;

    @Column(name = "high_score_recommendation")
    private String highScoreRecommendation;

    @Column(name = "middle_score_recommendation")
    private String middleScoreRecommendation;

    @Column(name = "low_score_recommendation")
    private String lowScoreRecommendation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ECategory getCategory() {
        return category;
    }

    public void setCategory(ECategory category) {
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