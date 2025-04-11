package ru.pas.zhukov.thinkpadnavigator.dto.request;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;

public record GenerationSearchParams(
    
    @NotNull
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