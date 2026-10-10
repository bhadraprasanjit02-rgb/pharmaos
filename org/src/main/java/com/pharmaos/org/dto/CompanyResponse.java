package com.pharmaos.org.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class CompanyResponse {

    private UUID id;

    private String companyCode;

    private String companyName;

    private String legalName;

    private String gstNumber;

    private String panNumber;

    private String cinNumber;

    private String email;

    private String phone;

    private String website;

    private String country;

    private String state;

    private String city;

    private String address;

    private String postalCode;

    private String status;
}