package ru.pas.zhukov.thinkpadnavigator.mapper;

import org.springframework.stereotype.Component;
import ru.pas.zhukov.thinkpadnavigator.dto.response.SeriesResponseDto;
import ru.pas.zhukov.thinkpadnavigator.persistance.entity.SeriesEntity;

@Component
public class SeriesMapper {

    public SeriesResponseDto toSeriesResponseDto(SeriesEntity seriesEntity) {
        return SeriesResponseDto.builder()
                .id(seriesEntity.getId())
                .name(seriesEntity.getName())
                .build();
    }
}
