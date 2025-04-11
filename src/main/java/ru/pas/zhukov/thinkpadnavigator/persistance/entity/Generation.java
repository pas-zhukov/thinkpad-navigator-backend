package ru.pas.zhukov.thinkpadnavigator.persistance.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "generation",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_model_generation_number_postfix_original_name",
                        columnNames = {"model_id", "generation_number", "postfix", "original_name"}
                )
        })
public class Generation {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "model_id", nullable = false)
    private Model model;

    @Nullable
    @Column(name = "generation_number", length = 10)
    private String generationNumber;

    @Nullable
    @Column(name = "postfix", length = 3)
    private String postfix;

    @NotNull
    @Column(name = "generation_type", length = 3)
    private String generationType;

    @Nullable
    @Column(name = "release_year")
    private Integer releaseYear;

    @NotNull
    @Column(name = "original_name", columnDefinition = "text")
    private String originalName;

}
