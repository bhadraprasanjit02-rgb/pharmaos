package com.pharmaos.org.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class DivisionRequest {

    @NotBlank
    private String divisionCode;

    @NotBlank
    private String divisionName;

    @NotNull
    private UUID businessUnitId;

    private String description;
}