package ru.pas.zhukov.thinkpadnavigator.persistance.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
@Entity
@Table(name = "model",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_model_series_number_name",
                        columnNames = {"model_series_id", "model_number", "model_name"}
                )
        })
public class ModelEntity {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "model_series_id", nullable = false)
    private SeriesEntity series;

    @Nullable
    @Column(name = "model_number", length = 10)
    private String modelNumber;

    @Nullable
    @Column(name = "model_name", length = 50)
    private String modelName;

    @Nullable
    @Column(name = "description", columnDefinition = "text")
    private String description;

    @Nullable
    @Column(name = "release_year")
    private Integer releaseYear;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "type", length = 3)
    private ru.pas.zhukov.thinkpadnavigator.common.model.GenerationType generationType;

}
