package com.pharmaos.org.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DepartmentRequest {

    @NotBlank
    private String departmentCode;

    @NotBlank
    private String departmentName;

    private String description;
}