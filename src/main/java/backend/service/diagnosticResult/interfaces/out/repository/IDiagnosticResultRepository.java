package backend.service.diagnosticResult.interfaces.out.repository;

import java.util.List;

import backend.service.diagnosticResult.dto.DiagnosticResultDTO;

public interface IDiagnosticResultRepository {

    void save(DiagnosticResultDTO dto);

    void delete(DiagnosticResultDTO dto);

    DiagnosticResultDTO findById(Long id);

    List<DiagnosticResultDTO> findAll();

    List<DiagnosticResultDTO> findByGroupId(Long childGroupId);

    List<DiagnosticResultDTO> findByGroupIdAndYear(Long childGroupId, Integer year);
}