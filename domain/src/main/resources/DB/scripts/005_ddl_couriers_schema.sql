CREATE TABLE IF NOT EXISTS couriers (
    id SERIAL PRIMARY KEY,
    name_ TEXT NOT NULL,
    surname TEXT NOT NULL,
    phone_number INT NOT NULL UNIQUE
);

ALTER TABLE couriers ADD authority_id INT REFERENCES authorities(id);

