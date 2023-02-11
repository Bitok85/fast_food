CREATE TABLE IF NOT EXISTS dishes_orders (
    dish_id INT REFERENCES dishes(id),
    order_id INT REFERENCES orders(id)
);