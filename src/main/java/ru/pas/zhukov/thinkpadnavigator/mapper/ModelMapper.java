package ru.pas.zhukov.thinkpadnavigator.mapper;

import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;
import ru.pas.zhukov.thinkpadnavigator.dto.response.ModelResponseDto;
import ru.pas.zhukov.thinkpadnavigator.persistance.entity.Model;

import static ru.pas.zhukov.thinkpadnavigator.util.FullNameUtils.buildModelFullName;

@Component
public class ModelMapper {

    public ModelResponseDto toModelResponseDto(@NotNull Model model) {
        return ModelResponseDto.builder()
                .id(model.getId())
                .modelSeries(model.getModelSeries())
                .modelNumber(model.getModelNumber())
                .modelName(model.getModelName())
                .description(model.getDescription())
                .releaseYear(model.getReleaseYear())
                .fullName(buildModelFullName(model))
                .build();
    }
}
