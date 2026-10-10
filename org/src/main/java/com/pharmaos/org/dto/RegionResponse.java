package com.pharmaos.org.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class RegionResponse {

    private UUID id;

    private String regionCode;

    private String regionName;

    private UUID divisionId;

    private String divisionCode;

    private String divisionName;

    private String description;

    private String status;
}