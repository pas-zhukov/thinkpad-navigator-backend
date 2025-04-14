package ru.pas.zhukov.thinkpadnavigator.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.pas.zhukov.thinkpadnavigator.dto.request.GenerationSearchParams;
import ru.pas.zhukov.thinkpadnavigator.dto.response.GenerationResponseDto;
import ru.pas.zhukov.thinkpadnavigator.mapper.GenerationMapper;
import ru.pas.zhukov.thinkpadnavigator.persistance.entity.ConfigurationEntity;
import ru.pas.zhukov.thinkpadnavigator.persistance.entity.GenerationEntity;

import java.util.List;
import java.util.Map;

@Service
public class GenerationCompositeService {

    private final GenerationService generationService;
    private final ConfigurationService configurationService;
    private final GenerationMapper generationMapper;

    public GenerationCompositeService(GenerationService generationService, ConfigurationService configurationService, GenerationMapper generationMapper) {
        this.generationService = generationService;
        this.configurationService = configurationService;
        this.generationMapper = generationMapper;
    }

    public Page<GenerationResponseDto> searchGenerations(GenerationSearchParams params, Pageable pageable) {
        Page<GenerationEntity> generations = generationService.searchGenerations(params, pageable);
        List<Long> generationIds = generations.stream()
                .map(GenerationEntity::getId)
                .distinct()
                .toList();
        Map<Long, ConfigurationEntity> commonConfigurations = configurationService.findCommonConfigurationsByGenerationIds(generationIds);
        return generations.map(g -> generationMapper.toGenerationResponseDto(g, commonConfigurations));
    }
}
