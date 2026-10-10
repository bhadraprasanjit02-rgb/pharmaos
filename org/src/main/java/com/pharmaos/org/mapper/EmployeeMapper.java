package com.pharmaos.org.mapper;

import com.pharmaos.org.dto.EmployeeRequest;
import com.pharmaos.org.dto.EmployeeResponse;
import com.pharmaos.org.entity.*;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public Employee toEntity(
            EmployeeRequest request,
            Company company,
            BusinessUnit businessUnit,
            Division division,
            Region region,
            Territory territory,
            Headquarter headquarter,
            Department department,
            Designation designation,
            Employee reportingManager
    ) {

        Employee employee = new Employee();

        employee.setEmployeeCode(request.getEmployeeCode());
        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());
        employee.setGender(request.getGender());
        employee.setDateOfBirth(request.getDateOfBirth());
        employee.setMobile(request.getMobile());
        employee.setEmail(request.getEmail());
        employee.setJoiningDate(request.getJoiningDate());
        employee.setEmployeeType(request.getEmployeeType());
        employee.setEmploymentStatus(request.getEmploymentStatus());

        employee.setCompany(company);
        employee.setBusinessUnit(businessUnit);
        employee.setDivision(division);
        employee.setRegion(region);
        employee.setTerritory(territory);
        employee.setHeadquarter(headquarter);
        employee.setDepartment(department);
        employee.setDesignation(designation);
        employee.setReportingManager(reportingManager);

        employee.setUserId(request.getUserId());

        return employee;
    }

    public EmployeeResponse toResponse(Employee employee) {

        EmployeeResponse response = new EmployeeResponse();

        response.setId(employee.getId());
        response.setEmployeeCode(employee.getEmployeeCode());
        response.setFirstName(employee.getFirstName());
        response.setLastName(employee.getLastName());
        response.setGender(employee.getGender());
        response.setDateOfBirth(employee.getDateOfBirth());
        response.setMobile(employee.getMobile());
        response.setEmail(employee.getEmail());
        response.setJoiningDate(employee.getJoiningDate());
        response.setEmployeeType(employee.getEmployeeType());
        response.setEmploymentStatus(employee.getEmploymentStatus());

        response.setCompanyId(employee.getCompany().getId());
        response.setCompanyName(employee.getCompany().getCompanyName());

        response.setBusinessUnitId(employee.getBusinessUnit().getId());
        response.setBusinessUnitName(employee.getBusinessUnit().getBusinessUnitName());

        response.setDivisionId(employee.getDivision().getId());
        response.setDivisionName(employee.getDivision().getDivisionName());

        response.setRegionId(employee.getRegion().getId());
        response.setRegionName(employee.getRegion().getRegionName());

        response.setTerritoryId(employee.getTerritory().getId());
        response.setTerritoryName(employee.getTerritory().getTerritoryName());

        response.setHeadquarterId(employee.getHeadquarter().getId());
        response.setHeadquarterName(employee.getHeadquarter().getHqName());

        response.setDepartmentId(employee.getDepartment().getId());
        response.setDepartmentName(employee.getDepartment().getDepartmentName());

        response.setDesignationId(employee.getDesignation().getId());
        response.setDesignationName(employee.getDesignation().getDesignationName());

        if (employee.getReportingManager() != null) {

            response.setReportingManagerId(
                    employee.getReportingManager().getId());

            response.setReportingManagerName(
                    employee.getReportingManager().getFirstName()
                            + " "
                            + employee.getReportingManager().getLastName());
        }

        response.setUserId(employee.getUserId());

        return response;
    }
}