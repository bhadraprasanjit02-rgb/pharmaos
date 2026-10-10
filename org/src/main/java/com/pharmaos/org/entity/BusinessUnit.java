package com.pharmaos.org.entity;

import com.pharmaos.shared.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "business_units")
@Getter
@Setter
public class BusinessUnit extends BaseEntity {

    @Column(nullable = false, unique = true, length = 50)
    private String businessUnitCode;

    @Column(nullable = false, length = 200)
    private String businessUnitName;

    @Column(length = 500)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;
}