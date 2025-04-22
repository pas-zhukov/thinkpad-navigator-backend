package ru.pas.zhukov.thinkpadnavigator.persistance.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.pas.zhukov.thinkpadnavigator.persistance.entity.ConfigurationEntity;

import java.util.Collection;
import java.util.List;

@Repository
public interface ConfigurationRepository extends JpaRepository<ConfigurationEntity, Long> {

    @EntityGraph(attributePaths = {"generation"})
    Page<ConfigurationEntity> findAllByGenerationId(long generationId, Pageable pageable);

    @EntityGraph(attributePaths = {"generation"})
    List<ConfigurationEntity> findDistinctByGenerationIdIn(Collection<Long> generationIds);

}
