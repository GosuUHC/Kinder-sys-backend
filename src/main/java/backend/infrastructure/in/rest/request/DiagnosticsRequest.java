package backend.infrastructure.in.rest.request;

// один результат, а приходят они в списке
public class DiagnosticsRequest {
    private Long categoryId;
    private Long childId;
    private Long childGroupId;
    private Integer startScore;
    private Integer endScore;
    private Integer year;

    public DiagnosticsRequest() {
    }

    public DiagnosticsRequest(Long categoryId, Long childId, Long childGroupId, Integer startScore, Integer endScore,
            Integer year) {
        this.categoryId = categoryId;
        this.childId = childId;
        this.childGroupId = childGroupId;
        this.startScore = startScore;
        this.endScore = endScore;
        this.year = year;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getChildId() {
        return childId;
    }

    public void setChildId(Long childId) {
        this.childId = childId;
    }

    public Long getChildGroupId() {
        return childGroupId;
    }

    public void setChildGroupId(Long childGroupId) {
        this.childGroupId = childGroupId;
    }

    public Integer getStartScore() {
        return startScore;
    }

    public void setStartScore(Integer startScore) {
        this.startScore = startScore;
    }

    public Integer getEndScore() {
        return endScore;
    }

    public void setEndScore(Integer endScore) {
        this.endScore = endScore;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

}
