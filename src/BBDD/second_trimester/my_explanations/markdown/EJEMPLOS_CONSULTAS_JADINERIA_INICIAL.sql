select * from  pedido order by fecha_pedido;

select * from  pedido where year(fecha_pedido) = 2008 and month(fecha_pedido) = 11;

select * from  pedido where year(fecha_pedido) = 2008 and month(fecha_pedido) = 11 
and (estado = "Entregado" or estado = "Rechazado");

select  * from pago order by fecha_pago;

select codigo_cliente, fecha_pago from pago 
where fecha_pago >= '2008-01-01' and fecha_pago <= '2008-12-31';

select codigo_cliente, fecha_pago from pago 
where fecha_pago between '2008-01-01' and '2008-12-31';

select codigo_cliente, count(fecha_pago) from pago 
where fecha_pago between cast('2008-01-01' as date) and cast('2009-12-31' as date) group by codigo_cliente;

select codigo_cliente, nombre_cliente, telefono, fax, codigo_postal from cliente 
where codigo_cliente not in (select codigo_cliente from pedido where year(fecha_pedido) = 2009);

select codigo_cliente, nombre_cliente, telefono, fax, codigo_postal from cliente 
where codigo_cliente in (select codigo_cliente from pedido where year(fecha_pedido) = 2009);

select codigo_cliente, nombre_cliente, telefono, fax, codigo_postal from cliente 
where codigo_cliente in (select codigo_cliente from pedido where year(fecha_pedido) = 2009);

SELECT C.CODIGO_CLIENTE, NOMBRE_CLIENTE, TELEFONO, FAX, CODIGO_POSTAL
FROM CLIENTE C, PEDIDO P
WHERE CODIGO_CLIENTE = CODIGO_CLIENTE AND YEAR(FECHA_PEDIDO) = 2008
GROUP BY CODIGO_CLIENTE;

select * FROM PAGO;

/* Tenemos que sacar: el nombre, el código y el teléfono de los clientes que tengan pagos mayor de 15.000 euros */
SELECT codigo_cliente ,nombre_cliente, telefono FROM CLIENTE WHERE codigo_cliente in 
(SELECT codigo_cliente FROM PAGO WHERE TOTAL > 15000);

SELECT nombre_cliente, telefono, concat(apellido1," ",apellido2,", ",nombre) as Representante_ventas, extension
FROM cliente inner join empleado on cliente.codigo_empleado_rep_ventas = empleado.codigo_empleado 
WHERE puesto = 'Representante Ventas' order by nombre_cliente asc;

select count(distinct(codigo_cliente)) from pedido;
select distinct(codigo_cliente) as codigo_cliente_pedido from pedido;

select nombre_cliente,telefono,fax,pais from cliente 
where codigo_cliente not in (select distinct(codigo_cliente) as codigo_cliente_pedido from pedido);

/* NOMBRE DE LOS CLIENTES QUE HAN HECHO ALGÚN PAGO, JUNTO AL NOMBRE DEL REPRESENTANTE Y LA CIUDAD DE LA OFICINA DE ESTE */

SELECT nombre_cliente, nombre, puesto, oficina.ciudad, sum(total) as Total
FROM cliente inner join empleado on cliente.codigo_empleado_rep_ventas=empleado.codigo_empleado
inner join pago on pago.codigo_cliente=cliente.codigo_cliente
inner join oficina on oficina.codigo_oficina=empleado.codigo_oficina
where puesto='Representante Ventas' and (oficina.ciudad = "Boston" or oficina.ciudad = "Madrid")
group by nombre_cliente
having Total > 20000;

select nombre_cliente, forma_pago
from cliente natural join pago ;













