package ru.pas.zhukov.thinkpadnavigator.persistance.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.pas.zhukov.thinkpadnavigator.persistance.entity.Generation;

@Repository
public interface GenerationRepository extends JpaRepository<Generation, Long> {

    @Query(value =
            """
            SELECT g FROM Generation g
            WHERE
            (:modelId IS NULL OR g.model.id = :modelId)
            AND (:generationNumber IS NULL OR g.generationNumber = :generationNumber)
            AND (:postfix IS NULL OR g.postfix = :postfix)
            AND (:generationType IS NULL OR g.generationType = :generationType)
            AND (:releaseYear IS NULL OR g.releaseYear = :releaseYear)
            """
    )
    @EntityGraph(attributePaths = {"model"})
    Page<Generation> findAllByModelIdAndGenerationNumberAndPostfixAndGenerationTypeAndReleaseYear(
            Long modelId,
            String generationNumber,
            String postfix,
            String generationType,
            Integer releaseYear,
            Pageable pageable
    );
}
