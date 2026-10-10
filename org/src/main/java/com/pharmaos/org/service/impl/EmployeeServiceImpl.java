package com.pharmaos.org.service.impl;

import com.pharmaos.org.dto.EmployeeRequest;
import com.pharmaos.org.dto.EmployeeResponse;
import com.pharmaos.org.entity.*;
import com.pharmaos.org.mapper.EmployeeMapper;
import com.pharmaos.org.repository.*;
import com.pharmaos.org.service.EmployeeService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
@Service
@RequiredArgsConstructor
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    
private final EmployeeRepository employeeRepository;
private final CompanyRepository companyRepository;
private final BusinessUnitRepository businessUnitRepository;
private final DivisionRepository divisionRepository;
private final RegionRepository regionRepository;
private final TerritoryRepository territoryRepository;
private final HeadquarterRepository headquarterRepository;
private final DepartmentRepository departmentRepository;
private final DesignationRepository designationRepository;
private final EmployeeMapper employeeMapper;

    @Override
    public EmployeeResponse create(EmployeeRequest request) {

        if (employeeRepository.existsByEmployeeCode(request.getEmployeeCode())) {
            throw new RuntimeException("Employee code already exists.");
        }

        if (request.getEmail() != null &&
                employeeRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Employee email already exists.");
        }

        Company company = companyRepository.findById(request.getCompanyId())
                .orElseThrow(() -> new RuntimeException("Company not found."));

        BusinessUnit businessUnit = businessUnitRepository.findById(request.getBusinessUnitId())
                .orElseThrow(() -> new RuntimeException("Business Unit not found."));

        Division division = divisionRepository.findById(request.getDivisionId())
                .orElseThrow(() -> new RuntimeException("Division not found."));

        Region region = regionRepository.findById(request.getRegionId())
                .orElseThrow(() -> new RuntimeException("Region not found."));

        Territory territory = territoryRepository.findById(request.getTerritoryId())
                .orElseThrow(() -> new RuntimeException("Territory not found."));

        Headquarter headquarter = headquarterRepository.findById(request.getHeadquarterId())
                .orElseThrow(() -> new RuntimeException("Headquarter not found."));

        Department department = departmentRepository.findById(request.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department not found."));

        Designation designation = designationRepository.findById(request.getDesignationId())
                .orElseThrow(() -> new RuntimeException("Designation not found."));

        Employee reportingManager = null;

        if (request.getReportingManagerId() != null) {
            reportingManager = employeeRepository.findById(request.getReportingManagerId())
                    .orElseThrow(() -> new RuntimeException("Reporting Manager not found."));
        }

        Employee employee = employeeMapper.toEntity(
                request,
                company,
                businessUnit,
                division,
                region,
                territory,
                headquarter,
                department,
                designation,
                reportingManager
        );

        employee = employeeRepository.save(employee);

        return employeeMapper.toResponse(employee);
    }
     @Override
    public EmployeeResponse update(UUID id, EmployeeRequest request) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found."));

        if (!employee.getEmployeeCode().equals(request.getEmployeeCode())
                && employeeRepository.existsByEmployeeCode(request.getEmployeeCode())) {

            throw new RuntimeException("Employee code already exists.");
        }

        if (request.getEmail() != null
                && !request.getEmail().equalsIgnoreCase(employee.getEmail())
                && employeeRepository.existsByEmail(request.getEmail())) {

            throw new RuntimeException("Employee email already exists.");
        }

        Company company = companyRepository.findById(request.getCompanyId())
                .orElseThrow(() -> new RuntimeException("Company not found."));

        BusinessUnit businessUnit = businessUnitRepository.findById(request.getBusinessUnitId())
                .orElseThrow(() -> new RuntimeException("Business Unit not found."));

        Division division = divisionRepository.findById(request.getDivisionId())
                .orElseThrow(() -> new RuntimeException("Division not found."));

        Region region = regionRepository.findById(request.getRegionId())
                .orElseThrow(() -> new RuntimeException("Region not found."));

        Territory territory = territoryRepository.findById(request.getTerritoryId())
                .orElseThrow(() -> new RuntimeException("Territory not found."));

        Headquarter headquarter = headquarterRepository.findById(request.getHeadquarterId())
                .orElseThrow(() -> new RuntimeException("Headquarter not found."));

        Department department = departmentRepository.findById(request.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department not found."));

        Designation designation = designationRepository.findById(request.getDesignationId())
                .orElseThrow(() -> new RuntimeException("Designation not found."));

        Employee reportingManager = null;

        if (request.getReportingManagerId() != null) {

            reportingManager = employeeRepository.findById(request.getReportingManagerId())
                    .orElseThrow(() ->
                            new RuntimeException("Reporting Manager not found."));
        }

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

        employee = employeeRepository.save(employee);

        return employeeMapper.toResponse(employee);
    }

    @Override
    @Transactional(readOnly = true)
    public EmployeeResponse getById(UUID id) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Employee not found."));

        return employeeMapper.toResponse(employee);
    }
        @Override
    @Transactional(readOnly = true)
    public List<EmployeeResponse> getAll() {

        return employeeRepository.findAll()
                .stream()
                .map(employeeMapper::toResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<EmployeeResponse> getByHeadquarter(UUID headquarterId) {

        Headquarter headquarter = headquarterRepository.findById(headquarterId)
                .orElseThrow(() ->
                        new RuntimeException("Headquarter not found."));

        return employeeRepository.findByHeadquarter(headquarter)
                .stream()
                .map(employeeMapper::toResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<EmployeeResponse> getByReportingManager(UUID managerId) {

        Employee manager = employeeRepository.findById(managerId)
                .orElseThrow(() ->
                        new RuntimeException("Reporting Manager not found."));

        return employeeRepository.findByReportingManager(manager)
                .stream()
                .map(employeeMapper::toResponse)
                .toList();
    }

    @Override
    public void delete(UUID id) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Employee not found."));

        employeeRepository.delete(employee);
    }
}