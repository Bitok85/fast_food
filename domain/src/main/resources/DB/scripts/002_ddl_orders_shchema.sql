CREATE TABLE IF NOT EXISTS orders (
    id SERIAL PRIMARY KEY,
    address TEXT NOT NULL,
    amount FLOAT NOT NULL,
    customer_id INT REFERENCES customers(id) NOT NULL,
    courier_id INT REFERENCES  couriers(id),
    card_id INT REFERENCES cards(id),
    status TEXT,
    created_at TIMESTAMP
);