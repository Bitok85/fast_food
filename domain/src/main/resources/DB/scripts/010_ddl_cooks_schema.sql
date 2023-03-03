CREATE TABLE IF NOT EXISTS cooks (
    id SERIAL PRIMARY KEY,
    login TEXT NOT NULL UNIQUE,
    password TEXT NOT NULL,
    authority_id INT REFERENCES authorities(id)
);

