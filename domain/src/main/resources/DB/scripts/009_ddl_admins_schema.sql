CREATE TABLE IF NOT EXISTS admins (
    id SERIAL PRIMARY KEY,
    login VARCHAR NOT NULL UNIQUE,
    password TEXT NOT NULL,
    authority_id int REFERENCES authorities(id)
);

