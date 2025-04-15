package ru.pas.zhukov.thinkpadnavigator.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.pas.zhukov.thinkpadnavigator.dto.request.ModelSeriesSearchParams;
import ru.pas.zhukov.thinkpadnavigator.dto.response.ModelResponseDto;
import ru.pas.zhukov.thinkpadnavigator.dto.response.ModelSeriesResponseDto;
import ru.pas.zhukov.thinkpadnavigator.mapper.ModelMapper;
import ru.pas.zhukov.thinkpadnavigator.service.ModelCompositeService;
import ru.pas.zhukov.thinkpadnavigator.service.ModelService;

import java.util.List;

@RestController
@RequestMapping("/models")
@RequiredArgsConstructor
public class ModelController {

    private final ModelService modelService;
    private final ModelMapper modelMapper;
    private final ModelCompositeService modelCompositeService;

    @GetMapping
    public List<ModelResponseDto> getAllModels() {
        return modelService.getAllModels().stream()
                .map(modelMapper::toModelResponseDto)
                .toList();
    }

    @GetMapping("/series")
    public ResponseEntity<List<ModelSeriesResponseDto>> getModelSeries(
            @Valid ModelSeriesSearchParams searchParams
            ) {
        return ResponseEntity.ok(modelCompositeService.getSeries(searchParams));
    }
}
