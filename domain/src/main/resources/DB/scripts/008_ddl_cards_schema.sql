CREATE TABLE IF NOT EXISTS cards (
    id SERIAL PRIMARY KEY,
    bonus INT NOT NULL UNIQUE,
    begins_at DATE,
    expires_at DATE
);