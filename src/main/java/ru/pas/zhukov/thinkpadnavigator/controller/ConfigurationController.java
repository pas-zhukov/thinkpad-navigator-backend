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
import ru.pas.zhukov.thinkpadnavigator.dto.request.ConfigurationSearchParams;
import ru.pas.zhukov.thinkpadnavigator.dto.response.ConfigurationResponseDto;
import ru.pas.zhukov.thinkpadnavigator.mapper.ConfigurationMapper;
import ru.pas.zhukov.thinkpadnavigator.persistance.entity.Configuration;
import ru.pas.zhukov.thinkpadnavigator.service.ConfigurationService;

@RestController
@RequestMapping("/configurations")
@RequiredArgsConstructor
public class ConfigurationController {

    private final ConfigurationService configurationService;
    private final ConfigurationMapper configurationMapper;

    @GetMapping("/search")
    public ResponseEntity<PagedModel<ConfigurationResponseDto>> searchConfigurations(
            @Valid ConfigurationSearchParams params,
            Pageable pageable
    ) {
        Page<Configuration> entities =  configurationService.getConfigurationsByGenerationId(params.generationId(), pageable);
        Page<ConfigurationResponseDto> dtosPage = entities.map(configurationMapper::toConfigurationResponseDto);
        return ResponseEntity.ok(new PagedModel<>(dtosPage));
    }
}
