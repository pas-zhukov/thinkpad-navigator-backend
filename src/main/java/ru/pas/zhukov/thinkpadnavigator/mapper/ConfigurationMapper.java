package ru.pas.zhukov.thinkpadnavigator.mapper;

import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;
import ru.pas.zhukov.thinkpadnavigator.dto.response.ConfigurationResponseDto;
import ru.pas.zhukov.thinkpadnavigator.persistance.entity.ConfigurationEntity;

@Component
public class ConfigurationMapper {

    public ConfigurationResponseDto toConfigurationResponseDto(@NotNull ConfigurationEntity configurationEntity) {
        return ConfigurationResponseDto.builder()
                .id(configurationEntity.getId())
                .generationId(configurationEntity.getGeneration().getId())
                .detailsUrl(configurationEntity.getDetailsUrl())
                .thumbnailUrl(configurationEntity.getThumbnailUrl())
                .brand(configurationEntity.getBrand())
                .cpu(configurationEntity.getCpu())
                .gpu(configurationEntity.getGpu())
                .displaySize(configurationEntity.getDisplaySize() != null ? configurationEntity.getDisplaySize().toPlainString() : null)
                .displayResolution(configurationEntity.getDisplayResolution())
                .panelType(configurationEntity.getPanelType() != null ? configurationEntity.getPanelType().toString() : null)
                .storageSsd(configurationEntity.getStorageSsd() != null ? configurationEntity.getStorageSsd().toPlainString() : null)
                .storageHdd(configurationEntity.getStorageHdd() != null ? configurationEntity.getStorageHdd().toPlainString() : null)
                .ram(configurationEntity.getRam() != null ? configurationEntity.getRam().toPlainString() : null)
                .weight(configurationEntity.getWeight() != null ? configurationEntity.getWeight().toPlainString() : null)
                .build();
    }
}
