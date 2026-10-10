package com.pharmaos.iam.config;

import com.pharmaos.iam.entity.Permission;
import com.pharmaos.iam.entity.Role;
import com.pharmaos.iam.repository.PermissionRepository;
import com.pharmaos.iam.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;

    @Override
    public void run(String... args) {

        createRole("SUPER_ADMIN");
        createRole("ADMIN");
        createRole("NSM");
        createRole("ZSM");
        createRole("RSM");
        createRole("ASM");
        createRole("ABM");
        createRole("MR");
        createRole("STOCKIST");
        createRole("CNF");

        createPermission("USER_CREATE");
        createPermission("USER_UPDATE");
        createPermission("USER_DELETE");

        createPermission("ROLE_CREATE");
        createPermission("ROLE_UPDATE");
        createPermission("ROLE_DELETE");

        createPermission("PERMISSION_CREATE");
        createPermission("PERMISSION_UPDATE");

        createPermission("DCR_CREATE");
        createPermission("DCR_UPDATE");

        createPermission("ORDER_CREATE");
        createPermission("ORDER_APPROVE");

        createPermission("REPORT_VIEW");

        System.out.println("=====================================");
        System.out.println(" PharmaOS IAM Master Data Loaded ");
        System.out.println("=====================================");
    }

    private void createRole(String name) {

        if (!roleRepository.existsByName(name)) {

            Role role = new Role();
            role.setName(name);

            roleRepository.save(role);
        }
    }

    private void createPermission(String name) {

        if (!permissionRepository.existsByName(name)) {

            Permission permission = new Permission();
            permission.setName(name);

            permissionRepository.save(permission);
        }
    }
}