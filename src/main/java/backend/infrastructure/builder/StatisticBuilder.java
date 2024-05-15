package backend.infrastructure.builder;

import backend.service.diagnosticResult.interfaces.out.repository.IDiagnosticResultRepository;
import backend.service.statistic.interfaces.IStatisticsService;
import jakarta.enterprise.inject.Default;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;

public class StatisticBuilder {

    @Inject
    @Default
    private IStatisticsService statisticsService;

    @Inject
    @Default
    private IDiagnosticResultRepository diagnosticResultRepository;

    @Produces
    @Built
    public IStatisticsService buildStatisticsService() {
        statisticsService.injectDiagnosticResultRepository(diagnosticResultRepository);
        return statisticsService;
    }
}
