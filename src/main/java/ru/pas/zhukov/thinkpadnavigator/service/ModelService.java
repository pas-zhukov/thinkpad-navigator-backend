package ru.pas.zhukov.thinkpadnavigator.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.pas.zhukov.thinkpadnavigator.persistance.entity.ModelEntity;
import ru.pas.zhukov.thinkpadnavigator.persistance.repository.ModelRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModelService {

    private final ModelRepository modelRepository;

    public List<ModelEntity> getAllModels() {
        return modelRepository.findAllByOrderBySeriesNameAsc();
    }
}
