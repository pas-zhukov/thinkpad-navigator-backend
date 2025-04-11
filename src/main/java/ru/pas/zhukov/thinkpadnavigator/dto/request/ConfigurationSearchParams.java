package ru.pas.zhukov.thinkpadnavigator.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record ConfigurationSearchParams(

        @NotNull
        Long generationId
) {
}
