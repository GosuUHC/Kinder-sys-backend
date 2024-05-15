package backend.infrastructure.util.entityMapper;

import backend.infrastructure.out.repository.db.diagnosticResult.EDiagnosticResult;
import backend.service.diagnosticResult.dto.DiagnosticResultDTO;

public class DiagnosticResultMapper {

    public static DiagnosticResultDTO toDTO(EDiagnosticResult entity) {
        if (entity == null) {
            return null;
        }

        return new DiagnosticResultDTO(
                entity.getId(),
                CategoryMapper.toDTO(entity.getCategory()),
                entity.getChildId(),
                entity.getChildGroupId(),
                entity.getStartScore(),
                entity.getEndScore(),
                entity.getYear());
    }

    public static EDiagnosticResult toEntity(DiagnosticResultDTO dto) {
        if (dto == null) {
            return null;
        }

        EDiagnosticResult entity = new EDiagnosticResult();
        entity.setId(dto.getId());
        entity.setCategory(CategoryMapper.toEntity(dto.getCategory()));
        entity.setChildId(dto.getChildId());
        entity.setChildGroupId(dto.getChildGroupId());
        entity.setStartScore(dto.getStartScore());
        entity.setEndScore(dto.getEndScore());
        entity.setYear(dto.getYear());
        return entity;
    }
}