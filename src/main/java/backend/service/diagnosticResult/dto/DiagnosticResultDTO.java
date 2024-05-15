package backend.service.diagnosticResult.dto;

import java.io.Serializable;

import backend.service.category.dto.CategoryDTO;

public class DiagnosticResultDTO implements Serializable {
    private Long id;
    private CategoryDTO category;
    private Long childId;
    private Long childGroupId;
    private Integer startScore;
    private Integer endScore;
    private Integer year;

    public DiagnosticResultDTO() {
    }

    public DiagnosticResultDTO(CategoryDTO category, Long childId, Long childGroupId, Integer startScore,
            Integer endScore, Integer year) {
        this.category = category;
        this.childId = childId;
        this.childGroupId = childGroupId;
        this.startScore = startScore;
        this.endScore = endScore;
        this.year = year;
    }

    public DiagnosticResultDTO(Long id, CategoryDTO category, Long childId, Long childGroupId, Integer startScore,
            Integer endScore, Integer year) {
        this.id = id;
        this.category = category;
        this.childId = childId;
        this.childGroupId = childGroupId;
        this.startScore = startScore;
        this.endScore = endScore;
        this.year = year;
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