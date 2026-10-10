package com.pharmaos.org.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class TerritoryResponse {

    private UUID id;

    private String territoryCode;

    private String territoryName;

    private UUID regionId;

    private String regionCode;

    private String regionName;

    private String description;

}