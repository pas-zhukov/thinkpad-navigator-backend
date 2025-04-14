package ru.pas.zhukov.thinkpadnavigator.dto.response;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record ModelSeriesResponseDto(

        @NotNull
        Long modelId,

        @NotNull
        String seriesName
) {
}
