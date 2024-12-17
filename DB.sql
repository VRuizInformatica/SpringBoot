DROP DATABASE IF EXISTS Ajedrez;
CREATE DATABASE Ajedrez;
USE Ajedrez;

CREATE TABLE Ajedrecistas (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(150) NOT NULL,
    nacionalidad VARCHAR(100) NOT NULL
);

CREATE TABLE Patrocinador (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nombre_empresa VARCHAR(150) NOT NULL,
    pais_origen VARCHAR(100) NOT NULL
);


CREATE TABLE Torneo (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nombre_torneo VARCHAR(200) NOT NULL,
    fecha_inicio DATE,
    patrocinador_id BIGINT UNSIGNED,
    CONSTRAINT fk_torneo_patrocinador
        FOREIGN KEY (patrocinador_id) REFERENCES Patrocinador(id)
        ON DELETE SET NULL ON UPDATE CASCADE
);


CREATE TABLE torneo_ajedrecista (
    torneo_id BIGINT UNSIGNED NOT NULL,
    ajedrecista_id BIGINT UNSIGNED NOT NULL,
    PRIMARY KEY (torneo_id, ajedrecista_id),
    CONSTRAINT fk_torneo FOREIGN KEY (torneo_id) REFERENCES Torneo(id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_ajedrecista FOREIGN KEY (ajedrecista_id) REFERENCES Ajedrecistas(id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO Ajedrecistas (nombre, nacionalidad)
VALUES ('Magnus Carlsen', 'Noruega'),
       ('Hikaru Nakamura', 'Estados Unidos'),
       ('Garry Kasparov', 'Rusia'),
       ('Bobby Fischer', 'Estados Unidos');

INSERT INTO Patrocinador (nombre_empresa, pais_origen)
VALUES ('Empresa X', 'España'),
       ('ChessMasters Inc.', 'EEUU'),
       ('Gens Una Sumus S.A.', 'Noruega');

INSERT INTO Torneo (nombre_torneo, fecha_inicio, patrocinador_id)
VALUES ('Open de Madrid', '2024-05-10', 1),
       ('Campeonato Mundial de Ajedrez', '2025-03-20', 3),
       ('Copa de los Grandes Maestros', '2024-09-15', 2);


INSERT INTO torneo_ajedrecista (torneo_id, ajedrecista_id)
VALUES (1, 1),  -- Open de Madrid - Magnus
       (1, 2),  -- Open de Madrid - Hikaru
       (2, 3),  -- Mundial - Garry
       (2, 4),  -- Mundial - Bobby
       (3, 1),  -- Copa GM - Magnus
       (3, 4);  -- Copa GM - Bobby

