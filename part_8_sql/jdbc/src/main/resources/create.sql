CREATE DATABASE tracker;

CREATE TABLE items (
    item_id serial PRIMARY KEY,
    name VARCHAR(255),
    desc TEXT,
    create_date TIMESTAMP
);

CREATE TABLE comments (
    comment_id serial PRIMARY KEY,
    comment  TEXT,
    item_id INTEGER REFERENCES items(item_id)
);