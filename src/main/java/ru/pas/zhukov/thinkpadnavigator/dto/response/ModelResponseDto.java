package ru.pas.zhukov.thinkpadnavigator.dto.response;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record ModelResponseDto(

        @NotNull
        Long id,

        @NotNull
        String fullName,

        @NotNull
        String modelSeries,

        @Nullable
        String modelNumber,

        @Nullable
        String modelName,

        @Nullable
        String description,

        @Nullable
        Integer releaseYear
) {
}
