package ru.pas.zhukov.thinkpadnavigator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.pas.zhukov.thinkpadnavigator.dto.response.ModelResponseDto;
import ru.pas.zhukov.thinkpadnavigator.mapper.ModelMapper;
import ru.pas.zhukov.thinkpadnavigator.service.ModelService;

import java.util.List;

@RestController
@RequestMapping("/model")
public class ModelController {

    private final ModelService modelService;
    private final ModelMapper modelMapper;

    public ModelController(ModelService modelService, ModelMapper modelMapper) {
        this.modelService = modelService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/all")
    public List<ModelResponseDto> getAllModels() {
        return modelService.getAllModels().stream()
                .map(modelMapper::toModelResponseDto)
                .toList();
    }
}
