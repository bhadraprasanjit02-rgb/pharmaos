package com.pharmaos.org.entity;

import com.pharmaos.shared.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "departments")
@Getter
@Setter
public class Department extends BaseEntity {

    @Column(nullable = false, unique = true, length = 30)
    private String departmentCode;

    @Column(nullable = false, unique = true, length = 150)
    private String departmentName;

    @Column(length = 500)
    private String description;
}