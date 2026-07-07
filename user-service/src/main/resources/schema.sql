CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE app_users (
                           user_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),

                           username VARCHAR(100) NOT NULL UNIQUE,
                           email VARCHAR(255) NOT NULL UNIQUE,

                           first_name VARCHAR(100) NOT NULL,
                           last_name VARCHAR(100) NOT NULL,

                           password VARCHAR(255) NOT NULL,

                           is_verified BOOLEAN NOT NULL DEFAULT FALSE,
                           profile_image TEXT,

                           created_at TIMESTAMP NOT NULL DEFAULT NOW()
);