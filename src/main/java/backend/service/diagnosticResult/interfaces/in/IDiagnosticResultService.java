package backend.service.diagnosticResult.interfaces.in;

import java.util.List;

import backend.service.diagnosticResult.dto.DiagnosticResultDTO;
import backend.service.diagnosticResult.interfaces.out.repository.IDiagnosticResultRepository;

public interface IDiagnosticResultService {

    void saveDiagnosticResult(DiagnosticResultDTO dto);

    void deleteDiagnosticResult(DiagnosticResultDTO dto);

    DiagnosticResultDTO findDiagnosticResultById(Long id);

    List<DiagnosticResultDTO> findAllDiagnosticResults();

    List<DiagnosticResultDTO> findDiagnosticResultByChildGroupId(Long childGroupId);

    List<DiagnosticResultDTO> findDiagnosticResultByChildGroupIdAndCategoryIdAndYear(Long childGroupId, Long categoryId, Long year);

    List<DiagnosticResultDTO> findDiagnosticResultsByChildGroupIdAndYear(Long childGroupId, Integer year);

    public void injectDiagnosticRepository(IDiagnosticResultRepository diagnosticResultRepository);
}
