package ru.pas.zhukov.thinkpadnavigator.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.pas.zhukov.thinkpadnavigator.dto.request.GenerationSearchParams;
import ru.pas.zhukov.thinkpadnavigator.dto.response.GenerationResponseDto;
import ru.pas.zhukov.thinkpadnavigator.mapper.GenerationMapper;
import ru.pas.zhukov.thinkpadnavigator.service.GenerationService;

import java.util.List;

@RestController
@RequestMapping("/generations")
@RequiredArgsConstructor
public class GenerationController {

    private final GenerationService generationService;
    private final GenerationMapper generationMapper;

    @GetMapping("/search")
    public List<GenerationResponseDto> searchGenerations(
            @Valid GenerationSearchParams params
    ) {
        return generationService.searchGenerations(params).stream()
                .map(generationMapper::toGenerationResponseDto)
                .toList();
    }
} 