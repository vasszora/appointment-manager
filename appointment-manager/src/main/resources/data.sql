insert into users(username, email) values ('username1', 'username1@gmail.com');
insert into users(username, email) values ('username2', 'username2@gmail.com');
insert into users(username, email) values ('username3', 'username3@gmail.com');
insert into users(username, email) values ('username4', 'username4@gmail.com');
insert into users(username, email) values ('username5', 'username5@gmail.com');
insert into users(username, email) values ('Hairdresser_Harry', 'hair_rules@gmail.com');
insert into users(username, email) values ('Dentist_Diana', 'i_like_teeth@freemail.com');
insert into users(username, email) values ('Yoga_Teacher_Yolanda', 'yoga_above_everything@citromail.com');

insert into appointment(startTime, duration, price, description, maxBookings, provider) values(to_timestamp('2022-12-19 19:00','YYYY-MM-DD HH24:mimi'), 120, 5000, 'Hairdresser: cut and color', 1, (select id from users where username = 'Hairdresser_Harry'));
insert into appointment(startTime, duration, price, description, maxBookings, provider) values(to_timestamp('2022-12-20 10:00','YYYY-MM-DD HH24:mimi'), 60, 10000, 'Teeth whitening', 1, (select id from users where username = 'Dentist_Diana'));
insert into appointment(startTime, duration, price, description, maxBookings, provider) values(to_timestamp('2022-12-20 11:00','YYYY-MM-DD HH24:mimi'), 60, 10000, 'Teeth whitening', 1, (select id from users where username = 'Dentist_Diana'));
insert into appointment(startTime, duration, price, description, maxBookings, provider) values(to_timestamp('2022-12-12 17:30','YYYY-MM-DD HH24:mimi'), 90, 3000, 'Yoga flow', 5, (select id from users where username = 'Yoga_Teacher_Yolanda'));
insert into appointment(startTime, duration, price, description, maxBookings, provider) values(to_timestamp('2022-12-14 18:30','YYYY-MM-DD HH24:mimi'), 90, 3000, 'Yoga flow', 5, (select id from users where username = 'Yoga_Teacher_Yolanda'));

insert into booking(client_id, appointment_id) values((select id from users where username = 'username2'), (select id from appointment where description = 'Teeth whitening' and starttime = to_timestamp('2022-12-20 10:00','YYYY-MM-DD HH24:mimi')));
insert into booking(client_id, appointment_id) values((select id from users where username = 'username3'), (select id from appointment where description = 'Yoga flow' and starttime = to_timestamp('2022-12-12 17:30','YYYY-MM-DD HH24:mimi')));
insert into booking(client_id, appointment_id) values((select id from users where username = 'username4'), (select id from appointment where description = 'Yoga flow' and starttime = to_timestamp('2022-12-12 17:30','YYYY-MM-DD HH24:mimi')));
insert into booking(client_id, appointment_id) values((select id from users where username = 'username5'), (select id from appointment where description = 'Yoga flow' and starttime = to_timestamp('2022-12-12 17:30','YYYY-MM-DD HH24:mimi')));
insert into booking(client_id, appointment_id) values((select id from users where username = 'username1'), (select id from appointment where description = 'Yoga flow' and starttime = to_timestamp('2022-12-14 18:30','YYYY-MM-DD HH24:mimi')));
