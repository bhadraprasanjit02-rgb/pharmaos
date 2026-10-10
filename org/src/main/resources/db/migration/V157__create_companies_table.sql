CREATE TABLE companies
(
    id UUID PRIMARY KEY,

    company_code VARCHAR(30) NOT NULL UNIQUE,
    company_name VARCHAR(200) NOT NULL UNIQUE,
    legal_name VARCHAR(250),

    gst_number VARCHAR(20) UNIQUE,
    pan_number VARCHAR(20) UNIQUE,
    cin_number VARCHAR(30) UNIQUE,

    email VARCHAR(150),
    phone VARCHAR(20),
    website VARCHAR(200),

    country VARCHAR(100) NOT NULL,
    state VARCHAR(100) NOT NULL,
    city VARCHAR(100) NOT NULL,
    address TEXT,
    postal_code VARCHAR(20),

    status VARCHAR(20) NOT NULL DEFAULT 'ACTIVE',

    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP,
    created_by UUID,
    updated_by UUID,
    version BIGINT
);