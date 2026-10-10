package com.pharmaos.org.entity;

import com.pharmaos.shared.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "designations")
@Getter
@Setter
public class Designation extends BaseEntity {

    @Column(nullable = false, unique = true, length = 30)
    private String designationCode;

    @Column(nullable = false, unique = true, length = 150)
    private String designationName;

    @Column(nullable = false)
    private Integer hierarchyLevel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_designation_id")
    private Designation parentDesignation;

    @Column(nullable = false)
    private Boolean isManager = false;

    @Column(nullable = false)
    private Boolean isFieldForce = false;

    @Column(nullable = false)
    private Boolean isSalesRole = false;

    @Column(length = 500)
    private String description;
}