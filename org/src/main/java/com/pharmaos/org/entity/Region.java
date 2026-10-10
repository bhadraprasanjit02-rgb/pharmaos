package com.pharmaos.org.entity;

import com.pharmaos.shared.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
        name = "regions",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_region_code",
                        columnNames = {"division_id", "region_code"}
                ),
                @UniqueConstraint(
                        name = "uk_region_name",
                        columnNames = {"division_id", "region_name"}
                )
        }
)
@Getter
@Setter
public class Region extends BaseEntity {

    @Column(nullable = false, length = 30)
    private String regionCode;

    @Column(nullable = false, length = 200)
    private String regionName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "division_id")
    private Division division;

    @Column(length = 500)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CompanyStatus status = CompanyStatus.ACTIVE;
}