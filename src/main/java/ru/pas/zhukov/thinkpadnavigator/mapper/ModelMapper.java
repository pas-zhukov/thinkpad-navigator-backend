package ru.pas.zhukov.thinkpadnavigator.mapper;

import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;
import ru.pas.zhukov.thinkpadnavigator.dto.response.ModelResponseDto;
import ru.pas.zhukov.thinkpadnavigator.dto.response.ModelSeriesResponseDto;
import ru.pas.zhukov.thinkpadnavigator.persistance.entity.ModelEntity;

import static ru.pas.zhukov.thinkpadnavigator.util.FullNameUtils.buildModelFullName;
import static ru.pas.zhukov.thinkpadnavigator.util.FullNameUtils.buildSeriesFullName;

@Component
public class ModelMapper {

    public ModelResponseDto toModelResponseDto(@NotNull ModelEntity modelEntity) {
        return ModelResponseDto.builder()
                .id(modelEntity.getId())
                .modelSeries(modelEntity.getSeries().getName())
                .modelNumber(modelEntity.getModelNumber())
                .modelName(modelEntity.getModelName())
                .description(modelEntity.getDescription())
                .releaseYear(modelEntity.getReleaseYear())
                .fullName(buildModelFullName(modelEntity))
                .build();
    }

    public ModelSeriesResponseDto toModelSeriesResponseDto(@NotNull ModelEntity modelEntity) {
        return ModelSeriesResponseDto.builder()
                .modelId(modelEntity.getId())
                .seriesName(buildSeriesFullName(modelEntity))
                .build();
    }
}
