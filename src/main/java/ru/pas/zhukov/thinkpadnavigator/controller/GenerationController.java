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
import ru.pas.zhukov.thinkpadnavigator.service.GenerationCompositeService;

@RestController
@RequestMapping("/generations")
@RequiredArgsConstructor
public class GenerationController {

    private final GenerationCompositeService generationCompositeService;

    @GetMapping("/search")
    public ResponseEntity<PagedModel<GenerationResponseDto>> searchGenerations(
            @Valid GenerationSearchParams params,
            Pageable pageable
    ) {
        Page<GenerationResponseDto> dtosPage = generationCompositeService.searchGenerations(params, pageable);
        return ResponseEntity.ok(new PagedModel<>(dtosPage));
    }
} 