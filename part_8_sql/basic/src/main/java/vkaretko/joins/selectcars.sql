SELECT c.brand, t.brand, t.type, g.brand, g.type, e.brand, e.type FROM cars AS c
LEFT OUTER JOIN transmissions AS t ON c.transm_id = t.id
LEFT OUTER JOIN gearboxes AS g ON c.gearbox_id = g.id
LEFT OUTER JOIN engines AS e ON c.engine_id = e.id;