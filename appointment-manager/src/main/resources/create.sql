CREATE TABLE "users" (
id INTEGER NOT NULL PRIMARY KEY auto_increment,
username VARCHAR(100),
email VARCHAR(100),
CONSTRAINT username_unique UNIQUE (username)
);

CREATE TABLE "appointment" ( 
id INTEGER NOT NULL PRIMARY KEY auto_increment,
start_time TIMESTAMP,
duration INTEGER,
price INTEGER,
description VARCHAR(100),
user_id INTEGER,
CONSTRAINT fk_users_appointment
      FOREIGN KEY(user_id)
        REFERENCES users(id)
);

CREATE TABLE "booking" ( 
id INTEGER NOT NULL PRIMARY KEY auto_increment,
client_id INTEGER,
CONSTRAINT fk_users_appointment
      FOREIGN KEY(client_id)
        REFERENCES users(id),
appointment_id INTEGER,
CONSTRAINT fk_appointment_booking
      FOREIGN KEY(appointment_id)
        REFERENCES appointment(id)
);

create sequence hibernate_sequence;
