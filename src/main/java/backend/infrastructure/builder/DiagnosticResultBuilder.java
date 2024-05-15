package backend.infrastructure.builder;

import backend.service.diagnosticResult.interfaces.in.IDiagnosticResultService;
import backend.service.diagnosticResult.interfaces.out.repository.IDiagnosticResultRepository;
import jakarta.enterprise.inject.Default;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;

public class DiagnosticResultBuilder {

    @Inject
    @Default
    private IDiagnosticResultRepository diagnosticResultRepository;

    @Inject
    @Default
    private IDiagnosticResultService diagnosticResultService;

    @Produces
    @Built
    public IDiagnosticResultService buildDiagnosticResultService() {
        diagnosticResultService.injectDiagnosticRepository(diagnosticResultRepository);
        return diagnosticResultService;
    }
}
