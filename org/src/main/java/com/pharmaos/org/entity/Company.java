package com.pharmaos.org.entity;

import com.pharmaos.shared.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
    name = "companies",
    uniqueConstraints = {
        @UniqueConstraint(name = "uk_company_code", columnNames = "company_code"),
        @UniqueConstraint(name = "uk_company_name", columnNames = "company_name"),
        @UniqueConstraint(name = "uk_company_gst", columnNames = "gst_number"),
        @UniqueConstraint(name = "uk_company_pan", columnNames = "pan_number"),
        @UniqueConstraint(name = "uk_company_cin", columnNames = "cin_number")
    }
)
@Getter
@Setter
public class Company extends BaseEntity {

    @Column(name = "company_code", nullable = false, length = 30)
    private String companyCode;

    @Column(name = "company_name", nullable = false, length = 200)
    private String companyName;

    @Column(name = "legal_name", length = 250)
    private String legalName;

    @Column(name = "gst_number", length = 20)
    private String gstNumber;

    @Column(name = "pan_number", length = 20)
    private String panNumber;

    @Column(name = "cin_number", length = 30)
    private String cinNumber;

    @Column(length = 150)
    private String email;

    @Column(length = 20)
    private String phone;

    @Column(length = 200)
    private String website;

    @Column(nullable = false, length = 100)
    private String country;

    @Column(nullable = false, length = 100)
    private String state;

    @Column(nullable = false, length = 100)
    private String city;

    @Column(columnDefinition = "TEXT")
    private String address;

    @Column(name = "postal_code", length = 20)
    private String postalCode;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private CompanyStatus status = CompanyStatus.ACTIVE;
}