CREATE DATABASE java_a_from_z;

CREATE TABLE roles (
    role_id serial PRIMARY KEY,
    role_name CHARACTER VARYING (200)
);

CREATE TABLE rights (
    right_id serial PRIMARY KEY,
    right_name CHARACTER VARYING (200),
    role_id INTEGER REFERENCES roles(role_id)
);
CREATE TABLE users (
    user_id serial PRIMARY KEY,
    login CHARACTER VARYING (200),
    password CHARACTER VARYING (200),
    create_date TIMESTAMP,
    role_id INTEGER REFERENCES roles(role_id)
);

CREATE TABLE category (
    cat_id serial PRIMARY KEY,
    cat_name  CHARACTER VARYING (200)
);

CREATE TABLE statuses (
    stat_id serial PRIMARY KEY,
    stat_name CHARACTER VARYING (200)
);

CREATE TABLE items (
    item_id serial PRIMARY KEY,
    date TIMESTAMP,
    stat_id INTEGER REFERENCES statuses(stat_id),
    cat_id INTEGER REFERENCES category(cat_id),    
    user_id INTEGER REFERENCES users(user_id)
);

CREATE TABLE comments (
    comment_id serial PRIMARY KEY,
    comment  CHARACTER VARYING (1000),
    item_id INTEGER REFERENCES items(item_id)
);

CREATE TABLE att_files (
    file_id serial PRIMARY KEY,
    file_path  CHARACTER VARYING (1000),
    item_id INTEGER REFERENCES items(item_id)
);