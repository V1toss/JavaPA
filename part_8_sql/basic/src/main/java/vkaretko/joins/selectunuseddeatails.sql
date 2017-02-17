SELECT t.brand, t.type FROM cars AS c
RIGHT OUTER JOIN transmissions AS t ON c.transm_id = t.id WHERE c.transm_id is null;

SELECT e.brand, e.type FROM cars AS c
RIGHT OUTER JOIN engines AS e ON c.engine_id = e.id WHERE c.engine_id is null;

SELECT g.brand, g.type FROM gearboxes AS g
LEFT OUTER JOIN cars AS c ON c.gearbox_id = g.id WHERE c.gearbox_id is null;