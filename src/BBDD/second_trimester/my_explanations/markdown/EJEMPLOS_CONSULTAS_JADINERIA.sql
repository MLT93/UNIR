
/* Muestra los días que se ha tardado en entregar los pedidos cuyo estado es Entragado */
select codigo_pedido, fecha_pedido,fecha_entrega,datediff(fecha_entrega,fecha_pedido) as DIAS_ENTREGA, estado 
from pedido 
where estado = "Entregado" and fecha_entrega is not null
order by DIAS_ENTREGA ASC;

/* Añade a la consulta anterior, un columna que se denominará entrega_optima, que será la suma de
cinco días a la fecha de pedido */
select codigo_pedido, fecha_pedido, DATE_ADD(fecha_pedido, INTERVAL 1 DAY) as ENTREGA_OPTIMA,
fecha_entrega,datediff(fecha_entrega,fecha_pedido) as DIAS_ENTREGA, estado 
from pedido 
where estado = "Entregado" and fecha_entrega is not null 
and (datediff(fecha_entrega,fecha_pedido) < 5 AND datediff(fecha_entrega,fecha_pedido) >= 1) ;

/* CREAR TABLA EN BASE A UNA CONSULTA */ 
CREATE TABLE FECHAS_PEDIDOS select codigo_pedido, fecha_pedido, DATE_ADD(fecha_pedido, INTERVAL 1 DAY) as ENTREGA_OPTIMA,
fecha_entrega,datediff(fecha_entrega,fecha_pedido) as DIAS_ENTREGA, estado 
from pedido 
where estado = "Entregado" and fecha_entrega is not null 
and (datediff(fecha_entrega,fecha_pedido) < 5 AND datediff(fecha_entrega,fecha_pedido) >= 1) ;

/* CUANTO PRODUCTOS TENGO DE CADA PROVEEDOR */
SELECT PROVEEDOR, SUM(CANTIDAD_EN_STOCK) AS CANTIDAD_PRODUCTO 
FROM PRODUCTO
GROUP BY PROVEEDOR
ORDER BY PROVEEDOR;

/* QUIERO SABER EL IMPORTE TOTAL DE COSTE DE PRODUCTOS, POR CADA PROVEEDOR */
select proveedor, sum(cantidad_en_stock*precio_proveedor) as COSTE_TOTAL
from producto
GROUP BY PROVEEDOR;

/* PRODUCTO MAS CARO Y MAS BARATO */
SELECT nombre, max(precio_venta) from producto
UNION
SELECT nombre, min(precio_venta) from producto;

/* MUESTRA EL IMPORTE TOTAL A INGRESAR SI VENDIESE TODO EL STOCK EN ESTE MOMENTO */
SELECT SUM(CANTIDAD_EN_STOCK*PRECIO_VENTA*1.10) AS PVP FROM PRODUCTO;

/* SUBCONSULTA PRODUCTOS COMPRADOS ALGUNA VEZ */
SELECT NOMBRE,GAMA FROM PRODUCTO WHERE codigo_producto 
NOT IN (SELECT CODIGO_PRODUCTO FROM detalle_pedido);

SELECT * FROM PRODUCTO;

select nombre, precio_venta from producto WHERE NOMBRE='Sierra de Poda 400MM';

select nombre, AVG(precio_venta) from producto group by NOMBRE ORDER BY AVG(precio_venta) DESC;
