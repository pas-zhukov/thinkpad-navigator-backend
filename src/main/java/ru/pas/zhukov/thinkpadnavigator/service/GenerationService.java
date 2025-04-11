package ru.pas.zhukov.thinkpadnavigator.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.pas.zhukov.thinkpadnavigator.dto.request.GenerationSearchParams;
import ru.pas.zhukov.thinkpadnavigator.persistance.entity.Generation;
import ru.pas.zhukov.thinkpadnavigator.persistance.repository.GenerationRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenerationService {

    private final GenerationRepository generationRepository;

    public List<Generation> searchGenerations(GenerationSearchParams params) {
        return generationRepository.findAll();
    }
} 