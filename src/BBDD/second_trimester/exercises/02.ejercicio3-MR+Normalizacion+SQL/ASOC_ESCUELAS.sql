
/** DATABASE */
DROP DATABASE IF EXISTS asoc_escuelas;

CREATE DATABASE IF NOT EXISTS asoc_escuelas;

ALTER DATABASE asoc_escuelas DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

USE asoc_escuelas;

/** TABLE (nombre de la tabla en plural, nombre de los campos en singular) */
DROP TABLE IF EXISTS ciudades;
CREATE TABLE asoc_escuelas.ciudades (
  cod_ciu INT PRIMARY KEY AUTO_INCREMENT,
  nombre_ciudad VARCHAR(150) NOT NULL
) ENGINE = InnoDB CHARACTER SET utf8 COLLATE utf8_unicode_ci;
INSERT INTO ciudades (nombre_ciudad) VALUES
('Madrid'),
('Barcelona'),
('Valencia'),
('Sevilla'),
('Bilbao'),
('Zaragoza'),
('Málaga'),
('Murcia'),
('Palma'),
('Alicante');

DROP TABLE IF EXISTS dificultades;
CREATE TABLE asoc_escuelas.dificultades (
  id_diff INT PRIMARY KEY AUTO_INCREMENT,
  nombre_diff VARCHAR(10) UNIQUE COMMENT 'Básico, Intermedio, Avanzado'
) ENGINE = InnoDB CHARACTER SET utf8 COLLATE utf8_unicode_ci;
INSERT INTO dificultades (nombre_diff) VALUES
('Básico'),
('Intermedio'),
('Avanzado');

DROP TABLE IF EXISTS estudios;
CREATE TABLE asoc_escuelas.estudios (
  id_est INT PRIMARY KEY AUTO_INCREMENT,
  nivel_est INT NOT NULL,
  grupo_est VARCHAR(2) NOT NULL,
  aula_est INT NOT NULL,
  curso_est VARCHAR(5) NOT NULL,
  FOREIGN KEY (nivel_est) REFERENCES dificultades (id_diff) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET utf8 COLLATE utf8_unicode_ci;
INSERT INTO estudios (nivel_est, grupo_est, aula_est, curso_est) VALUES
(2, 'A1', 101, '20-21'),
(1, 'B1', 102, '18-19'),
(3, 'C1', 103, '22-23'),
(2, 'A2', 104, '23-24'),
(1, 'B2', 105, '23-24'),
(1, 'C2', 106, '24-25'),
(3, 'A3', 107, '24-25'),
(1, 'B3', 108, '24-25'),
(1, 'C3', 109, '25-26'),
(2, 'A4', 110, '25-26');

DROP TABLE IF EXISTS alumnos;
CREATE TABLE asoc_escuelas.alumnos (
  dni_alumno VARCHAR(13) PRIMARY KEY NOT NULL,
  cod_ciu INT NOT NULL,
  nombre_alu VARCHAR(150) NOT NULL,
  dir_alu VARCHAR(255) NOT NULL,
  FOREIGN KEY (cod_ciu) REFERENCES ciudades (cod_ciu) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET utf8 COLLATE utf8_unicode_ci;
INSERT INTO alumnos (dni_alumno, cod_ciu, nombre_alu, dir_alu) VALUES
('DNI000000001', 1, 'Alumno 1', 'C/ Felicidad 1'),
('DNI000000002', 2, 'Alumno 2', 'C/ Armonía 2'),
('DNI000000003', 3, 'Alumno 3', 'C/ Gozada 3'),
('DNI000000004', 4, 'Alumno 4', 'C/ Alegría 4'),
('DNI000000005', 5, 'Alumno 5', 'C/ Estupenda 5'),
('DNI000000006', 6, 'Alumno 6', 'C/ Gloriosa 6'),
('DNI000000007', 7, 'Alumno 7', 'C/ Simpática 7'),
('DNI000000008', 8, 'Alumno 8', 'C/ Formidable 8'),
('DNI000000009', 9, 'Alumno 9', 'C/ Satírica 9'),
('DNI000000010', 10, 'Alumno 10', 'C/ Orfandad 10');

DROP TABLE IF EXISTS escuelas;
CREATE TABLE asoc_escuelas.escuelas (
  cod_esc INT PRIMARY KEY AUTO_INCREMENT,
  cod_ciu INT NOT NULL,
  nombre_esc VARCHAR(150) NOT NULL,
  dir_esc VARCHAR(255) NOT NULL,
  FOREIGN KEY (cod_ciu) REFERENCES ciudades (cod_ciu) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET utf8 COLLATE utf8_unicode_ci;
INSERT INTO escuelas (cod_ciu, nombre_esc, dir_esc) VALUES
(3, 'Escuela 1', 'Dirección Escuela 1'),
(2, 'Escuela 2', 'Dirección Escuela 2'),
(7, 'Escuela 3', 'Dirección Escuela 3'),
(4, 'Escuela 4', 'Dirección Escuela 4'),
(5, 'Escuela 5', 'Dirección Escuela 5'),
(6, 'Escuela 6', 'Dirección Escuela 6'),
(1, 'Escuela 7', 'Dirección Escuela 7'),
(9, 'Escuela 8', 'Dirección Escuela 8'),
(8, 'Escuela 9', 'Dirección Escuela 9'),
(10, 'Escuela 10', 'Dirección Escuela 10');

DROP TABLE IF EXISTS matriculas;
CREATE TABLE asoc_escuelas.matriculas (
  id_matr INT PRIMARY KEY AUTO_INCREMENT,
  id_est INT NOT NULL,
  dni_alumno VARCHAR(13) NOT NULL,
  FOREIGN KEY (id_est) REFERENCES estudios (id_est) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (dni_alumno) REFERENCES alumnos (dni_alumno) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET utf8 COLLATE utf8_unicode_ci;
INSERT INTO matriculas (id_est, dni_alumno) VALUES
(1, 'DNI000000001'),
(8, 'DNI000000005'),
(1, 'DNI000000004'),
(1, 'DNI000000005'),
(1, 'DNI000000010');

/** CONSULTAS */
USE asoc_escuelas;
SHOW TABLES;
