package ru.pas.zhukov.thinkpadnavigator.persistance.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.pas.zhukov.thinkpadnavigator.persistance.entity.ConfigurationEntity;

import java.util.Collection;
import java.util.List;

@Repository
public interface ConfigurationRepository extends JpaRepository<ConfigurationEntity, Long> {

    @EntityGraph(attributePaths = {"generationEntity"})
    Page<ConfigurationEntity> findAllByGenerationId(long generationId, Pageable pageable);

    @EntityGraph(attributePaths = {"generationEntity"})
    List<ConfigurationEntity> findDistinctByGenerationIdIn(Collection<Long> generationIds);

    @Query(
            """
            SELECT c FROM ConfigurationEntity c WHERE c.id IN
            (SELECT MIN(c2.id) FROM ConfigurationEntity c2
            WHERE c2.generation.id IN :generationIds GROUP BY c2.generation.id)
            """
    )
    @EntityGraph(attributePaths = {"generationEntity"})
    List<ConfigurationEntity> findCommonConfigurationsByGenerationIds(Collection<Long> generationIds);
}
