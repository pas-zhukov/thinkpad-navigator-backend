package ru.pas.zhukov.thinkpadnavigator.dto.response;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record ConfigurationResponseDto(

        @NotNull
        Long id,

        @NotNull
        Long generationId,

        @NotNull
        String detailsUrl,

        @Nullable
        String thumbnailUrl,

        @Nullable
        String brand,

        @Nullable
        String cpu,

        @Nullable
        String gpu,

        @Nullable
        String displaySize,

        @Nullable
        String displayResolution,

        @Nullable
        String panelType,

        @Nullable
        String storageSsd,

        @Nullable
        String storageHdd,

        @Nullable
        String ram,

        @Nullable
        String weight
) {
}
