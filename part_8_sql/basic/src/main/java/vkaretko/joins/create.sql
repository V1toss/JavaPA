CREATE TABLE transmissions (
   id serial PRIMARY KEY,
   brand VARCHAR(200),
   type VARCHAR(200)
);

CREATE TABLE gearboxes (
   id serial PRIMARY KEY,
   brand VARCHAR(200),
   type VARCHAR(200)
);

CREATE TABLE engines (
   id serial PRIMARY KEY,
   brand VARCHAR(200),
   type VARCHAR(200)
);

CREATE TABLE cars (
   id serial PRIMARY KEY,
   brand VARCHAR(200),
   transm_id INTEGER REFERENCES transmissions(id),
   gearbox_id INTEGER REFERENCES gearboxes(id),
   engine_id INTEGER REFERENCES engines(id)
);