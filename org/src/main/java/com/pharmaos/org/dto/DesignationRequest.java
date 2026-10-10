package com.pharmaos.org.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class DesignationRequest {

    @NotBlank
    private String designationCode;

    @NotBlank
    private String designationName;

    @NotNull
    private Integer hierarchyLevel;

    private UUID parentDesignationId;

    private Boolean isManager;

    private Boolean isFieldForce;

    private Boolean isSalesRole;

    private String description;
}