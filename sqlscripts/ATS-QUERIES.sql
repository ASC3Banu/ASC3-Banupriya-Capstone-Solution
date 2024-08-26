create database ats_db;
use ats_db;
SHOW TABLES;
 
SELECT * FROM admin
;
DROP TABLE booking;
SELECT * FROM user;
DROP TABLE user;
DROP TABLE airport;
DROP TABLE plane;
SELECT * FROM plane;
SELECT * FROM admin;
SELECT * FROM airport;
INSERT INTO admin (email,password) VALUES 
('Telusko', 'ascendion');
SELECT * FROM login_attempts;
INSERT INTO admin (id,email, password,attempts,locked) VALUES (1,'priyaselvaraj@gmail.com','priyaselvaraj@3',0,False);
SELECT * FROM booking;
SELECT * FROM user;

