CREATE DATABASE store;

CREATE TABLE users (
    user_id serial PRIMARY KEY,
    name VARCHAR(255),
    login VARCHAR(255) UNIQUE,
    email VARCHAR(255),
    create_date TIMESTAMP
);