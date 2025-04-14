package ru.pas.zhukov.thinkpadnavigator.mapper;

import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;
import ru.pas.zhukov.thinkpadnavigator.dto.response.ModelResponseDto;
import ru.pas.zhukov.thinkpadnavigator.dto.response.ModelSeriesResponseDto;
import ru.pas.zhukov.thinkpadnavigator.persistance.entity.Model;

import static ru.pas.zhukov.thinkpadnavigator.util.FullNameUtils.buildModelFullName;
import static ru.pas.zhukov.thinkpadnavigator.util.FullNameUtils.buildSeriesFullName;

@Component
public class ModelMapper {

    public ModelResponseDto toModelResponseDto(@NotNull Model model) {
        return ModelResponseDto.builder()
                .id(model.getId())
                .modelSeries(model.getModelSeries().getName())
                .modelNumber(model.getModelNumber())
                .modelName(model.getModelName())
                .description(model.getDescription())
                .releaseYear(model.getReleaseYear())
                .fullName(buildModelFullName(model))
                .build();
    }

    public ModelSeriesResponseDto toModelSeriesResponseDto(@NotNull Model model) {
        return ModelSeriesResponseDto.builder()
                .modelId(model.getId())
                .seriesName(buildSeriesFullName(model))
                .build();
    }
}
