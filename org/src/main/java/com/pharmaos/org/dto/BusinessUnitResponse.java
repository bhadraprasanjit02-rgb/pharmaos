package com.pharmaos.org.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class BusinessUnitResponse {

    private UUID id;

    private String businessUnitCode;

    private String businessUnitName;

    private String description;

    private UUID companyId;

    private String companyName;
}