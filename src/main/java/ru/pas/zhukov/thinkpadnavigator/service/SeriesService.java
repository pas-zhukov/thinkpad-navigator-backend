package ru.pas.zhukov.thinkpadnavigator.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.pas.zhukov.thinkpadnavigator.persistance.entity.SeriesEntity;
import ru.pas.zhukov.thinkpadnavigator.persistance.repository.SeriesRepository;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SeriesService {


    private final SeriesRepository seriesRepository;

    public List<SeriesEntity> getAllSeries() {
        return seriesRepository.findAllOrderByNameAsc().stream()
                .sorted(Comparator.<SeriesEntity, Integer>comparing(s -> {
                    String name = s.getName();
                    if (name == null || name.isEmpty()) {
                        return 4;
                    }
                    char firstChar = Character.toUpperCase(name.charAt(0));
                    if (firstChar == 'X' || firstChar == 'T' || firstChar == 'P' || firstChar == 'E') {
                        return 1;
                    } else if (Character.isLetter(firstChar)) {
                        return 2;
                    } else if (Character.isDigit(firstChar)) {
                        return 3;
                    } else {
                        return 4;
                    }
                }).thenComparing(SeriesEntity::getName))
                .toList();
    }
}
