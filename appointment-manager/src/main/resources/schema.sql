insert into users(username, email) values ('username1', 'username1@gmail.com');
insert into users(username, email) values ('username2', 'username2@gmail.com');
insert into users(username, email) values ('username3', 'username3@gmail.com');

insert into appointment(start_time, duration, price, description, user_id) values(parsedatetime('2022-11-20 19:00:00','YYYY-MM-DD HH:mm:ss'), 120, 100, 'Hairdresser: cut and color', (select id from users where username = 'username1'));

insert into booking(client_id, appointment_id) values((select id from users where username = 'username2'), (select id from appointment where user_id = (select id from users where username = 'username1')));
insert into booking(client_id, appointment_id) values((select id from users where username = 'username3'), (select id from appointment where user_id = (select id from users where username = 'username1')));