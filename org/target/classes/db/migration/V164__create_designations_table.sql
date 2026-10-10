CREATE TABLE designations
(
    id UUID PRIMARY KEY,

    designation_code VARCHAR(30) NOT NULL UNIQUE,
    designation_name VARCHAR(150) NOT NULL UNIQUE,

    hierarchy_level INT NOT NULL,

    parent_designation_id UUID,

    is_manager BOOLEAN NOT NULL DEFAULT FALSE,

    is_field_force BOOLEAN NOT NULL DEFAULT FALSE,

    is_sales_role BOOLEAN NOT NULL DEFAULT FALSE,

    description VARCHAR(500),

    created_at TIMESTAMP NOT NULL,
    created_by VARCHAR(100),

    updated_at TIMESTAMP,
    updated_by VARCHAR(100),

    is_active BOOLEAN NOT NULL DEFAULT TRUE,

    version BIGINT,

    CONSTRAINT fk_designation_parent
        FOREIGN KEY(parent_designation_id)
        REFERENCES designations(id)
);