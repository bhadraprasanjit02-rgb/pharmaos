package com.pharmaos.org.entity;

import com.pharmaos.shared.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "territories")
@Getter
@Setter
public class Territory extends BaseEntity {

    @Column(nullable = false, unique = true, length = 30)
    private String territoryCode;

    @Column(nullable = false, length = 150)
    private String territoryName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id", nullable = false)
    private Region region;

    @Column(length = 500)
    private String description;
}