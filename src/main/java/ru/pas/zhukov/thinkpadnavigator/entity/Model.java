package ru.pas.zhukov.thinkpadnavigator.entity;

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
                        columnNames = {"model_series", "model_number", "model_name"}
                ),
                @UniqueConstraint(
                        name = "uniq_model_identity",
                        columnNames = {"model_series", "model_number", "model_name"}
                )
        })
public class Model {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "model_series", nullable = false, length = 10)
    private String modelSeries;

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

}
