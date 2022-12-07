insert into users(username, email) values ('username1', 'username1@gmail.com');
insert into users(username, email) values ('username2', 'username2@gmail.com');
insert into users(username, email) values ('username3', 'username3@gmail.com');
insert into users(username, email) values ('Hairdresser_Harry', 'hair_rules@gmail.com');
insert into users(username, email) values ('Dentist_Diana', 'i_like_teeth@freemail.com');
insert into users(username, email) values ('Yoga_Teacher_Yolanda', 'yoga_above_everything@citromail.com');


insert into appointment(start_time, duration, price, description, provider) values(parsedatetime('2022-12-19 19:00','YYYY-MM-DD HH:mm'), 120, 5000, 'Hairdresser: cut and color', (select id from users where username = 'Hairdresser_Harry'));
insert into appointment(start_time, duration, price, description, provider) values(parsedatetime('2022-12-20 10:00','YYYY-MM-DD HH:mm'), 60, 10000, 'Teeth whitening', (select id from users where username = 'Dentist_Diana'));
insert into appointment(start_time, duration, price, description, provider) values(parsedatetime('2022-12-20 11:00','YYYY-MM-DD HH:mm'), 60, 10000, 'Teeth whitening', (select id from users where username = 'Dentist_Diana'));
insert into appointment(start_time, duration, price, description, provider) values(parsedatetime('2022-12-12 17:30','YYYY-MM-DD HH:mm'), 90, 3000, 'Yoga flow', (select id from users where username = 'Yoga_Teacher_Yolanda'));
insert into appointment(start_time, duration, price, description, provider) values(parsedatetime('2022-12-14 18:30','YYYY-MM-DD HH:mm'), 90, 3000, 'Yoga flow', (select id from users where username = 'Yoga_Teacher_Yolanda'));

insert into booking(client_id, appointment_id) values((select id from users where username = 'username2'), (select id from appointment where provider = (select id from users where username = 'username1')));
insert into booking(client_id, appointment_id) values((select id from users where username = 'username3'), (select id from appointment where provider = (select id from users where username = 'username1')));