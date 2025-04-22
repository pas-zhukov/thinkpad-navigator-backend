package ru.pas.zhukov.thinkpadnavigator.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.pas.zhukov.thinkpadnavigator.persistance.entity.ConfigurationEntity;
import ru.pas.zhukov.thinkpadnavigator.persistance.repository.ConfigurationRepository;

@Service
@RequiredArgsConstructor
public class ConfigurationService {

    private final ConfigurationRepository configurationRepository;

    public Page<ConfigurationEntity> getConfigurationsByGenerationId(long generationId,
                                                                     Pageable pageable) {
        return configurationRepository.findAllByGenerationId(generationId, pageable);
    }

}
