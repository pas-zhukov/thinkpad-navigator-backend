package ru.pas.zhukov.thinkpadnavigator.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.pas.zhukov.thinkpadnavigator.dto.request.GenerationSearchParams;
import ru.pas.zhukov.thinkpadnavigator.dto.response.GenerationResponseDto;
import ru.pas.zhukov.thinkpadnavigator.mapper.GenerationMapper;
import ru.pas.zhukov.thinkpadnavigator.persistance.entity.Generation;
import ru.pas.zhukov.thinkpadnavigator.service.GenerationService;

@RestController
@RequestMapping("/generations")
@RequiredArgsConstructor
public class GenerationController {

    private final GenerationService generationService;
    private final GenerationMapper generationMapper;

    @GetMapping("/search")
    public ResponseEntity<PagedModel<GenerationResponseDto>> searchGenerations(
            @Valid GenerationSearchParams params,
            Pageable pageable
    ) {
        Page<Generation> entities =  generationService.searchGenerations(params, pageable);
        Page<GenerationResponseDto> dtosPage = entities.map(generationMapper::toGenerationResponseDto);
        return ResponseEntity.ok(new PagedModel<>(dtosPage));
    }
} 