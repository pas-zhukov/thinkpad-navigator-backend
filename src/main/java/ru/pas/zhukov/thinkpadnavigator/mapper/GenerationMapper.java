package ru.pas.zhukov.thinkpadnavigator.mapper;

import jakarta.annotation.Nullable;
import org.springframework.stereotype.Component;
import ru.pas.zhukov.thinkpadnavigator.dto.response.GenerationResponseDto;
import ru.pas.zhukov.thinkpadnavigator.persistance.entity.Generation;

import static ru.pas.zhukov.thinkpadnavigator.util.FullNameUtils.buildGenerationFullName;

@Component
public class GenerationMapper {

    @Nullable
    public GenerationResponseDto toGenerationResponseDto(@Nullable Generation generation) {
        if (generation == null) {
            return null;
        }
        
        return GenerationResponseDto.builder()
                .id(generation.getId())
                .fullName(buildGenerationFullName(generation))
                .modelId(generation.getModel().getId())
                .generationNumber(generation.getGenerationNumber())
                .postfix(generation.getPostfix())
                .releaseYear(generation.getReleaseYear())
                .build();
    }
} 