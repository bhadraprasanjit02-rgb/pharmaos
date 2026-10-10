package com.pharmaos.org.entity;

import com.pharmaos.shared.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
        name = "divisions",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_division_code",
                        columnNames = {"business_unit_id","division_code"}
                ),
                @UniqueConstraint(
                        name = "uk_division_name",
                        columnNames = {"business_unit_id","division_name"}
                )
        }
)
@Getter
@Setter
public class Division extends BaseEntity {

    @Column(nullable = false, length = 30)
    private String divisionCode;

    @Column(nullable = false, length = 200)
    private String divisionName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "business_unit_id")
    private BusinessUnit businessUnit;

    @Column(length = 500)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CompanyStatus status = CompanyStatus.ACTIVE;
}