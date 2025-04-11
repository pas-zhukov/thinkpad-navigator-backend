package ru.pas.zhukov.thinkpadnavigator.mapper;

import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;
import ru.pas.zhukov.thinkpadnavigator.dto.response.ConfigurationResponseDto;
import ru.pas.zhukov.thinkpadnavigator.persistance.entity.Configuration;

@Component
public class ConfigurationMapper {

    public ConfigurationResponseDto toConfigurationResponseDto(@NotNull Configuration configuration) {
        return ConfigurationResponseDto.builder()
                .id(configuration.getId())
                .generationId(configuration.getGeneration().getId())
                .detailsUrl(configuration.getDetailsUrl())
                .thumbnailUrl(configuration.getThumbnailUrl())
                .brand(configuration.getBrand())
                .cpu(configuration.getCpu())
                .gpu(configuration.getGpu())
                .displaySize(configuration.getDisplaySize() != null ? configuration.getDisplaySize().toPlainString() : null)
                .displayResolution(configuration.getDisplayResolution())
                .panelType(configuration.getPanelType())
                .storageSsd(configuration.getStorageSsd() != null ? configuration.getStorageSsd().toPlainString() : null)
                .storageHdd(configuration.getStorageHdd() != null ? configuration.getStorageHdd().toPlainString() : null)
                .ram(configuration.getRam() != null ? configuration.getRam().toPlainString() : null)
                .weight(configuration.getWeight() != null ? configuration.getWeight().toPlainString() : null)
                .build();
    }
}
