package backend.infrastructure.out.repository.db.diagnosticResult;

import java.util.List;
import java.util.stream.Collectors;

import backend.infrastructure.util.entityMapper.DiagnosticResultMapper;
import backend.service.diagnosticResult.dto.DiagnosticResultDTO;
import backend.service.diagnosticResult.interfaces.out.repository.IDiagnosticResultRepository;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class DiagnosticResultRepository implements IDiagnosticResultRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(DiagnosticResultDTO dto) {
        EDiagnosticResult entity = DiagnosticResultMapper.toEntity(dto);
        entityManager.persist(entity);
    }

    @Override
    public void delete(DiagnosticResultDTO dto) {
        EDiagnosticResult entity = DiagnosticResultMapper.toEntity(dto);
        entityManager.remove(entity);
    }

    @Override
    public DiagnosticResultDTO findById(Long id) {
        EDiagnosticResult entity = entityManager.find(EDiagnosticResult.class, id);
        return DiagnosticResultMapper.toDTO(entity);
    }

    @Override
    public List<DiagnosticResultDTO> findAll() {
        List<EDiagnosticResult> entities = entityManager
                .createQuery("SELECT d FROM EDiagnosticResult d", EDiagnosticResult.class)
                .getResultList();
        return entities.stream()
                .map(DiagnosticResultMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<DiagnosticResultDTO> findByGroupId(Long childGroupId) {
        List<EDiagnosticResult> entities = entityManager
                .createQuery("SELECT d FROM EDiagnosticResult d WHERE d.childGroupId=:id", EDiagnosticResult.class)
                .setParameter("id", childGroupId)
                .getResultList();
        return entities.stream()
                .map(DiagnosticResultMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<DiagnosticResultDTO> findByGroupIdAndYear(Long childGroupId, Integer year) {
        List<EDiagnosticResult> entities = entityManager
                .createQuery("SELECT d FROM EDiagnosticResult d WHERE d.childGroupId=:id AND d.year=:year",
                        EDiagnosticResult.class)
                .setParameter("id", childGroupId)
                .setParameter("year", year)
                .getResultList();
        return entities.stream()
                .map(DiagnosticResultMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<DiagnosticResultDTO> findDiagnosticResultByChildGroupIdAndCategoryIdAndYear(Long childGroupId,
            Long categoryId, Long year) {
        List<EDiagnosticResult> entities = entityManager
                .createQuery(
                        "SELECT d FROM EDiagnosticResult d WHERE d.childGroupId=:childGroupId AND d.category.id=:categoryId AND d.year=:year",
                        EDiagnosticResult.class)
                .setParameter("childGroupId", childGroupId)
                .setParameter("categoryId", categoryId)
                .setParameter("year", year)
                .getResultList();
        return entities.stream()
                .map(DiagnosticResultMapper::toDTO)
                .collect(Collectors.toList());
    }

}
