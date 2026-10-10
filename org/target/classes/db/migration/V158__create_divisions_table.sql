CREATE TABLE divisions
(
    id UUID PRIMARY KEY,

    division_code VARCHAR(30) NOT NULL,
    division_name VARCHAR(200) NOT NULL,

    business_unit_id UUID NOT NULL,

    description VARCHAR(500),

    status VARCHAR(20) NOT NULL DEFAULT 'ACTIVE',

    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP,
    created_by UUID,
    updated_by UUID,
    version BIGINT,

    CONSTRAINT fk_division_business_unit
        FOREIGN KEY (business_unit_id)
        REFERENCES business_units(id),

    CONSTRAINT uk_division_code
        UNIQUE (business_unit_id, division_code),

    CONSTRAINT uk_division_name
        UNIQUE (business_unit_id, division_name)
);