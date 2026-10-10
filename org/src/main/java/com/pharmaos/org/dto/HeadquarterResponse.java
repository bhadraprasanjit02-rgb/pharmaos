package com.pharmaos.org.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class HeadquarterResponse {

    private UUID id;

    private String hqCode;
    private String hqName;

    private UUID territoryId;
    private String territoryCode;
    private String territoryName;

    private String state;
    private String district;
    private String city;
    private String pincode;
    private String description;
}