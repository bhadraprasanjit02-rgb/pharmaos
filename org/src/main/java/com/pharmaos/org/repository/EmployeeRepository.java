package com.pharmaos.org.repository;

import com.pharmaos.org.entity.Employee;
import com.pharmaos.org.entity.Headquarter;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {

    boolean existsByEmployeeCode(String employeeCode);

    boolean existsByEmail(String email);

    Optional<Employee> findByEmployeeCode(String employeeCode);

    @EntityGraph(attributePaths = {
            "company",
            "businessUnit",
            "division",
            "region",
            "territory",
            "headquarter",
            "department",
            "designation",
            "reportingManager"
    })
    List<Employee> findAll();

    @EntityGraph(attributePaths = {
            "company",
            "businessUnit",
            "division",
            "region",
            "territory",
            "headquarter",
            "department",
            "designation",
            "reportingManager"
    })
    Optional<Employee> findById(UUID id);

    List<Employee> findByHeadquarter(Headquarter headquarter);

    List<Employee> findByReportingManager(Employee manager);
}