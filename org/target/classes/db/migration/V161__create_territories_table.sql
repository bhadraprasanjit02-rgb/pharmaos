CREATE TABLE territories
(
    id UUID PRIMARY KEY,

    territory_code VARCHAR(30) NOT NULL,
    territory_name VARCHAR(200) NOT NULL,

    region_id UUID NOT NULL,

    description VARCHAR(500),

    status VARCHAR(20) NOT NULL DEFAULT 'ACTIVE',

    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP,
    created_by UUID,
    updated_by UUID,
    version BIGINT,

    CONSTRAINT fk_territory_region
        FOREIGN KEY (region_id)
        REFERENCES regions(id),

    CONSTRAINT uk_territory_code
        UNIQUE (region_id, territory_code),

    CONSTRAINT uk_territory_name
        UNIQUE (region_id, territory_name)
);