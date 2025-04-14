package ru.pas.zhukov.thinkpadnavigator.persistance.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.pas.zhukov.thinkpadnavigator.persistance.entity.Model;

import java.util.List;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long> {

    @EntityGraph(attributePaths = {"modelSeries"})
    List<Model> findAllByOrderByModelSeriesNameAsc();

}
