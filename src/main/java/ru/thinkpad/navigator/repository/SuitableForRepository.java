package ru.thinkpad.navigator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.thinkpad.navigator.entity.SuitableFor;

@Repository
public interface SuitableForRepository extends JpaRepository<SuitableFor, Long> {
} 