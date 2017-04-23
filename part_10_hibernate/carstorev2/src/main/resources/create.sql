CREATE DATABASE carstore;

CREATE TABLE body (
    id serial PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE engine (
    id serial PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE drive (
    id serial PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE brand (
    id serial PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE model (
    id serial PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE,
    id_brand INTEGER REFERENCES brand(id) NOT NULL
);

CREATE TABLE transmission (
    id serial PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE users (
    id serial PRIMARY KEY,
    login VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    phone VARCHAR(255),
    email VARCHAR(255)
);

CREATE TABLE cars (
    id serial PRIMARY KEY,
    engine_power INTEGER,
    year INTEGER,
    color VARCHAR(255),
    mileage INTEGER,
    id_body INTEGER REFERENCES body(id) NOT NULL,
    id_drive INTEGER REFERENCES drive(id) NOT NULL,
    id_engine INTEGER REFERENCES engine(id) NOT NULL,
    id_model INTEGER REFERENCES model(id) NOT NULL,
    id_transmission INTEGER REFERENCES transmission(id) NOT NULL
);

CREATE TABLE orders (
    id serial PRIMARY KEY,
    description VARCHAR(255),
    price INTEGER,
    sold BOOLEAN,
    date TIMESTAMP DEFAULT now(),
    id_car  INTEGER REFERENCES cars(id) NOT NULL,
    id_user INTEGER REFERENCES users(id) NOT NULL
);

CREATE TABLE images (
    id serial PRIMARY KEY,
    url VARCHAR(255),
    id_order INTEGER REFERENCES orders(id) NOT NULL
);

--fill body table
INSERT INTO body (name) VALUES('hatchback');
INSERT INTO body (name) VALUES('sedan');
INSERT INTO body (name) VALUES('jeep');

--fill brand table
INSERT INTO brand(name) VALUES('Audi');
INSERT INTO brand(name) VALUES('BMW');
INSERT INTO brand(name) VALUES('Skoda');

--fill model table
INSERT INTO model(name, id_brand) VALUES('A4', 1);
INSERT INTO model(name, id_brand) VALUES('A6', 1);
INSERT INTO model(name, id_brand) VALUES('325', 2);
INSERT INTO model(name, id_brand) VALUES('X6', 2);
INSERT INTO model(name, id_brand) VALUES('X5', 2);
INSERT INTO model(name, id_brand) VALUES('Superb', 3);
INSERT INTO model(name, id_brand) VALUES('Rapid', 3);
INSERT INTO model(name, id_brand) VALUES('Octavia', 3);

--fill engine table
INSERT INTO engine(name) VALUES ('petrol');
INSERT INTO engine(name) VALUES ('diesel');
INSERT INTO engine(name) VALUES ('hybrid');

--fill transmission table
INSERT INTO transmission(name) VALUES ('mechanical');
INSERT INTO transmission(name) VALUES ('automat');
INSERT INTO transmission(name) VALUES ('robot');

--fill drive table
INSERT INTO drive(name) VALUES ('front');
INSERT INTO drive(name) VALUES ('back');
INSERT INTO drive(name) VALUES ('full');