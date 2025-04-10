package ru.thinkpad.navigator.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "configurations")
public class Configuration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long configId;

    @ManyToOne
    @JoinColumn(name = "generation_id", nullable = false)
    private Generation generation;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "cpu", length = 100)
    private String cpu;

    @Column(name = "gpu", length = 100)
    private String gpu;

    @Column(name = "ram", length = 50)
    private String ram;

    @Column(name = "storage_ssd", length = 50)
    private String storageSsd;

    @Column(name = "storage_hdd", length = 50)
    private String storageHdd;

    @Column(name = "display_size", length = 20)
    private String displaySize;

    @Column(name = "display_resolution", length = 50)
    private String displayResolution;

    @Column(name = "display_type", length = 50)
    private String displayType;

    @Column(name = "weight", length = 20)
    private String weight;

    @Column(name = "price", precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "buy_url")
    private String buyUrl;

    @Column(name = "thumb_url")
    private String thumbUrl;

    @Column(name = "is_new")
    private Boolean isNew;

    @Column(name = "last_updated")
    private LocalDateTime lastUpdated;

    @OneToMany(mappedBy = "configuration", cascade = CascadeType.ALL)
    private List<Feature> features;

    @OneToMany(mappedBy = "configuration", cascade = CascadeType.ALL)
    private List<SuitableFor> suitableFor;
} 