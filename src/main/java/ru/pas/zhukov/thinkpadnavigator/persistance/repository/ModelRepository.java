package ru.pas.zhukov.thinkpadnavigator.persistance.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.pas.zhukov.thinkpadnavigator.persistance.entity.ModelEntity;

import java.util.List;

@Repository
public interface ModelRepository extends JpaRepository<ModelEntity, Long> {

    @EntityGraph(attributePaths = {"modelSeries"})
    List<ModelEntity> findAllByOrderBySeriesNameAsc();

}
