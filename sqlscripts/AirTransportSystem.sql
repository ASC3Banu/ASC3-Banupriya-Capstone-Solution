CREATE DATABASE AirportTransportSystem;
USE AirportTransportSystem;
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    failed_attempts INT DEFAULT 0,
    account_locked BOOLEAN DEFAULT FALSE,
    lock_time TIMESTAMP NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
INSERT INTO users (email, password, failed_attempts, account_locked, lock_time) 
VALUES ('admin@example.com', 'Admin@123', 0, FALSE, NULL);

INSERT INTO users (email, password, failed_attempts, account_locked, lock_time) 
VALUES ('user1@example.com', 'User1Pass@123', 0, FALSE, NULL);

SELECT * FROM users;
CREATE TABLE airports (
    airport_code VARCHAR(5) PRIMARY KEY,
    airport_name VARCHAR(255) NOT NULL,
    country_code VARCHAR(5) NOT NULL
);
INSERT INTO airports (airport_code, airport_name, country_code) 
VALUES ('A0001', 'JFK International', 'US');
SELECT * FROM Airports;

CREATE TABLE planes (
    registration_number VARCHAR(5) PRIMARY KEY,
    plane_maker VARCHAR(255) NOT NULL,
    model VARCHAR(255) NOT NULL,
    image_path VARCHAR(255) NULL,
    seating_capacity INT NOT NULL
);

INSERT INTO planes (registration_number, plane_maker, model, image_path, seating_capacity) 
VALUES ('R0001', 'Boeing', '747', '/images/boeing747.png', 400);

INSERT INTO planes (registration_number, plane_maker, model, image_path, seating_capacity) 
VALUES ('R0002', 'Airbus', 'A320', '/images/airbusA320.png', 180);

SELECT * FROM planes;





