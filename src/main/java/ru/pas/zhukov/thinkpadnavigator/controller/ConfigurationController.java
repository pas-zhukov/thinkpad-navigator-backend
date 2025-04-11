package ru.pas.zhukov.thinkpadnavigator.controller;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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

    @GetMapping("/all")
    public List<ConfigurationResponseDto> getConfigurationsByGenerationId(
            @RequestParam @NotNull long generationId
    ) {
        return configurationService.getConfigurationsByGenerationId(generationId).stream()
                .map(configurationMapper::toConfigurationResponseDto)
                .toList();
    }
}
