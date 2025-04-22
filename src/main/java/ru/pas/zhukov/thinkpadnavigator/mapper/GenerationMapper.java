package ru.pas.zhukov.thinkpadnavigator.mapper;

import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;
import ru.pas.zhukov.thinkpadnavigator.dto.response.GenerationResponseDto;
import ru.pas.zhukov.thinkpadnavigator.persistance.entity.GenerationEntity;

import static ru.pas.zhukov.thinkpadnavigator.util.FullNameUtils.buildGenerationFullName;

@Component
public class GenerationMapper {

    private final ConfigurationMapper configurationMapper;

    public GenerationMapper(ConfigurationMapper configurationMapper) {
        this.configurationMapper = configurationMapper;
    }

    public GenerationResponseDto toGenerationResponseDto(@NotNull GenerationEntity generationEntity) {
        return GenerationResponseDto.builder()
                .id(generationEntity.getId())
                .fullName(buildGenerationFullName(generationEntity))
                .modelId(generationEntity.getModel().getId())
                .generationNumber(generationEntity.getGenerationNumber())
                .postfix(generationEntity.getPostfix())
                .releaseYear(generationEntity.getReleaseYear())
                .commonConfiguration(configurationMapper.toConfigurationResponseDto(generationEntity.getCommonConfiguration()))
                .build();
    }
} 