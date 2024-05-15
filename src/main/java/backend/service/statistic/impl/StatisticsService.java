package backend.service.statistic.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import backend.service.diagnosticResult.dto.DiagnosticResultDTO;
import backend.service.diagnosticResult.interfaces.out.repository.IDiagnosticResultRepository;
import backend.service.statistic.dto.StatisticDTO;
import backend.service.statistic.interfaces.IStatisticsService;

public class StatisticsService implements IStatisticsService {

    private IDiagnosticResultRepository diagnosticResultRepository;

    @Override
    public void injectDiagnosticResultRepository(IDiagnosticResultRepository diagnosticResultRepository) {
        this.diagnosticResultRepository = diagnosticResultRepository;
    }

    @Override
    public StatisticDTO generateStatistics(Long groupId, Integer year) {
        List<DiagnosticResultDTO> diagnosticResults = diagnosticResultRepository.findByGroupIdAndYear(groupId, year);

        // Подсчет среднего значения startScore и endScore
        double averageStartScore = diagnosticResults.stream()
                .mapToInt(DiagnosticResultDTO::getStartScore)
                .average()
                .orElse(0.0);

        double averageEndScore = diagnosticResults.stream()
                .mapToInt(DiagnosticResultDTO::getEndScore)
                .average()
                .orElse(0.0);

        // Подсчет распределения результатов по startScore и endScore
        Map<Integer, Integer> startScoreDistribution = new HashMap<>();
        Map<Integer, Integer> endScoreDistribution = new HashMap<>();
        for (DiagnosticResultDTO result : diagnosticResults) {
            // Если ключ (значение балла) уже присутствует
            // в отображении, то метод merge() увеличивает его значение на 1
            startScoreDistribution.merge(result.getStartScore(), 1, Integer::sum);
            endScoreDistribution.merge(result.getEndScore(), 1, Integer::sum);
        }

        // Вычисление общей тенденции (процент улучшения/ухудшения)
        double overallTrendPercentage = calculateOverallTrendPercentage(averageStartScore, averageEndScore);

        // Подсчет общего количества результатов и детей
        int totalResultsCount = diagnosticResults.size();
        int totalChildrenCount = (int) diagnosticResults.stream().map(DiagnosticResultDTO::getChildId).distinct()
                .count();

        // Подсчет общей суммы результатов
        double totalResultsSum = diagnosticResults.stream().mapToInt(DiagnosticResultDTO::getStartScore).sum() +
                diagnosticResults.stream().mapToInt(DiagnosticResultDTO::getEndScore).sum();

        // Создание объекта StatisticDTO и его заполнение данными
        StatisticDTO statisticDTO = new StatisticDTO();
        statisticDTO.setAverageStartScore(averageStartScore);
        statisticDTO.setAverageEndScore(averageEndScore);
        statisticDTO.setStartScoreDistribution(startScoreDistribution);
        statisticDTO.setEndScoreDistribution(endScoreDistribution);
        statisticDTO.setOverallTrendPercentage(overallTrendPercentage);
        statisticDTO.setTotalResultsCount(totalResultsCount);
        statisticDTO.setTotalChildrenCount(totalChildrenCount);
        statisticDTO.setTotalResultsSum(totalResultsSum);

        return statisticDTO;
    }

    private double calculateOverallTrendPercentage(double averageStartScore, double averageEndScore) {
        // Рассчет процента изменения
        double percentageChange = ((averageEndScore - averageStartScore) / averageStartScore) * 100;
        return percentageChange;
    }
}
