package ru.thinkpad.navigator.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "generations")
public class Generation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long generationId;

    @ManyToOne
    @JoinColumn(name = "model_id", nullable = false)
    private Model model;

    @Column(name = "generation_number", nullable = false)
    private Integer generationNumber;

    @Column(name = "generation_name", nullable = false, length = 50)
    private String generationName;

    @Column(name = "release_year")
    private Integer releaseYear;

    @OneToMany(mappedBy = "generation", cascade = CascadeType.ALL)
    private List<Configuration> configurations;
} 