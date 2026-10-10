CREATE TABLE departments
(
    id UUID PRIMARY KEY,

    department_code VARCHAR(30) NOT NULL UNIQUE,
    department_name VARCHAR(150) NOT NULL UNIQUE,

    description VARCHAR(500),

    created_at TIMESTAMP NOT NULL,
    created_by VARCHAR(100),
    updated_at TIMESTAMP,
    updated_by VARCHAR(100),
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    version BIGINT
);