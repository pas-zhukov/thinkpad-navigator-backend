package ru.pas.zhukov.thinkpadnavigator.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.pas.zhukov.thinkpadnavigator.dto.request.ConfigurationSearchParams;
import ru.pas.zhukov.thinkpadnavigator.dto.response.ConfigurationResponseDto;
import ru.pas.zhukov.thinkpadnavigator.mapper.ConfigurationMapper;
import ru.pas.zhukov.thinkpadnavigator.service.ConfigurationService;

import java.util.List;

@RestController
@RequestMapping("/configuration")
@RequiredArgsConstructor
public class ConfigurationController {

    private final ConfigurationService configurationService;
    private final ConfigurationMapper configurationMapper;

    @GetMapping("/search")
    public List<ConfigurationResponseDto> searchConfigurations(
            @Valid ConfigurationSearchParams params
    ) {
        return configurationService.getConfigurationsByGenerationId(params.generationId()).stream()
                .map(configurationMapper::toConfigurationResponseDto)
                .toList();
    }
}
