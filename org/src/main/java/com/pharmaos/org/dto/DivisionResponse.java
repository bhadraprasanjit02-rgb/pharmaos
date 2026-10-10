package com.pharmaos.org.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class DivisionResponse {

    private UUID id;

    private String divisionCode;

    private String divisionName;

    private UUID businessUnitId;

    private String businessUnitCode;

    private String businessUnitName;

    private String description;

    private String status;
}