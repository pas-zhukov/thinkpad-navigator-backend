package ru.pas.zhukov.thinkpadnavigator.mapper;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;
import ru.pas.zhukov.thinkpadnavigator.dto.response.GenerationResponseDto;
import ru.pas.zhukov.thinkpadnavigator.persistance.entity.Configuration;
import ru.pas.zhukov.thinkpadnavigator.persistance.entity.Generation;

import java.util.Map;

import static ru.pas.zhukov.thinkpadnavigator.util.FullNameUtils.buildGenerationFullName;

@Component
public class GenerationMapper {

    public GenerationResponseDto toGenerationResponseDto(@NotNull Generation generation,
                                                         @NotNull Map<Long, Configuration> commonGenerationIdConfigurationMap) {

        Configuration configuration = commonGenerationIdConfigurationMap.get(generation.getId());
        if (configuration == null) {
            throw new EntityNotFoundException("Configurations for generation with generation_id " + generation.getId() + " not found.");
        }

        return GenerationResponseDto.builder()
                .id(generation.getId())
                .fullName(buildGenerationFullName(generation))
                .modelId(generation.getModel().getId())
                .generationNumber(generation.getGenerationNumber())
                .postfix(generation.getPostfix())
                .releaseYear(generation.getReleaseYear())
                .thumbnailUrl(configuration.getThumbnailUrl())
                .typicalScreenSize(configuration.getDisplaySize() != null ? configuration.getDisplaySize().toPlainString() : null)
                .detailsUrl(configuration.getDetailsUrl())
                .typicalWeight(configuration.getWeight() != null ? configuration.getWeight().toPlainString() : null)
                .build();
    }
} 