CREATE SEQUENCE IF NOT EXISTS hibernate_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS "users" (
id SERIAL NOT NULL,
username VARCHAR(100) UNIQUE NOT NULL,
email VARCHAR(100),
CONSTRAINT pk_users PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS "appointment" ( 
id SERIAL NOT NULL,
startTime timestamp,
duration INTEGER,
price INTEGER,
description VARCHAR(100),
maxBookings INTEGER,
provider INTEGER,
CONSTRAINT pk_appointment PRIMARY KEY (id),
CONSTRAINT fk_users_appointment
      FOREIGN KEY(provider)
        REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS "booking" ( 
id SERIAL NOT NULL,
client_id INTEGER,
CONSTRAINT fk_users_appointment
      FOREIGN KEY(client_id)
        REFERENCES users(id),
appointment_id INTEGER,
CONSTRAINT pk_booking PRIMARY KEY (id),
CONSTRAINT fk_appointment_booking
      FOREIGN KEY(appointment_id)
        REFERENCES appointment(id)
);

