CREATE DATABASE store;

CREATE TABLE users (
    user_id serial PRIMARY KEY,
    login VARCHAR(255) UNIQUE,
    name VARCHAR(255),
    email VARCHAR(255),
    create_date TIMESTAMP,
    password VARCHAR(255),
    role_id INTEGER REFERENCES roles(role_id)
);

CREATE TABLE roles (
    role_id serial PRIMARY KEY,
    name VARCHAR(255)
);