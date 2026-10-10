package com.pharmaos.org.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class HeadquarterRequest {

    @NotBlank
    private String hqCode;

    @NotBlank
    private String hqName;

    @NotNull
    private UUID territoryId;

    private String state;
    private String district;
    private String city;
    private String pincode;
    private String description;
}