package ru.pas.zhukov.thinkpadnavigator.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.pas.zhukov.thinkpadnavigator.dto.response.SeriesResponseDto;
import ru.pas.zhukov.thinkpadnavigator.mapper.SeriesMapper;
import ru.pas.zhukov.thinkpadnavigator.service.SeriesService;

import java.util.List;

@RestController
@RequestMapping("/series")
@RequiredArgsConstructor
public class SeriesController {


    private final SeriesService seriesService;
    private final SeriesMapper seriesMapper;

    @GetMapping
    public ResponseEntity<List<SeriesResponseDto>> getAllSeries() {
        return ResponseEntity.ok(seriesService.getAllSeries().stream()
                .map(seriesMapper::toSeriesResponseDto)
                .toList()
        );
    }

}
