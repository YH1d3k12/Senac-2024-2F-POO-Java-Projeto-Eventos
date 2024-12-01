# Senac-2024-2F-POO-Java-Projeto-Eventos

CREATE SCHEMA IF NOT EXISTS events;
USE events;

-- Creating the Participant table
CREATE TABLE IF NOT EXISTS Participant (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    phone VARCHAR(20)
);

-- Creating the Organizer table
CREATE TABLE IF NOT EXISTS Organizer (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(100)
);

-- Creating the Location table
CREATE TABLE IF NOT EXISTS Location (
    id INT PRIMARY KEY AUTO_INCREMENT,
    description VARCHAR(255) NOT NULL,
    vacancies INT NOT NULL
);

-- Creating the Notification table
CREATE TABLE IF NOT EXISTS Notification (
    id INT PRIMARY KEY AUTO_INCREMENT,
    date DATE,
    message TEXT NOT NULL
);

-- Creating the NotificationParticipant table
CREATE TABLE IF NOT EXISTS NotificationParticipant (
    id INT PRIMARY KEY AUTO_INCREMENT,
    notification_id INT,
    participant_id INT,
    FOREIGN KEY (notification_id) REFERENCES Notification(id),
    FOREIGN KEY (participant_id) REFERENCES Participant(id)
);

-- Creating the NotificationOrganizer table
CREATE TABLE IF NOT EXISTS NotificationOrganizer (
    id INT PRIMARY KEY AUTO_INCREMENT,
    notification_id INT,
    organizer_id INT,
    FOREIGN KEY (notification_id) REFERENCES Notification(id),
    FOREIGN KEY (organizer_id) REFERENCES Organizer(id)
);

-- Creating the EventDetails table 
CREATE TABLE IF NOT EXISTS EventDetails (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(250),
    organizer_id INT,
    location_id INT,
    date DATETIME NOT NULL,
    description TEXT NOT NULL,
    vacancies INT NOT NULL,
    FOREIGN KEY (organizer_id) REFERENCES Organizer(id),
    FOREIGN KEY (location_id) REFERENCES Location(id)
);

-- Creating the EventParticipants table
CREATE TABLE IF NOT EXISTS EventParticipants (
    id INT PRIMARY KEY AUTO_INCREMENT,
    event_id INT,
    participant_id INT,
    FOREIGN KEY (event_id) REFERENCES EventDetails(id),
    FOREIGN KEY (participant_id) REFERENCES Participant(id)
);