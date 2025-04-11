package ru.pas.zhukov.thinkpadnavigator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.pas.zhukov.thinkpadnavigator.entity.Generation;

@Repository
public interface GenerationRepository extends JpaRepository<Generation, Long> {

}
