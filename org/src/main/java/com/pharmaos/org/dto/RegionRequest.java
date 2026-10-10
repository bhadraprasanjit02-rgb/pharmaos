package com.pharmaos.org.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class RegionRequest {

    @NotBlank
    private String regionCode;

    @NotBlank
    private String regionName;

    @NotNull
    private UUID divisionId;

    private String description;
}