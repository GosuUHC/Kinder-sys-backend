package backend.service.recommendation.impl;

import backend.service.category.dto.CategoryDTO;
import backend.service.diagnosticResult.dto.DiagnosticResultDTO;
import backend.service.diagnosticResult.interfaces.out.repository.IDiagnosticResultRepository;
import backend.service.recommendation.dto.RecommendationDTO;
import backend.service.recommendation.interfaces.in.IRecommendationService;
import backend.service.recommendation.interfaces.out.repository.IRecommendationRepository;

import java.util.ArrayList;
import java.util.List;

public class RecommendationService implements IRecommendationService {

    private IRecommendationRepository recommendationRepository;

    private IDiagnosticResultRepository diagnosticResultRepository;

    @Override
    public void saveRecommendation(RecommendationDTO dto) {
        recommendationRepository.save(dto);
    }

    @Override
    public void deleteRecommendation(RecommendationDTO dto) {
        recommendationRepository.delete(dto);
    }

    @Override
    public RecommendationDTO findRecommendationById(Long id) {
        return recommendationRepository.findById(id);
    }

    @Override
    public List<RecommendationDTO> findAllRecommendations() {
        return recommendationRepository.findAll();
    }

    @Override
    public void injectRecommendationRepository(IRecommendationRepository recommendationRepository) {
        this.recommendationRepository = recommendationRepository;
    }

    @Override
    public List<RecommendationDTO> findRecommendationsByCategoryId(Long categoryId) {
        return recommendationRepository.findByCategoryId(categoryId);
    }

    @Override
    public List<RecommendationDTO> findRecommendationsByChildGroupId(Long childGroupId) {
        List<DiagnosticResultDTO> diagnosticResultDTOs = diagnosticResultRepository.findByGroupId(childGroupId);

        List<RecommendationDTO> recommendationDTOs = new ArrayList<RecommendationDTO>();

        for (DiagnosticResultDTO diagnosticResultDTO : diagnosticResultDTOs) {
            CategoryDTO categoryDTO = diagnosticResultDTO.getCategory();

            // Пока есть категории (включая их родителей)
            while (categoryDTO != null) {
                // Получаем список рекомендаций для текущей категории
                List<RecommendationDTO> categoryRecommendations = recommendationRepository
                        .findByCategoryId(categoryDTO.getId());

                // Добавляем рекомендации в общий список
                recommendationDTOs.addAll(categoryRecommendations);

                // Переходим к родительской категории
                categoryDTO = categoryDTO.getParentCategory();
            }
        }

        return recommendationDTOs;
    }
}
