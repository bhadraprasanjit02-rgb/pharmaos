CREATE TABLE employees
(
    id UUID PRIMARY KEY,

    employee_code VARCHAR(30) NOT NULL UNIQUE,

    first_name VARCHAR(100) NOT NULL,

    last_name VARCHAR(100),

    gender VARCHAR(20),

    date_of_birth DATE,

    mobile VARCHAR(20),

    email VARCHAR(150) UNIQUE,

    joining_date DATE NOT NULL,

    employee_type VARCHAR(30),

    employment_status VARCHAR(30),

    company_id UUID NOT NULL,

    business_unit_id UUID NOT NULL,

    division_id UUID NOT NULL,

    region_id UUID NOT NULL,

    territory_id UUID NOT NULL,

    headquarter_id UUID NOT NULL,

    department_id UUID NOT NULL,

    designation_id UUID NOT NULL,

    reporting_manager_id UUID,

    user_id UUID,

    created_at TIMESTAMP NOT NULL,

    created_by VARCHAR(100),

    updated_at TIMESTAMP,

    updated_by VARCHAR(100),

    is_active BOOLEAN NOT NULL DEFAULT TRUE,

    version BIGINT,

    CONSTRAINT fk_emp_company
        FOREIGN KEY(company_id)
        REFERENCES companies(id),

    CONSTRAINT fk_emp_bu
        FOREIGN KEY(business_unit_id)
        REFERENCES business_units(id),

    CONSTRAINT fk_emp_division
        FOREIGN KEY(division_id)
        REFERENCES divisions(id),

    CONSTRAINT fk_emp_region
        FOREIGN KEY(region_id)
        REFERENCES regions(id),

    CONSTRAINT fk_emp_territory
        FOREIGN KEY(territory_id)
        REFERENCES territories(id),

    CONSTRAINT fk_emp_headquarter
        FOREIGN KEY(headquarter_id)
        REFERENCES headquarters(id),

    CONSTRAINT fk_emp_department
        FOREIGN KEY(department_id)
        REFERENCES departments(id),

    CONSTRAINT fk_emp_designation
        FOREIGN KEY(designation_id)
        REFERENCES designations(id),

    CONSTRAINT fk_emp_manager
        FOREIGN KEY(reporting_manager_id)
        REFERENCES employees(id)
);