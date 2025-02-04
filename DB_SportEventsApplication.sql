-- ============================================================
-- Script completo para crear la base de datos "sportsevents" en MySQL
-- ============================================================

-- 1. Eliminar la base de datos si existe y crearla de nuevo
DROP DATABASE IF EXISTS sportsevents;
CREATE DATABASE sportsevents;
USE sportsevents;

-- 2. Eliminar las tablas en el orden correcto para evitar conflictos de claves foráneas
DROP TABLE IF EXISTS evento_usuario;
DROP TABLE IF EXISTS reserva;
DROP TABLE IF EXISTS usuario;
DROP TABLE IF EXISTS evento;
DROP TABLE IF EXISTS instalacion;

-- 3. Crear la tabla "usuario"
CREATE TABLE usuario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    correo VARCHAR(255) NOT NULL
);

-- 4. Crear la tabla "evento"
CREATE TABLE evento (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    descripcion VARCHAR(255),
    fecha DATE,
    hora TIME,
    duracion INT
);

-- 5. Crear la tabla "instalacion"
CREATE TABLE instalacion (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    tipo VARCHAR(255),
    ubicacion VARCHAR(255)
);

-- 6. Crear la tabla "reserva"
CREATE TABLE reserva (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    fecha DATE,
    franja_horaria VARCHAR(255),
    instalacion_id BIGINT,
    evento_id BIGINT,
    CONSTRAINT fk_reserva_instalacion 
        FOREIGN KEY (instalacion_id) REFERENCES instalacion(id)
        ON DELETE SET NULL ON UPDATE CASCADE,
    CONSTRAINT fk_reserva_evento 
        FOREIGN KEY (evento_id) REFERENCES evento(id)
        ON DELETE SET NULL ON UPDATE CASCADE
);

-- 7. Crear la tabla "evento_usuario" para la relación Many-to-Many entre evento y usuario
CREATE TABLE evento_usuario (
    evento_id BIGINT,
    usuario_id BIGINT,
    PRIMARY KEY (evento_id, usuario_id),
    CONSTRAINT fk_evento_usuario_evento 
        FOREIGN KEY (evento_id) REFERENCES evento(id)
        ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_evento_usuario_usuario 
        FOREIGN KEY (usuario_id) REFERENCES usuario(id)
        ON DELETE CASCADE ON UPDATE CASCADE
);
