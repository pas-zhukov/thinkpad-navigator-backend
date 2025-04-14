package ru.pas.zhukov.thinkpadnavigator.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.pas.zhukov.thinkpadnavigator.persistance.entity.Configuration;
import ru.pas.zhukov.thinkpadnavigator.persistance.repository.ConfigurationRepository;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ConfigurationService {

    private final ConfigurationRepository configurationRepository;

    public Page<Configuration> getConfigurationsByGenerationId(long generationId,
                                                               Pageable pageable) {
        return configurationRepository.findAllByGenerationId(generationId, pageable);
    }

    public Map<Long, Configuration> findCommonConfigurationsByGenerationIds(List<Long> generationIds) {
        if (generationIds.isEmpty()) {
            return Collections.emptyMap();
        }
        return configurationRepository.findCommonConfigurationsByGenerationIds(generationIds)
                .stream()
                .collect(Collectors.toMap(
                        c -> c.getGeneration().getId(),
                        Function.identity()
                ));
    }
}
