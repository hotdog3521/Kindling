DROP DATABASE if exists kindling;
CREATE DATABASE kindling;
USE kindling;

CREATE TABLE users
(
gender int not null,
sexualOrientation int not null,
name varchar(255),
username varchar(255) primary key not null,
location varchar(255),
password varchar(255) not null,
age int not null,
intelligence int not null,
start_intel_pref int not null,
finish_intel_pref int not null,
age_pref_start int not null,
age_pref_finish int not null,
city varchar(255),
matches varchar(500),
nos varchar(500),
encountered varchar(500)
);


INSERT INTO users (gender, sexualOrientation, name, username,
location, password, age, intelligence, city,
start_intel_pref, finish_intel_pref,
age_pref_start, age_pref_finish,
matches, nos, encountered) VALUES (1, 0, 'Barbara',
'BMoney', 'Tibet', 'password', 21, 50, 'Lhasa',
40, 80, 20, 30,
'LMoney,MMoney', '', '');

INSERT INTO users (gender, sexualOrientation, name, username,
location, password, age, intelligence, city,
start_intel_pref, finish_intel_pref,
age_pref_start, age_pref_finish,
matches, nos, encountered) VALUES (1, 0, 'Chelsea',
'CMoney', 'Tibet', 'password', 21, 50, 'Lhasa',
40, 80, 20, 30,
'LMoney,MMoney', '', '');

INSERT INTO users (gender, sexualOrientation, name, username,
location, password, age, intelligence, city,
start_intel_pref, finish_intel_pref,
age_pref_start, age_pref_finish,
matches, nos, encountered) VALUES (1, 0, 'Danica',
'DMoney', 'Tibet', 'password', 21, 50, 'Lhasa',
40, 80, 20, 30,
'', '', '');

INSERT INTO users (gender, sexualOrientation, name, username,
location, password, age, intelligence, city,
start_intel_pref, finish_intel_pref,
age_pref_start, age_pref_finish,
matches, nos, encountered) VALUES (1, 0, 'Elanor',
'EMoney', 'Tibet', 'password', 21, 50, 'Lhasa',
40, 80, 20, 30,
'', '', '');

INSERT INTO users (gender, sexualOrientation, name, username,
location, password, age, intelligence, city,
start_intel_pref, finish_intel_pref,
age_pref_start, age_pref_finish,
matches, nos, encountered) VALUES (1, 0, 'Fannie',
'FMoney', 'Tibet', 'password', 21, 50, 'Lhasa',
40, 80, 20, 30,
'', '', '');

INSERT INTO users (gender, sexualOrientation, name, username,
location, password, age, intelligence, city,
start_intel_pref, finish_intel_pref,
age_pref_start, age_pref_finish,
matches, nos, encountered) VALUES (1, 0, 'Georgia',
'GMoney', 'Tibet', 'password', 21, 50, 'Lhasa',
40, 80, 20, 30,
'', '', '');

INSERT INTO users (gender, sexualOrientation, name, username,
location, password, age, intelligence, city,
start_intel_pref, finish_intel_pref,
age_pref_start, age_pref_finish,
matches, nos, encountered) VALUES (1, 0, 'Hillary',
'HMoney', 'Tibet', 'password', 21, 50, 'Lhasa',
40, 80, 20, 30,
'', '', '');

INSERT INTO users (gender, sexualOrientation, name, username,
location, password, age, intelligence, city,
start_intel_pref, finish_intel_pref,
age_pref_start, age_pref_finish,
matches, nos, encountered) VALUES (1, 0, 'Ilsa',
'IMoney', 'Tibet', 'password', 21, 50, 'Lhasa',
40, 80, 20, 30,
'', '', '');

INSERT INTO users (gender, sexualOrientation, name, username,
location, password, age, intelligence, city,
start_intel_pref, finish_intel_pref,
age_pref_start, age_pref_finish,
matches, nos, encountered) VALUES (1, 1, 'Janice',
'JMoney', 'Tibet', 'password', 21, 50, 'Lhasa',
40, 80, 20, 30,
'', '', '');

