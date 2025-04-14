package ru.pas.zhukov.thinkpadnavigator.dto.response;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record SeriesResponseDto(

        @NotNull
        Long id,

        @NotNull
        String name
) {
}
