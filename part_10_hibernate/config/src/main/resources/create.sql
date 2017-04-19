CREATE DATABASE tracker;

CREATE TABLE items (
    id serial PRIMARY KEY,
    description VARCHAR(255),
    done BOOLEAN DEFAULT FALSE,
    create_date TIMESTAMP
);