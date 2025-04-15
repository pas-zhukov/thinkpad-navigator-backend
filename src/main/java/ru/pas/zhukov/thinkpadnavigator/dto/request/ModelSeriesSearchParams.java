package ru.pas.zhukov.thinkpadnavigator.dto.request;

import jakarta.annotation.Nullable;
import lombok.Builder;

@Builder
public record ModelSeriesSearchParams(

        @Nullable
        Long seriesId
) {
}
