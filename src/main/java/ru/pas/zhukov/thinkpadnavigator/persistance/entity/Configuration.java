package ru.pas.zhukov.thinkpadnavigator.persistance.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "configuration")
public class Configuration {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "details_url", nullable = false, columnDefinition = "text")
    private String detailsUrl;

    @Nullable
    @Column(name = "thumbnail_url", columnDefinition = "text")
    private String thumbnailUrl;

    @Nullable
    @Column(name = "brand", length = 63)
    private String brand;

    @Nullable
    @Column(name = "cpu", length = 63)
    private String cpu;

    @Nullable
    @Column(name = "gpu", length = 63)
    private String gpu;

    @Nullable
    @Column(name = "display_size", precision = 5, scale = 1)
    private BigDecimal displaySize;

    @Nullable
    @Column(name = "display_resolution", length = 63)
    private String displayResolution;

    @Nullable
    @Column(name = "panel_type", length = 15)
    private String panelType;

    @Nullable
    @Column(name = "storage_ssd", precision = 10, scale = 1)
    private BigDecimal storageSsd;

    @Nullable
    @Column(name = "storage_hdd", precision = 10, scale = 1)
    private BigDecimal storageHdd;

    @Nullable
    @Column(name = "ram", precision = 5, scale = 1)
    private BigDecimal ram;

    @Nullable
    @Column(name = "weight", precision = 5, scale = 2)
    private BigDecimal weight;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "generation_id", nullable = false)
    private Generation generation;

}
