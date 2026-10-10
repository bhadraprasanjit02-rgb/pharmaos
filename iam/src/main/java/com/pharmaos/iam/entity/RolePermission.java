package com.pharmaos.iam.entity;

import com.pharmaos.shared.entity.BaseEntity;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "role_permissions")
@Getter
@Setter
public class RolePermission extends BaseEntity {

    @ManyToOne(optional = false)
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToOne(optional = false)
    @JoinColumn(name = "permission_id")
    private Permission permission;
}