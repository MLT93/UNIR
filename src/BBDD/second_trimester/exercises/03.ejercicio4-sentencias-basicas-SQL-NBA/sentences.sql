-- **Ejercicios de SQL sobre la base de datos NBA**

-- 1. **Muestra todos los datos que contienen las tablas**

USE NBA;
SHOW TABLES;
DESCRIBE equipos;
DESCRIBE jugadores;
DESCRIBE estadisticas;
DESCRIBE partidos;

-- 2. **Equipos que forman parte de la conferencia Oeste (West)**

SELECT e.Nombre, e.Conferencia FROM equipos e WHERE Conferencia = 'West';

-- 3. **Equipos cuyo nombre comienza por H y termina por S**

SELECT e.Nombre FROM equipos e WHERE Nombre LIKE 'H%s';

-- 4. **¿Cuántos jugadores argentinos juegan en la NBA?**

CREATE TABLE Jugadores_Argentinos AS
SELECT j.Nombre, j.Procedencia, 
       (SELECT COUNT(*) FROM jugadores WHERE Procedencia = 'Argentina') AS Cantidad
FROM jugadores j
WHERE Procedencia = 'Argentina';

-- 5. **Jugadores españoles que juegan en los equipos Lakers y Raptors**

SELECT * FROM jugadores WHERE Procedencia = 'España' AND Nombre_equipo IN ('Lakers', 'Raptors');

-- 6. **Jugadores que no proceden de Florida, Utah o España**

SELECT * FROM jugadores WHERE Procedencia NOT IN ('Florida', 'Utah', 'España');

-- 7. **Visualizar el número de jugadores españoles y franceses, con el país correspondiente**

CREATE TABLE Jugadores_Esp_Fr AS /* Creo tabla a partir de consulta para poderla consultar posteriormente */
SELECT j.Nombre, j.Procedencia, 
       (SELECT COUNT(*) FROM jugadores WHERE Procedencia IN ('España', 'Francia')) AS Cantidad
FROM jugadores j
WHERE Procedencia IN ('España', 'Francia');

-- 8. **Muestra el jugador que más puntos ha metido en la NBA**

SELECT 
    j.Nombre, e.Puntos_por_partido 
FROM 
    estadisticas e 
INNER JOIN jugadores j ON e.jugador = j.codigo 
ORDER BY e.Puntos_por_partido DESC LIMIT 1;

-- 9. **¿Cuántos jugadores tiene cada equipo de la conferencia Este (East)?**

SELECT e.Nombre AS Eqp, COUNT(j.codigo) AS Num_Jugadores FROM equipos e INNER JOIN jugadores j ON e.Nombre = j.Nombre_equipo WHERE e.Conferencia = 'East' GROUP BY e.Nombre;

-- 10. **¿Cuál es la temporada en la que LeBron James consiguió más puntos por partido?**

SELECT e.temporada, e.Puntos_por_partido, j.Nombre, j.Posicion FROM estadisticas e INNER JOIN jugadores j ON e.jugador = j.codigo WHERE j.Nombre = 'LeBron James' ORDER BY Puntos_por_partido DESC LIMIT 1;


