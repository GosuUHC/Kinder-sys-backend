package backend.service.diagnosticResult.impl;

import java.util.List;

import backend.service.diagnosticResult.dto.DiagnosticResultDTO;
import backend.service.diagnosticResult.interfaces.in.IDiagnosticResultService;
import backend.service.diagnosticResult.interfaces.out.repository.IDiagnosticResultRepository;

public class DiagnosticResultService implements IDiagnosticResultService {

    private IDiagnosticResultRepository diagnosticResultRepository;

    @Override
    public void saveDiagnosticResult(DiagnosticResultDTO dto) {
        diagnosticResultRepository.save(dto);
    }

    @Override
    public void deleteDiagnosticResult(DiagnosticResultDTO dto) {
        diagnosticResultRepository.delete(dto);
    }

    @Override
    public DiagnosticResultDTO findDiagnosticResultById(Long id) {
        return diagnosticResultRepository.findById(id);
    }

    @Override
    public List<DiagnosticResultDTO> findAllDiagnosticResults() {
        return diagnosticResultRepository.findAll();
    }

    @Override
    public void injectDiagnosticRepository(IDiagnosticResultRepository diagnosticResultRepository) {
        this.diagnosticResultRepository = diagnosticResultRepository;
    }

    @Override
    public List<DiagnosticResultDTO> findDiagnosticResultByChildGroupId(Long childGroupId) {
        return diagnosticResultRepository.findByGroupId(childGroupId);
    }

    @Override
    public List<DiagnosticResultDTO> findDiagnosticResultsByChildGroupIdAndYear(Long childGroupId, Integer year) {
        return diagnosticResultRepository.findByGroupIdAndYear(childGroupId, year);
    }

    @Override
    public List<DiagnosticResultDTO> findDiagnosticResultByChildGroupIdAndCategoryIdAndYear(Long childGroupId,
            Long categoryId, Long year) {
        return diagnosticResultRepository.findDiagnosticResultByChildGroupIdAndCategoryIdAndYear(childGroupId,
                categoryId, year);

    }
}
