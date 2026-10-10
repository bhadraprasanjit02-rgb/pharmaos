CREATE TABLE headquarters
(
    id UUID PRIMARY KEY,

    hq_code VARCHAR(30) NOT NULL,
    hq_name VARCHAR(200) NOT NULL,

    territory_id UUID NOT NULL,

    state VARCHAR(100),
    district VARCHAR(100),
    city VARCHAR(100),
    pincode VARCHAR(10),

    description VARCHAR(500),

    created_at TIMESTAMP NOT NULL,
    created_by VARCHAR(100),
    updated_at TIMESTAMP,
    updated_by VARCHAR(100),
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    version BIGINT,

    CONSTRAINT fk_hq_territory
        FOREIGN KEY (territory_id)
        REFERENCES territories(id),

    CONSTRAINT uk_hq_code
        UNIQUE (territory_id, hq_code),

    CONSTRAINT uk_hq_name
        UNIQUE (territory_id, hq_name)
);