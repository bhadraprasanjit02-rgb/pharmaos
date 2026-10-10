package com.pharmaos.org.repository;

import com.pharmaos.org.entity.BusinessUnit;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BusinessUnitRepository extends JpaRepository<BusinessUnit, UUID> {

    boolean existsByBusinessUnitCode(String businessUnitCode);

    boolean existsByBusinessUnitName(String businessUnitName);

    Optional<BusinessUnit> findByBusinessUnitCode(String businessUnitCode);

    @Override
    @EntityGraph(attributePaths = "company")
    List<BusinessUnit> findAll();

    @Override
    @EntityGraph(attributePaths = "company")
    Optional<BusinessUnit> findById(UUID id);

    @EntityGraph(attributePaths = "company")
    List<BusinessUnit> findByCompanyId(UUID companyId);
}