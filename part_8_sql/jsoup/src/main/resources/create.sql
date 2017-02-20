CREATE DATABASE vacancy;

CREATE TABLE offers (
    offer_id serial PRIMARY KEY,
    link TEXT,
    description TEXT,
    last_update TIMESTAMP
);