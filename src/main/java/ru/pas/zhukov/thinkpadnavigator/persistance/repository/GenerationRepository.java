package ru.pas.zhukov.thinkpadnavigator.persistance.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.pas.zhukov.thinkpadnavigator.persistance.entity.GenerationEntity;

import java.math.BigDecimal;

@Repository
public interface GenerationRepository extends JpaRepository<GenerationEntity, Long> {

    @Query(value =
            """
            SELECT DISTINCT g FROM GenerationEntity g
            LEFT JOIN ConfigurationEntity c on c.generation = g
            WHERE
            (:modelId IS NULL OR g.model.id = :modelId)
            AND (:generationNumber IS NULL OR g.generationNumber = :generationNumber)
            AND (:postfix IS NULL OR g.postfix = :postfix)
            AND (:generationType IS NULL OR g.generationType = :generationType)
            AND (:releaseYear IS NULL OR g.releaseYear = :releaseYear)
            AND (:screenSize IS NULL OR c.displaySize = :screenSize)
            AND (:screenResolution IS NULL OR c.displayResolution ILIKE :screenResolution)
            AND (:panelType IS NULL OR c.panelType = :panelType)
            AND (:weight IS NULL OR c.weight <= :weight)
            AND (:generationId IS NULL OR g.id = :generationId)
            ORDER BY g.generationNumber ASC
            """
    )
    @EntityGraph(attributePaths = {"modelEntity"})
    Page<GenerationEntity> findAllByModelIdAndGenerationNumberAndPostfixAndGenerationTypeAndReleaseYear(
            Long modelId,
            String generationNumber,
            String postfix,
            String generationType,
            Integer releaseYear,
            BigDecimal screenSize,
            String screenResolution,
            String panelType,
            BigDecimal weight,
            Long generationId,
            Pageable pageable
    );
}
