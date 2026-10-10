package com.pharmaos.org.entity;

import com.pharmaos.shared.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
        name = "headquarters",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_hq_code",
                        columnNames = {"territory_id", "hq_code"}
                ),
                @UniqueConstraint(
                        name = "uk_hq_name",
                        columnNames = {"territory_id", "hq_name"}
                )
        }
)
@Getter
@Setter
public class Headquarter extends BaseEntity {

    @Column(nullable = false, length = 30)
    private String hqCode;

    @Column(nullable = false, length = 200)
    private String hqName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "territory_id", nullable = false)
    private Territory territory;

    @Column(length = 100)
    private String state;

    @Column(length = 100)
    private String district;

    @Column(length = 100)
    private String city;

    @Column(length = 10)
    private String pincode;

    @Column(length = 500)
    private String description;
}