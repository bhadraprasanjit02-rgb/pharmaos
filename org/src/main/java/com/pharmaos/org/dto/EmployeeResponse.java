package com.pharmaos.org.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class EmployeeResponse {

    private UUID id;

    private String employeeCode;

    private String firstName;

    private String lastName;

    private String gender;

    private LocalDate dateOfBirth;

    private String mobile;

    private String email;

    private LocalDate joiningDate;

    private String employeeType;

    private String employmentStatus;

    private UUID companyId;
    private String companyName;

    private UUID businessUnitId;
    private String businessUnitName;

    private UUID divisionId;
    private String divisionName;

    private UUID regionId;
    private String regionName;

    private UUID territoryId;
    private String territoryName;

    private UUID headquarterId;
    private String headquarterName;

    private UUID departmentId;
    private String departmentName;

    private UUID designationId;
    private String designationName;

    private UUID reportingManagerId;
    private String reportingManagerName;

    private UUID userId;
}