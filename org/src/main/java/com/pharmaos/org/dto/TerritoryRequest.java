package com.pharmaos.org.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class TerritoryRequest {

    @NotBlank
    private String territoryCode;

    @NotBlank
    private String territoryName;

    @NotNull
    private UUID regionId;

    private String description;
}