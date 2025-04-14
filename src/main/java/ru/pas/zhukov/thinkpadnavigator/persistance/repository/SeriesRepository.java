package ru.pas.zhukov.thinkpadnavigator.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.pas.zhukov.thinkpadnavigator.persistance.entity.SeriesEntity;

import java.util.List;

@Repository
public interface SeriesRepository extends JpaRepository<SeriesEntity, Long> {

    @Query(
            """
            SELECT s
            FROM SeriesEntity s
            ORDER BY s.name ASC
            """
    )
    List<SeriesEntity> findAllOrderByNameAsc();
}
