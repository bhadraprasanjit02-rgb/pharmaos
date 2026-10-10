package com.pharmaos.org.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class EmployeeRequest {

    @NotBlank
    private String employeeCode;

    @NotBlank
    private String firstName;

    private String lastName;

    private String gender;

    private LocalDate dateOfBirth;

    private String mobile;

    @Email
    private String email;

    @NotNull
    private LocalDate joiningDate;

    private String employeeType;

    private String employmentStatus;

    @NotNull
    private UUID companyId;

    @NotNull
    private UUID businessUnitId;

    @NotNull
    private UUID divisionId;

    @NotNull
    private UUID regionId;

    @NotNull
    private UUID territoryId;

    @NotNull
    private UUID headquarterId;

    @NotNull
    private UUID departmentId;

    @NotNull
    private UUID designationId;

    private UUID reportingManagerId;

    private UUID userId;
}