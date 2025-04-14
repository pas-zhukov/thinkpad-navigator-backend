package ru.pas.zhukov.thinkpadnavigator.mapper;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;
import ru.pas.zhukov.thinkpadnavigator.dto.response.GenerationResponseDto;
import ru.pas.zhukov.thinkpadnavigator.persistance.entity.ConfigurationEntity;
import ru.pas.zhukov.thinkpadnavigator.persistance.entity.GenerationEntity;

import java.util.Map;

import static ru.pas.zhukov.thinkpadnavigator.util.FullNameUtils.buildGenerationFullName;

@Component
public class GenerationMapper {

    public GenerationResponseDto toGenerationResponseDto(@NotNull GenerationEntity generationEntity,
                                                         @NotNull Map<Long, ConfigurationEntity> commonGenerationIdConfigurationMap) {

        ConfigurationEntity configurationEntity = commonGenerationIdConfigurationMap.get(generationEntity.getId());
        if (configurationEntity == null) {
            throw new EntityNotFoundException("Configurations for generation with generation_id " + generationEntity.getId() + " not found.");
        }

        return GenerationResponseDto.builder()
                .id(generationEntity.getId())
                .fullName(buildGenerationFullName(generationEntity))
                .modelId(generationEntity.getModel().getId())
                .generationNumber(generationEntity.getGenerationNumber())
                .postfix(generationEntity.getPostfix())
                .releaseYear(generationEntity.getReleaseYear())
                .thumbnailUrl(configurationEntity.getThumbnailUrl())
                .typicalScreenSize(configurationEntity.getDisplaySize() != null ? configurationEntity.getDisplaySize().toPlainString() : null)
                .detailsUrl(configurationEntity.getDetailsUrl())
                .typicalWeight(configurationEntity.getWeight() != null ? configurationEntity.getWeight().toPlainString() : null)
                .build();
    }
} 