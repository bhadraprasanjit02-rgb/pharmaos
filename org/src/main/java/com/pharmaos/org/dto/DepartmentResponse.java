package com.pharmaos.org.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class DepartmentResponse {

    private UUID id;

    private String departmentCode;

    private String departmentName;

    private String description;
}