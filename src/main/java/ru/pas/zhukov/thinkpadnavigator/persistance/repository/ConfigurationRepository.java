package ru.pas.zhukov.thinkpadnavigator.persistance.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.pas.zhukov.thinkpadnavigator.persistance.entity.Configuration;

import java.util.Collection;
import java.util.List;

@Repository
public interface ConfigurationRepository extends JpaRepository<Configuration, Long> {

    @EntityGraph(attributePaths = {"generation"})
    Page<Configuration> findAllByGenerationId(long generationId, Pageable pageable);

    @EntityGraph(attributePaths = {"generation"})
    List<Configuration> findDistinctByGenerationIdIn(Collection<Long> generationIds);

    @Query(
            """
            SELECT c FROM Configuration c WHERE c.id IN
            (SELECT MIN(c2.id) FROM Configuration c2
            WHERE c2.generation.id IN :generationIds GROUP BY c2.generation.id)
            """
    )
    @EntityGraph(attributePaths = {"generation"})
    List<Configuration> findCommonConfigurationsByGenerationIds(Collection<Long> generationIds);
}
