package backend.infrastructure.util.requestMapper;

import backend.infrastructure.builder.Built;
import backend.infrastructure.in.rest.request.DiagnosticsRequest;
import backend.service.category.dto.CategoryDTO;
import backend.service.category.interfaces.in.ICategoryService;
import backend.service.diagnosticResult.dto.DiagnosticResultDTO;
import jakarta.inject.Inject;

public class DiagnosticRequestMapper {

    @Inject
    @Built
    private ICategoryService categoryService;

    public DiagnosticResultDTO toDTO(DiagnosticsRequest diagnosticsRequest) {
        if (diagnosticsRequest == null) {
            return null;
        }

        Long categoryId = diagnosticsRequest.getCategoryId();

        CategoryDTO category = categoryId == null ? null
                : categoryService.findCategoryById(categoryId);

        return new DiagnosticResultDTO(category, diagnosticsRequest.getChildId(), diagnosticsRequest.getChildGroupId(),
                diagnosticsRequest.getStartScore(),
                diagnosticsRequest.getEndScore(), diagnosticsRequest.getYear());

    }
}
