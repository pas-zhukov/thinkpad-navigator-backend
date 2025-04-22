package ru.pas.zhukov.thinkpadnavigator.dto.response;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record GenerationResponseDto(

    @NotNull
    Long id,

    @NotNull
    Long modelId,

    @NotNull
    String fullName,

    @Nullable
    String generationNumber,

    @Nullable
    String postfix,

    @Nullable
    Integer releaseYear,
    
    @NotNull
    ConfigurationResponseDto commonConfiguration

) {

}