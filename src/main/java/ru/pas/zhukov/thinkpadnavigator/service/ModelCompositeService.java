package ru.pas.zhukov.thinkpadnavigator.service;

import org.springframework.stereotype.Service;
import ru.pas.zhukov.thinkpadnavigator.dto.response.ModelSeriesResponseDto;
import ru.pas.zhukov.thinkpadnavigator.mapper.ModelMapper;

import java.util.Comparator;
import java.util.List;

@Service
public class ModelCompositeService {

    private final ModelService modelService;
    private final ModelMapper modelMapper;

    public ModelCompositeService(ModelService modelService, ModelMapper modelMapper) {
        this.modelService = modelService;
        this.modelMapper = modelMapper;
    }

    public List<ModelSeriesResponseDto> getSeries() {
        var models = modelService.getAllModels();
        return models.stream()
                .map(modelMapper::toModelSeriesResponseDto)
                .sorted(Comparator.comparing(ModelSeriesResponseDto::seriesName, Comparator.naturalOrder()))
                .toList();
    }
}
