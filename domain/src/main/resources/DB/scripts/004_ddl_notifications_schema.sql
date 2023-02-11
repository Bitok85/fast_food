CREATE TABLE IF NOT EXISTS notifications (
    id SERIAL PRIMARY KEY,
    order_number INT NOT NULL,
    status TEXT NOT NULL,
    message TEXT,
    order_created_at TIMESTAMP
);