INSERT INTO users (gender, sexualOrientation, name, username,
location, password, age, intelligence, city,
start_intel_pref, finish_intel_pref,
age_pref_start, age_pref_finish,
matches, nos, encountered) VALUES (1, 1, 'Kathy',
'KMoney', 'Tibet', 'password', 21, 50, 'Lhasa',
40, 80, 20, 30,
'', '', '');

INSERT INTO users (gender, sexualOrientation, name, username,
location, password, age, intelligence, city,
start_intel_pref, finish_intel_pref,
age_pref_start, age_pref_finish,
matches, nos, encountered) VALUES (0, 1, 'Lenny',
'LMoney', 'Tibet', 'password', 21, 50, 'Lhasa',
40, 80, 20, 30,
'BMoney,CMoney', '', '');

INSERT INTO users (gender, sexualOrientation, name, username,
location, password, age, intelligence, city,
start_intel_pref, finish_intel_pref,
age_pref_start, age_pref_finish,
matches, nos, encountered) VALUES (0, 1, 'Maurice',
'MMoney', 'Tibet', 'password', 21, 50, 'Lhasa',
40, 80, 20, 30,
'BMoney,CMoney', '', '');

INSERT INTO users (gender, sexualOrientation, name, username,
location, password, age, intelligence, city,
start_intel_pref, finish_intel_pref,
age_pref_start, age_pref_finish,
matches, nos, encountered) VALUES (0, 1, 'Ned',
'NMoney', 'Tibet', 'password', 21, 50, 'Lhasa',
40, 80, 20, 30,
'', '', '');

INSERT INTO users (gender, sexualOrientation, name, username,
location, password, age, intelligence, city,
start_intel_pref, finish_intel_pref,
age_pref_start, age_pref_finish,
matches, nos, encountered) VALUES (0, 1, 'Oscar',
'OMoney', 'Tibet', 'password', 21, 50, 'Lhasa',
40, 80, 20, 30,
'', '', '');

INSERT INTO users (gender, sexualOrientation, name, username,
location, password, age, intelligence, city,
start_intel_pref, finish_intel_pref,
age_pref_start, age_pref_finish,
matches, nos, encountered) VALUES (0, 1, 'Philip',
'PMoney', 'Tibet', 'password', 21, 50, 'Lhasa',
40, 80, 20, 30,
'', '', '');

INSERT INTO users (gender, sexualOrientation, name, username,
location, password, age, intelligence, city,
start_intel_pref, finish_intel_pref,
age_pref_start, age_pref_finish,
matches, nos, encountered) VALUES (0, 1, 'Quinn',
'QMoney', 'Tibet', 'password', 21, 50, 'Lhasa',
40, 80, 20, 30,
'', '', '');

INSERT INTO users (gender, sexualOrientation, name, username,
location, password, age, intelligence, city,
start_intel_pref, finish_intel_pref,
age_pref_start, age_pref_finish,
matches, nos, encountered) VALUES (0, 1, 'Red',
'RMoney', 'Tibet', 'password', 21, 50, 'Lhasa',
40, 80, 20, 30,
'', '', '');

INSERT INTO users (gender, sexualOrientation, name, username,
location, password, age, intelligence, city,
start_intel_pref, finish_intel_pref,
age_pref_start, age_pref_finish,
matches, nos, encountered) VALUES (0, 1, 'Samuel',
'SMoney', 'Tibet', 'password', 21, 50, 'Lhasa',
40, 80, 20, 30,
'', '', '');

INSERT INTO users (gender, sexualOrientation, name, username,
location, password, age, intelligence, city,
start_intel_pref, finish_intel_pref,
age_pref_start, age_pref_finish,
matches, nos, encountered) VALUES (0, 0, 'Theo',
'TMoney', 'Tibet', 'password', 21, 50, 'Lhasa',
40, 80, 20, 30,
'', '', '');

INSERT INTO users (gender, sexualOrientation, name, username,
location, password, age, intelligence, city,
start_intel_pref, finish_intel_pref,
age_pref_start, age_pref_finish,
matches, nos, encountered) VALUES (0, 0, 'Ulyses',
'UMoney', 'Tibet', 'password', 21, 50, 'Lhasa',
40, 80, 20, 30,
'', '', '');