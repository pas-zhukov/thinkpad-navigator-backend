package ru.pas.zhukov.thinkpadnavigator.dto.request;

import jakarta.annotation.Nullable;

public record GenerationSearchParams(
    
    @Nullable
    Long modelId,

    @Nullable
    String generationNumber,

    @Nullable
    String postfix,

    @Nullable
    String generationType,

    @Nullable
    Integer releaseYear

) {

}