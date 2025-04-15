package ru.pas.zhukov.thinkpadnavigator.dto.request;

import jakarta.annotation.Nullable;

import java.math.BigDecimal;

public record GenerationSearchParams(
    
    @Nullable
    Long modelId,

    @Nullable
    Long seriesId,

    @Nullable
    Long generationId,

    @Nullable
    String generationNumber,

    @Nullable
    String postfix,

    @Nullable
    String generationType,

    @Nullable
    Integer releaseYear,

    @Nullable
    BigDecimal screenSize,

    @Nullable
    String screenResolution,

    @Nullable
    String panelType,

    @Nullable
    BigDecimal weight

) {

}