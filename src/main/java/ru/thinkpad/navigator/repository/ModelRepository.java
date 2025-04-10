package ru.thinkpad.navigator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.thinkpad.navigator.entity.Model;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long> {
} 