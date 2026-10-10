package com.pharmaos.org.repository;

import com.pharmaos.org.entity.Division;
import com.pharmaos.org.entity.Region;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface RegionRepository extends JpaRepository<Region, UUID> {

    boolean existsByDivisionAndRegionCode(
            Division division,
            String regionCode
    );

    boolean existsByDivisionAndRegionName(
            Division division,
            String regionName
    );

    @EntityGraph(attributePaths = "division")
    List<Region> findByDivisionId(UUID divisionId);

    @Override
    @EntityGraph(attributePaths = "division")
    List<Region> findAll();

    @Override
    @EntityGraph(attributePaths = "division")
    java.util.Optional<Region> findById(UUID id);
}