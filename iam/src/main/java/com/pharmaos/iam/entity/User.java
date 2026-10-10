package com.pharmaos.iam.entity;

import com.pharmaos.shared.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User extends BaseEntity {

    @Column(nullable = false, unique = true, length = 50)
    private String employeeCode;

    @Column(nullable = false, length = 150)
    private String firstName;

    @Column(length = 150)
    private String lastName;

    @Column(nullable = false, unique = true, length = 150)
    private String email;

    @Column(nullable = false, unique = true, length = 20)
    private String mobile;

    @Column(nullable = false)
    private String password;

    @Column(length = 100)
    private String designation;

    @Column(length = 100)
    private String department;

    @Column(nullable = false)
    private Boolean accountLocked = false;

    @Column(nullable = false)
    private Boolean accountExpired = false;

    @Column(nullable = false)
    private Boolean credentialsExpired = false;

    @Column(nullable = false)
    private Boolean enabled = true;

    @OneToMany(mappedBy = "user")
    private List<UserRole> userRoles = new ArrayList<>();
}