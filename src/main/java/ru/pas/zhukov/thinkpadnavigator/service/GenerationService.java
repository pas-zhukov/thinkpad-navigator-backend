package ru.pas.zhukov.thinkpadnavigator.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.pas.zhukov.thinkpadnavigator.dto.request.GenerationSearchParams;
import ru.pas.zhukov.thinkpadnavigator.persistance.entity.Generation;
import ru.pas.zhukov.thinkpadnavigator.persistance.repository.GenerationRepository;

@Service
@RequiredArgsConstructor
public class GenerationService {

    private final GenerationRepository generationRepository;

    public Page<Generation> searchGenerations(GenerationSearchParams params, Pageable pageable) {
        return generationRepository.findAllByModelIdAndGenerationNumberAndPostfixAndGenerationTypeAndReleaseYear(
                params.modelId(),
                params.generationNumber(),
                params.postfix(),
                params.generationType(),
                params.releaseYear(),
                pageable
        );
    }
} 