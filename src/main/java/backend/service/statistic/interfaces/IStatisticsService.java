package backend.service.statistic.interfaces;

import backend.service.diagnosticResult.interfaces.out.repository.IDiagnosticResultRepository;
import backend.service.statistic.dto.StatisticDTO;

public interface IStatisticsService {

    StatisticDTO generateStatistics(Long groupId, Integer year);

    public void injectDiagnosticResultRepository(IDiagnosticResultRepository diagnosticResultRepository);
}
