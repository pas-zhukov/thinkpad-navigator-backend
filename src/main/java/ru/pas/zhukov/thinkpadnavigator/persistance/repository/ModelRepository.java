package ru.pas.zhukov.thinkpadnavigator.persistance.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.pas.zhukov.thinkpadnavigator.persistance.entity.ModelEntity;

import java.util.List;

@Repository
public interface ModelRepository extends JpaRepository<ModelEntity, Long> {

    @Query(
            """
            SELECT m
            FROM ModelEntity m
            ORDER BY m.series.name
            """
    )
    @EntityGraph(attributePaths = {"series"})
    List<ModelEntity> findAllOrderBySeriesNameAsc();

    @Query(
            """
            SELECT m
            FROM ModelEntity m
            WHERE (:id IS NULL OR m.series.id = :id)
            """
    )
    @EntityGraph(attributePaths = {"series"})
    List<ModelEntity> findAllBySeriesId(Long id);

}
