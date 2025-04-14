package ru.pas.zhukov.thinkpadnavigator.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.pas.zhukov.thinkpadnavigator.persistance.entity.SeriesEntity;
import ru.pas.zhukov.thinkpadnavigator.persistance.repository.SeriesRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SeriesService {


    private final SeriesRepository seriesRepository;

    public List<SeriesEntity> getAllSeries() {
        return seriesRepository.findAllOrderByNameAsc();
    }
}
