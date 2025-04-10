package ru.thinkpad.navigator.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "features")
public class Feature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long featureId;

    @ManyToOne
    @JoinColumn(name = "config_id", nullable = false)
    private Configuration configuration;

    @Column(name = "feature_name", nullable = false, length = 100)
    private String featureName;

    @Column(name = "feature_value", nullable = false)
    private String featureValue;
} 