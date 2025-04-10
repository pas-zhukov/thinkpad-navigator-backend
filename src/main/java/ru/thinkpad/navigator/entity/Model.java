package ru.thinkpad.navigator.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "models")
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long modelId;

    @Column(name = "model_series", nullable = false, length = 10)
    private String modelSeries;

    @Column(name = "model_number", nullable = false, length = 10)
    private String modelNumber;

    @Column(name = "model_name", nullable = false, length = 50)
    private String modelName;

    @Column(name = "description")
    private String description;

    @Column(name = "release_year")
    private Integer releaseYear;

    @OneToMany(mappedBy = "model", cascade = CascadeType.ALL)
    private List<Generation> generations;
} 