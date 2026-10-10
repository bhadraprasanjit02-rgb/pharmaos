package com.pharmaos.iam.repository;

import com.pharmaos.iam.entity.User;
import com.pharmaos.iam.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UserRoleRepository extends JpaRepository<UserRole, UUID> {

    List<UserRole> findByUser(User user);
}