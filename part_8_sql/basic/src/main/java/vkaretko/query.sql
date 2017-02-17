-- select all items in October 2016
SELECT i.item_id, i.date, s.stat_name, c.cat_name, u.login FROM items AS i 
INNER JOIN statuses AS s ON i.stat_id = s.stat_id
INNER JOIN category AS c ON i.cat_id = c.cat_id
INNER JOIN users AS u ON i.user_id = u.user_id 
WHERE i.date BETWEEN '2016-10-01 00:00:00' AND '2016-11-01 00:00:00';

--select all comments for item with id 1
SELECT c.comment, i.item_id, i.date, u.login FROM comments AS c
INNER JOIN items AS i ON c.item_id = i.item_id
INNER JOIN users AS u ON i.user_id = u.user_id
WHERE c.item_id = 1;