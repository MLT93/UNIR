/* DDL para realizar la estructura */
DROP DATABASE IF EXISTS gestion_reservas;

CREATE DATABASE IF NOT EXISTS gestion_reservas;

ALTER DATABASE gestion_reservas DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

USE gestion_reservas;

CREATE TABLE IF NOT EXISTS `users` (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(150),
    rolee VARCHAR(10),
    created_at TIMESTAMP
) ENGINE = InnoDB CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS `books` (
    id INT PRIMARY KEY AUTO_INCREMENT,
    isbn VARCHAR(13) UNIQUE NOT NULL, /* Es preferible usar VARCHAR en vez de BIGINT por simplicidad */
    title VARCHAR(150),
    author VARCHAR(150),
    descc LONGTEXT
) ENGINE = InnoDB CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS `statuses` (
    id INT PRIMARY KEY AUTO_INCREMENT,
    typee VARCHAR(10) COMMENT 'ACTIVO, GRAVE, MUY GRAVE',
    descc LONGTEXT
) ENGINE = InnoDB CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS `rentals` (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    book_id INT,
    status_id INT,
    created_at TIMESTAMP,
    devolution_at TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (book_id) REFERENCES books (id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (status_id) REFERENCES statuses (id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

/* TCL para manipular y transferir los datos */
SET AUTOCOMMIT = 0;
START TRANSACTION;
BEGIN;

INSERT INTO `users` (username, rolee, created_at) VALUES
  ('Makis', 'admin', NOW()), /* En vez de GETDATE() usa NOW() */
  ('MIuRa', 'user', NOW()), /* En vez de GETDATE() usa NOW() */
  ('AlehOp32', 'user', NOW()); /* En vez de GETDATE() usa NOW() */

INSERT INTO `books` (isbn, title, author, descc) VALUES
  ('9836768903714', 'La maldición de la luna negra', 'Yo mismo', 'Habla de una noche de luna llena en la cual un ser espeluznante barca las puertas de tu casa...'),
  ('9846368909836', 'Donde todo se ve y nadie arremete', 'Tu mismo', 'La interminable historia de un quiosco en Madrid a las 3am, donde cualquier cosa se ve y se escucha...'),
  ('9846965890323', 'Unze bliven glaven gloven', 'Él mismo', 'Documental y descripción sobre las montañas de los Alpes pasando por Italia, Austria y Suiza');

INSERT INTO `statuses` (typee, descc) VALUES
  ('ACTIVO', 'El usuario está dentro de los 7 días hábiles'),
  ('GRAVE', 'El usuario se ha está entre los 7 y los 12 días de tolerancia '),
  ('MUY GRAVE', 'El usuario ha excedido los 12 días de tolerancia');

INSERT INTO `rentals` (user_id, book_id, status_id, created_at, devolution_at) VALUES
  (1, 2, 3, DATE_ADD(NOW(), INTERVAL -3 DAY), DATE_ADD(NOW(), INTERVAL +2 WEEK)), /* En vez de GETDATE() usa NOW() y en vez de DATEADD() usa DATE_ADD(fecha_base, INTERVAL cantidad tipo_de_unidad_mes-dia-año) */
  (2, 3, 1, NOW(), DATE_ADD(NOW(), INTERVAL +3 DAY)), /* En vez de GETDATE() usa NOW() y en vez de DATEADD() usa DATE_ADD(fecha_base, INTERVAL cantidad tipo_de_unidad_mes-dia-año) */
  (3, 1, 2, NOW(), DATE_ADD(NOW(), INTERVAL +8 DAY)); /* En vez de GETDATE() usa NOW() y en vez de DATEADD() usa DATE_ADD(fecha_base, INTERVAL cantidad tipo_de_unidad_mes-dia-año) */

SAVEPOINT test_first_point;
COMMIT;


/* FUNCIONES */
CREATE FUNCTION `SANCION_USUARIO`(rental_date DATE) RETURNS varchar(20) CHARSET utf8mb4 COLLATE utf8mb4_general_ci
BEGIN
  DECLARE dayss INT;
  SET dayss = DATEDIFF(NOW(), rental_date);

  IF dayss <= 7 THEN
    RETURN 'ACTIVO';
  ELSEIF dayss <= 12 THEN
    RETURN 'GRAVE';
  ELSE
    RETURN 'MUY GRAVE';
  END IF;
END

CREATE FUNCTION `MENSAJE_SANCION`(nom VARCHAR, ape VARCHAR, datee DATE, idPrest INT, numDays INT, penalization VARCHAR) RETURNS mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci
BEGIN
	DECLARE msg mediumtext;
    
    SET msg = CONCAT(
    'Estimado usuario ', nom, ' ', ape,
    ', el pasado día ', datee,
    ' realizó un préstamo en nuestra biblioteca con código ', idPrest,
    ' y ha superado la fecha de entrega prevista en ', numDays,
    ' días, por lo que le corresponde una sanción ', penalization, '.'
  );
RETURN msg;
END

/* PROCEDIMIENTOS */
/* No pude ver los procedimientos, pero supongo que será igual o similar a una función */
