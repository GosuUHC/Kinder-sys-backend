package backend.service.statistic.dto;

import java.util.Map;

public class StatisticDTO {
    private double averageStartScore;
    private double averageEndScore;
    private Map<Integer, Integer> startScoreDistribution;
    private Map<Integer, Integer> endScoreDistribution;
    private double overallTrendPercentage;
    private int totalResultsCount;
    private int totalChildrenCount;
    private double totalResultsSum;

    public StatisticDTO() {
    }

    public StatisticDTO(double averageStartScore, double averageEndScore, Map<Integer, Integer> startScoreDistribution,
            Map<Integer, Integer> endScoreDistribution, double overallTrendPercentage, int totalResultsCount,
            int totalChildrenCount, double totalResultsSum) {
        this.averageStartScore = averageStartScore;
        this.averageEndScore = averageEndScore;
        this.startScoreDistribution = startScoreDistribution;
        this.endScoreDistribution = endScoreDistribution;
        this.overallTrendPercentage = overallTrendPercentage;
        this.totalResultsCount = totalResultsCount;
        this.totalChildrenCount = totalChildrenCount;
        this.totalResultsSum = totalResultsSum;
    }

    public double getAverageStartScore() {
        return averageStartScore;
    }

    public void setAverageStartScore(double averageStartScore) {
        this.averageStartScore = averageStartScore;
    }

    public double getAverageEndScore() {
        return averageEndScore;
    }

    public void setAverageEndScore(double averageEndScore) {
        this.averageEndScore = averageEndScore;
    }

    public Map<Integer, Integer> getStartScoreDistribution() {
        return startScoreDistribution;
    }

    public void setStartScoreDistribution(Map<Integer, Integer> startScoreDistribution) {
        this.startScoreDistribution = startScoreDistribution;
    }

    public Map<Integer, Integer> getEndScoreDistribution() {
        return endScoreDistribution;
    }

    public void setEndScoreDistribution(Map<Integer, Integer> endScoreDistribution) {
        this.endScoreDistribution = endScoreDistribution;
    }

    public double getOverallTrendPercentage() {
        return overallTrendPercentage;
    }

    public void setOverallTrendPercentage(double overallTrendPercentage) {
        this.overallTrendPercentage = overallTrendPercentage;
    }

    public int getTotalResultsCount() {
        return totalResultsCount;
    }

    public void setTotalResultsCount(int totalResultsCount) {
        this.totalResultsCount = totalResultsCount;
    }

    public int getTotalChildrenCount() {
        return totalChildrenCount;
    }

    public void setTotalChildrenCount(int totalChildrenCount) {
        this.totalChildrenCount = totalChildrenCount;
    }

    public double getTotalResultsSum() {
        return totalResultsSum;
    }

    public void setTotalResultsSum(double totalResultsSum) {
        this.totalResultsSum = totalResultsSum;
    }

}
