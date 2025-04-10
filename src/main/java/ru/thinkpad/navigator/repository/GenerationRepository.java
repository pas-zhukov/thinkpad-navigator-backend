package ru.thinkpad.navigator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.thinkpad.navigator.entity.Generation;

@Repository
public interface GenerationRepository extends JpaRepository<Generation, Long> {
} 