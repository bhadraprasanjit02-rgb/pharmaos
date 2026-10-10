package com.pharmaos.org.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CompanyRequest {

    @NotBlank
    private String companyCode;

    @NotBlank
    private String companyName;

    private String legalName;

    private String gstNumber;

    private String panNumber;

    private String cinNumber;

    @Email
    private String email;

    private String phone;

    private String website;

    @NotBlank
    private String country;

    @NotBlank
    private String state;

    @NotBlank
    private String city;

    private String address;

    private String postalCode;
}