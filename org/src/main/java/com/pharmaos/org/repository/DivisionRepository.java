package com.pharmaos.org.repository;

import com.pharmaos.org.entity.BusinessUnit;
import com.pharmaos.org.entity.Division;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DivisionRepository extends JpaRepository<Division, UUID> {

    boolean existsByBusinessUnitAndDivisionCode(
            BusinessUnit businessUnit,
            String divisionCode
    );

    boolean existsByBusinessUnitAndDivisionName(
            BusinessUnit businessUnit,
            String divisionName
    );

    List<Division> findByBusinessUnitId(UUID businessUnitId);

    Optional<Division> findByDivisionCode(String divisionCode);
}