set sql_safe_updates=0;
select * from carga;

drop table carga; # borra estructura y datos
truncate table carga; # borra datos e iniciliza los indices auto_incrementales
delete from carga where codigo_oficina="TAL-ES"; # elimina los registros seleccionados, si son multiple hay que quitar el bloqueo de seguridad

show variables like "local_infile";
set global local_infile='ON';

delete from empleados where apel1="PEREZ";
UPDATE EMPLEADOS SET nombre="PEPE" where apel1="PEREZ";

SELECT * FROM empleado INTO
OUTFILE 'empleados.csv'
FIELDS terminated by ';'
LINES TERMINATED BY '\n';

CREATE TABLE carga select * from empleado; 

LOAD DATA INFILE 'D:/datos.txt'
INTO TABLE CARGA
FIELDS TERMINATED BY ';'
LINES TERMINATED BY '\n'
IGNORE 1 LINES;

CREATE TABLE PRUEBA (
	NOMBRE CHAR(20),
    EDAD INTEGER,
    CIUDAD CHAR(20)
);

/*
HOLA --PEDRO,23,GETAFE;
--ANDREA,18,LEGANES; ADIOS
DASDASD --LUIS,14,BURGOS;
*/

LOAD DATA INFILE 'D:/ficprueba.txt'
INTO TABLE prueba
FIELDS TERMINATED BY ','
LINES TERMINATED BY ';'
STARTING BY '--';

TRUNCATE TABLE PRUEBA;
SELECT * FROM PRUEBA;

/* SABER EL NOMBRE DEL CLIENTE QUE HA HECHO EL PEDIDO DE MAYOR IMPORTE */
SELECT NOMBRE_CLIENTE,PEDIDO.CODIGO_PEDIDO,(detalle_pedido.cantidad*detalle_pedido.precio_unidad) as importe_pedido
FROM CLIENTE INNER JOIN PEDIDO ON  CLIENTE.CODIGO_CLIENTE=PEDIDO.CODIGO_CLIENTE
INNER JOIN detalle_pedido on pedido.codigo_pedido=detalle_pedido.codigo_pedido order by importe_pedido desc limit 1;

/*SUMA DE ARTÍCULOS QUE SE HAN PEDIDO POR PAIS Y EL IMPORTE TOTAL DE COMPRAS POR PAÍS*/
SELECT cliente.pais,cliente.ciudad,cliente.codigo_postal,sum(detalle_pedido.cantidad) as total_articulos,sum((detalle_pedido.cantidad*detalle_pedido.precio_unidad)) as importe_total_pedidos
FROM CLIENTE INNER JOIN PEDIDO ON CLIENTE.CODIGO_CLIENTE=PEDIDO.CODIGO_CLIENTE
INNER JOIN detalle_pedido on pedido.codigo_pedido=detalle_pedido.codigo_pedido
group by cliente.pais,cliente.ciudad,cliente.codigo_postal having cliente.pais = "Spain";






