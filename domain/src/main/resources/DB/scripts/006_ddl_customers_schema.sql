CREATE TABLE IF NOT EXISTS customers (
    id SERIAL PRIMARY KEY,
    name TEXT,
    login TEXT NOT NULL UNIQUE,
    password TEXT NOT NULL,
    authority_id INT REFERENCES authorities(id) NOT NULL,
    birth_date DATE,
    email TEXT NOT NULL UNIQUE,
    phone_number TEXT NOT NULL UNIQUE,
    card_id INT REFERENCES cards(id)
);