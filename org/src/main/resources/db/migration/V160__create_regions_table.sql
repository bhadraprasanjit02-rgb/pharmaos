CREATE TABLE regions
(
    id UUID PRIMARY KEY,

    region_code VARCHAR(30) NOT NULL,
    region_name VARCHAR(200) NOT NULL,

    division_id UUID NOT NULL,

    description VARCHAR(500),

    status VARCHAR(20) NOT NULL DEFAULT 'ACTIVE',

    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP,
    created_by UUID,
    updated_by UUID,
    version BIGINT,

    CONSTRAINT fk_region_division
        FOREIGN KEY (division_id)
        REFERENCES divisions(id),

    CONSTRAINT uk_region_code
        UNIQUE (division_id, region_code),

    CONSTRAINT uk_region_name
        UNIQUE (division_id, region_name)
);