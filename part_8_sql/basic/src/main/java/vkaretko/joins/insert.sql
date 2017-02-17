INSERT INTO engines(brand, type) values ('BMW', 'turbo-diesel');
INSERT INTO engines(brand, type) values ('Hyundai', 'gasoline');
INSERT INTO engines(brand, type) values ('Audi', 'gasoline');

INSERT INTO transmissions(brand, type) values ('BMW', 'electromechanical');
INSERT INTO transmissions(brand, type) values ('Hyundai', 'mechanical');
INSERT INTO transmissions(brand, type) values ('Audi', 'hydraulic');

INSERT INTO gearboxes(brand, type) values ('BMW', 'automatical 5-step');
INSERT INTO gearboxes(brand, type) values ('Hyundai', 'mechanical');
INSERT INTO gearboxes(brand, type) values ('Audi', 'automatical 6-step');

INSERT INTO cars (brand, transm_id, gearbox_id, engine_id) values ('BMW', 1, 1, 1);
INSERT INTO cars (brand, transm_id, gearbox_id, engine_id) values ('Audi', 3, 3, 3);