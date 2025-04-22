package ru.pas.zhukov.thinkpadnavigator.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.pas.zhukov.thinkpadnavigator.dto.request.GenerationSearchParams;
import ru.pas.zhukov.thinkpadnavigator.dto.response.GenerationResponseDto;
import ru.pas.zhukov.thinkpadnavigator.mapper.GenerationMapper;
import ru.pas.zhukov.thinkpadnavigator.persistance.entity.GenerationEntity;

@Service
@RequiredArgsConstructor
public class GenerationCompositeService {

    private final GenerationService generationService;
    private final GenerationMapper generationMapper;

    public Page<GenerationResponseDto> searchGenerations(GenerationSearchParams params, Pageable pageable) {
        Page<GenerationEntity> generations = generationService.searchGenerations(params, pageable);
        return generations.map(generationMapper::toGenerationResponseDto);
    }
}
