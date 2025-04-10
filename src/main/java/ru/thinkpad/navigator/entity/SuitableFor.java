package ru.thinkpad.navigator.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "suitable_for")
public class SuitableFor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long suitableId;

    @ManyToOne
    @JoinColumn(name = "config_id", nullable = false)
    private Configuration configuration;

    @Column(name = "task_name", nullable = false, length = 100)
    private String taskName;

    @Column(name = "suitability_score")
    private Integer suitabilityScore;
} 