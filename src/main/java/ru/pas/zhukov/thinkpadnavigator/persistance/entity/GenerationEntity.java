package ru.pas.zhukov.thinkpadnavigator.persistance.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import ru.pas.zhukov.thinkpadnavigator.common.model.GenerationType;

@Data
@Entity
@Table(name = "generation",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_model_generation_number_postfix_original_name",
                        columnNames = {"model_id", "generation_number", "postfix", "original_name"}
                )
        })
public class GenerationEntity {

    @Id
    @NotNull
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "model_id", nullable = false)
    private ModelEntity model;

    @Nullable
    @Column(name = "generation_number", length = 10)
    private String generationNumber;

    @Nullable
    @Column(name = "postfix", length = 3)
    private String postfix;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "generation_type", length = 3)
    private GenerationType generationType;

    @Nullable
    @Column(name = "release_year")
    private Integer releaseYear;

    @NotNull
    @Column(name = "original_name", columnDefinition = "text")
    private String originalName;

}
