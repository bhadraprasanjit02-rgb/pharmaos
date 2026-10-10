package com.pharmaos.org.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class DesignationResponse {

    private UUID id;

    private String designationCode;

    private String designationName;

    private Integer hierarchyLevel;

    private UUID parentDesignationId;

    private String parentDesignationName;

    private Boolean isManager;

    private Boolean isFieldForce;

    private Boolean isSalesRole;

    private String description;
}