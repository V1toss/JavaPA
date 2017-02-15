INSERT INTO roles(role_name) values ('administrator');

INSERT INTO rights(right_name, role_id) values ('full', 1);

INSERT INTO users(login, password, create_date, role_id) values ('admin', '1234', '2016-01-08 04:05:06', 1);

INSERT INTO category(cat_name) values ('task');

INSERT INTO statuses(stat_name) values ('new');

INSERT INTO items(date, stat_id, cat_id, user_id) values('2016-10-10 11:05:06', 1, 1, 1); 

INSERT INTO comments(comment, item_id) values('test comment', 1);

INSERT INTO att_files(file_path, item_id) values('c:\file.txt', 1);
