package com.pharmaos.org.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class BusinessUnitRequest {

    @NotBlank(message = "Business Unit Code is required")
    private String businessUnitCode;

    @NotBlank(message = "Business Unit Name is required")
    private String businessUnitName;

    private String description;

    @NotNull(message = "Company Id is required")
    private UUID companyId;
}