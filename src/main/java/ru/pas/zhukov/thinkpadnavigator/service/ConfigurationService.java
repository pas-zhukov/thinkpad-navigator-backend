package ru.pas.zhukov.thinkpadnavigator.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.pas.zhukov.thinkpadnavigator.persistance.entity.Configuration;
import ru.pas.zhukov.thinkpadnavigator.persistance.repository.ConfigurationRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConfigurationService {

    private final ConfigurationRepository configurationRepository;

    public List<Configuration> getConfigurationsByGenerationId(long generationId) {
        return configurationRepository.findAllByGenerationId(generationId);
    }
}
