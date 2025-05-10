### 🤔 **¿Qué son TCL y DCL en SQL?**

En SQL, **TCL (Transaction Control Language)** y **DCL (Data Control Language)** son subconjuntos del lenguaje utilizados para controlar la **integridad de las transacciones** y la **seguridad de acceso a los datos**, respectivamente. **[SQL: DDL-DML-DCL-TCL](http://blog.walthercuro.com/sql-ddl-dml-dcl-y-tcl/)**.

---

### 📌 **TCL (Transaction Control Language)**

Los comandos TCL se usan para gestionar transacciones que afectan a los datos de forma consistente y segura.

| Comando     | Descripción                                        |
| ----------- | -------------------------------------------------- |
| `SET AUTOCOMMIT=0`     | Quita el estado de autoguardado por defecto.                            |
| `BEGIN`     | Inicia una transacción.                            |
| `COMMIT`    | Guarda permanentemente los cambios.                |
| `ROLLBACK`  | Revierte los cambios no confirmados.               |
| `SAVEPOINT` | Crea un punto intermedio para posibles retrocesos. |

#### 💡 **Ejemplo práctico**

```sql
-- Quita el guardado por defecto
SET AUTOCOMMIT=0;

-- Inicia la transacción
START TRANSACTION;
BEGIN;

-- Ejecuta las consultas
UPDATE cuentas SET saldo = saldo - 100 WHERE id = 1;
UPDATE cuentas SET saldo = saldo + 100 WHERE id = 2;

-- Si hace falta un punto de guardado (para testing por ejemplo):
-- SAVEPOINT point1;
SAVEPOINT point1;


-- Si algo falla:
-- ROLLBACK;
UPDATE cuentas SET saldo = saldo + 30*0 WHERE id = 3; /* Esto falla */
ROLLBACK point1; /* vuelve a la última consulta hecha antes del punto de guardado -> UPDATE cuentas SET saldo = saldo + 100 WHERE id = 2; */

ROLLBACK /* Elimina todo el progreso */

-- Si todo fue bien:
COMMIT;
```

✅ Este ejemplo transfiere dinero entre cuentas y asegura que **ambos cambios ocurran o ninguno**.

```sql
SET AUTOCOMMIT=0;
START TRANSACTION;
BEGIN;

INSERT INTO ALUMNOS (NOMBRE,FECHANACI,NOTAFINAL) VALUES
('PEPE','2001-10-10','8.5');
INSERT INTO ALUMNOS (NOMBRE,FECHANACI,NOTAFINAL) VALUES
('PEPA','2000-11-15','9.5');
SAVEPOINT PEPA;

INSERT INTO ALUMNOS (NOMBRE,FECHANACI,NOTAFINAL) VALUES
('PEPITO','2020-11-15','10.0');
SAVEPOINT PEPITO;

ROLLBACK TO SAVEPOINT PEPA;
ROLLBACK TO SAVEPOINT PEPITO;

ROLLBACK;

COMMIT;
```

---

### 📌 **DCL (Data Control Language)**

Controla el **acceso y los permisos** sobre la base de datos.

| Comando  | Descripción                  |
| -------- | ---------------------------- |
| `GRANT`  | Concede permisos a usuarios. |
| `REVOKE` | Revoca permisos otorgados.   |

#### 💡 **Ejemplo práctico**

```sql
-- Dar permiso de lectura en la tabla empleados a user1
GRANT SELECT ON empleados TO user1;

-- Revocar ese permiso
REVOKE SELECT ON empleados FROM user1;
```

---

### 🛠️ **¿Cómo crear FUNCIONES en SQL?**

Una **función** es un bloque reutilizable que devuelve un valor. Ideal para cálculos o transformaciones. **[PL/SQL](https://es.wikipedia.org/wiki/PL/SQL)**

#### 🧱 Estructura básica

```sql
CREATE FUNCTION nombre_función(parámetros)
RETURNS tipo
AS $$
BEGIN
  -- lógica
  RETURN resultado;
END;
$$ LANGUAGE plpgsql;
```

```sql
CREATE FUNCTION nombre_funcion (parametros)
RETURNS tipo_dato
AS
BEGIN
    -- Cuerpo de la función
    RETURN valor;
END;
```

#### 💡 **Ejemplo: Calcular edad**

```sql
CREATE FUNCTION calcular_edad(fecha_nacimiento DATE)
RETURNS INT
AS $$
BEGIN
  RETURN DATE_PART('year', AGE(CURRENT_DATE, fecha_nacimiento));
END;
$$ LANGUAGE plpgsql;
```

```sql
CREATE FUNCTION calcular_iva(@monto DECIMAL(10,2))
RETURNS DECIMAL(10,2)
AS
BEGIN
    RETURN @monto * 0.21;
END;
```

📞 **Uso:**

```sql
SELECT calcular_edad('1990-05-09');
```

---

### 🧱 ¿Qué significa `AS $$ ... $$`?

* `AS` indica que **estás a punto de definir el cuerpo (la lógica)** de una función o procedimiento.
* `$$` son delimitadores **de texto (string literal delimiters)** usados para encapsular el código PL/pgSQL **sin necesidad de escapar comillas simples o dobles** dentro del bloque.

Puedes pensar en `$$ ... $$` como **una alternativa más conveniente a usar comillas simples largas `' ... '`**, que serían engorrosas si tuvieras comillas dentro del código SQL.

| Elemento           | Significado                                          |
| ------------------ | ---------------------------------------------------- |
| `AS`               | Inicia el cuerpo del código                          |
| `$$`               | Delimita el bloque sin necesidad de escapar comillas |
| `LANGUAGE plpgsql` | Especifica que se usa PL/pgSQL como lenguaje         |

#### ✅ Con delimitador:

```sql
CREATE FUNCTION ejemplo()
RETURNS TEXT
AS $$
BEGIN
  RETURN 'Hola "mundo"';
END;
$$ LANGUAGE plpgsql;
```

#### ❌ Sin `$$`:

```sql
CREATE FUNCTION calcular_iva(@monto DECIMAL(10,2))
RETURNS DECIMAL(10,2)
AS
BEGIN
    RETURN @monto * 0.21;
END;
```

```sql
CREATE FUNCTION ejemplo()
RETURNS TEXT
AS '
BEGIN
  RETURN ''Hola "mundo"'';
END;
' LANGUAGE plpgsql;
```

#### ✅ Puedes usar otros delimitadores

PostgreSQL permite reemplazar `$$` por algo más descriptivo como `$_$`, `$func$`, etc.

```sql
AS $func$
BEGIN
  -- tu lógica aquí
END;
$func$
```

Esto es útil si dentro del bloque hay otra función que ya usa `$$`.

---

### 🛠️ **¿Cómo crear PROCEDIMIENTOS almacenados?**

Un **procedimiento** ejecuta una serie de instrucciones y puede no devolver valor (o usar `OUT`).

#### 🧱 Estructura básica

```sql
CREATE PROCEDURE nombre_procedimiento(parámetros)
LANGUAGE plpgsql
AS $$
BEGIN
  -- lógica
END;
$$;
```

```sql
CREATE PROCEDURE nombre_procedimiento (parametros)
AS
BEGIN
    -- Cuerpo del procedimiento
END;
```

#### 💡 **Ejemplo: Registrar nuevo usuario**

```sql
CREATE PROCEDURE registrar_usuario(
  IN nombre TEXT,
  IN correo TEXT
)
LANGUAGE plpgsql
AS $$
BEGIN
  INSERT INTO usuarios(nombre, correo, fecha_registro)
  VALUES (nombre, correo, CURRENT_DATE);
END;
$$;
```

```sql
CREATE PROCEDURE actualizar_saldo(@id_cliente INT, @nuevo_saldo DECIMAL(10,2))
AS
BEGIN
    UPDATE clientes SET saldo = @nuevo_saldo WHERE id = @id_cliente;
END;
```

📞 **Uso:**

```sql
CALL registrar_usuario('Ana Pérez', 'ana@mail.com');
```

### 👁️ **¿Qué es una VISTA en SQL?**

Una vista es una tabla virtual basada en el resultado de una consulta SQL. Se utiliza para simplificar consultas complejas y proporcionar una capa de seguridad.

Esto es importante para crear bases de datos porque permite que todo quede **oculto**.

#### 📌 **Procedimiento previo**

```ts
- Botón dcho -> VIEW -> CREATE VIEW
- Realiza la consulta que desees guardar (abajo se muestra la sintaxis)
- Le damos al botón APPLY (convierte el código para poderlo utilizar sólo en la Base de Datos donde se ha creado)
- Posteriormente lo podemos llamar donde lo necesitemos
```

#### 🧱 **Sintaxis básica para crear una vista**

```sql
CREATE VIEW nombre_vista AS
SELECT columnas
FROM tablas
WHERE condiciones;
```

#### 💡 **Ejemplo: Registrar nuevo usuario**

```sql
CREATE VIEW clientes_premium AS
SELECT id, nombre, saldo
FROM clientes
WHERE saldo > 1000;
```

📞 **Uso:**

```sql
/* La VIEW se quedará guardada en memoria para poderla utilizar siempre que la necesitemos al interno de la Base de Datos donde se haya creado. Corresponderá a un OBJ de la tabla que se haya usado en la consulta */
SELECT nombre, saldo FROM clientes.clientes_premium
/* => Devuelve sólo los clientes con saldo mayor a 1000 */
```

---

### 🚀 **Guía paso a paso para practicar en PostgreSQL o MySQL**

#### **1️⃣ Crea una base de datos de ejemplo**

```sql
CREATE DATABASE gestion_usuarios;
\c gestion_usuarios
```

#### **2️⃣ Crea una tabla de usuarios**

```sql
CREATE TABLE usuarios (
  id SERIAL PRIMARY KEY,
  nombre TEXT,
  correo TEXT,
  fecha_registro DATE
);
```

#### **3️⃣ Crea y usa un procedimiento para insertar usuarios**

```sql
CALL registrar_usuario('Luis Torres', 'luis@mail.com');
SELECT * FROM usuarios;
```

#### **4️⃣ Crea una función para calcular la edad**

```sql
SELECT calcular_edad('1995-06-15');
```

#### **5️⃣ Aplica control de transacciones**

```sql
BEGIN;
INSERT INTO usuarios(nombre, correo) VALUES ('Temporal', 'tmp@mail.com');
ROLLBACK; -- no se guarda

BEGIN;
INSERT INTO usuarios(nombre, correo) VALUES ('Definitivo', 'def@mail.com');
COMMIT; -- sí se guarda
```

---

### 🔗 **Recursos externos recomendados**

* **[Triggers, Procedimientos y Funciones en SQL](https://josejuansanchez.org/bd/unidad-12-teoria/index.html)**
* **[Funciones y procedimientos en PostgreSQL (PostgreSQL Docs)](https://www.postgresql.org/docs/current/plpgsql-structure.html)**
* **[GRANT y REVOKE en SQL (Oracle)](https://docs.oracle.com/cd/B28359_01/server.111/b28286/statements_9013.htm)**
* **[Transacciones en SQL: COMMIT, ROLLBACK, SAVEPOINT (GeeksForGeeks)](https://www.geeksforgeeks.org/sql-transaction-control-language-tcl-commands/)**
* **[Create Procedure SQL (MySQL)](https://dev.mysql.com/doc/refman/8.0/en/create-procedure.html)**
* **[Create Function SQL (PostgreSQL)](https://www.postgresql.org/docs/current/sql-createfunction.html)**
* **[Create View SQL (Microsoft)](https://learn.microsoft.com/es-es/sql/relational-databases/views/create-views?view=sql-server-ver16)**
* **[Delimiter in SQL Functions](https://www.mysqltutorial.org/mysql-stored-procedure/mysql-delimiter/)**
* **[Video explicativo sobre funciones y procedimientos en PostgreSQL (YouTube)](https://www.youtube.com/watch?v=OGMql4V3GdI)**
* **[Tipos de comandos en SQL (YouTube)](https://www.youtube.com/watch?v=fC266fitT9g)**

---

### 🎯 **Conclusión**

Conocer TCL y DCL te permite **mantener la integridad de tus datos** y **gestionar la seguridad** de tus bases de datos. Por otro lado, las **funciones** y **procedimientos** te ayudan a **modularizar la lógica**, ahorrar tiempo y evitar errores.

Excelente pregunta. El fragmento `AS $$ ... $$` se usa **para delimitar el bloque de código en funciones y procedimientos** en PostgreSQL, especialmente cuando usas el lenguaje `PL/pgSQL`.

---













¡Claro! A continuación, te presento una guía detallada sobre **TCL, DCL, funciones, procedimientos y vistas en SQL**, utilizando el formato 80/20 para que comprendas el 80% de la información con el 20% de lectura, acompañada de ejemplos prácticos y enlaces externos para profundizar.

---

### 🔐 **¿Qué es DCL (Data Control Language)?**

DCL es el subconjunto de SQL que gestiona los permisos y accesos a los objetos de la base de datos.([blog.walthercuro.com][1])

---

### 📌 **Comandos principales de DCL**

* **GRANT**: Otorga permisos a usuarios o roles.
* **REVOKE**: Revoca permisos previamente otorgados.

**Ejemplo**: Otorgar y revocar permisos en la tabla `clientes`.

```sql
-- Otorgar permisos
GRANT SELECT, INSERT ON clientes TO usuario1;

-- Revocar permisos
REVOKE INSERT ON clientes FROM usuario1;
```



---

### 🔄 **¿Qué es TCL (Transaction Control Language)?**

TCL permite controlar las transacciones en la base de datos, asegurando la integridad de los datos.([blog.walthercuro.com][1])

---

### 📌 **Comandos principales de TCL**

* **COMMIT**: Guarda los cambios realizados en una transacción.
* **ROLLBACK**: Deshace los cambios realizados en una transacción.
* **SAVEPOINT**: Establece un punto dentro de una transacción al que se puede volver.([Platzi][2])

**Ejemplo**: Uso de transacciones en la tabla `clientes`.([Platzi][2])





---

### 🧮 **¿Qué es una función en SQL?**

Una función es un bloque de código que realiza una operación y devuelve un valor. Se utiliza para encapsular lógica reutilizable.([Wikipedia][3])

---

### 📌 **Sintaxis básica para crear una función**

```sql
CREATE FUNCTION nombre_funcion (parametros)
RETURNS tipo_dato
AS
BEGIN
    -- Cuerpo de la función
    RETURN valor;
END;
```



**Ejemplo**: Función que calcula el IVA de un monto dado.

```sql
CREATE FUNCTION calcular_iva(@monto DECIMAL(10,2))
RETURNS DECIMAL(10,2)
AS
BEGIN
    RETURN @monto * 0.21;
END;
```



---

### 🛠️ **¿Qué es un procedimiento almacenado en SQL?**

Un procedimiento almacenado es un conjunto de instrucciones SQL que se almacenan en la base de datos y se pueden ejecutar cuando se necesiten.([Wikipedia][3])

---

### 📌 **Sintaxis básica para crear un procedimiento**





**Ejemplo**: Procedimiento que actualiza el saldo de un cliente.

```sql
CREATE PROCEDURE actualizar_saldo(@id_cliente INT, @nuevo_saldo DECIMAL(10,2))
AS
BEGIN
    UPDATE clientes SET saldo = @nuevo_saldo WHERE id = @id_cliente;
END;
```



---



---

### 🚀 **Guía paso a paso para crear una función en SQL Server**

1. **Abrir SQL Server Management Studio (SSMS)**.
2. **Conectarse a la instancia de la base de datos**.
3. **Seleccionar la base de datos deseada**.
4. **Ir a "Programmability" > "Functions" > "Scalar-valued Functions"**.
5. **Hacer clic derecho y seleccionar "New Scalar-valued Function..."**.
6. **Escribir el código de la función en el editor**.
7. **Guardar y ejecutar el script para crear la función**.

---

### 📚 **Recursos adicionales**

* [Crear vistas en SQL Server](https://learn.microsoft.com/es-es/sql/relational-databases/views/create-views?view=sql-server-ver16)
* [Funciones definidas por el usuario en SQL](https://es.wikipedia.org/wiki/Funci%C3%B3n_definida_por_el_usuario)
* [Procedimientos almacenados en MySQL](https://josejuansanchez.org/bd/unidad-12-teoria/index.html)

---

### 🎯 **Conclusión**

Comprender y utilizar adecuadamente **TCL, DCL, funciones, procedimientos y vistas** es esencial para la gestión eficiente y segura de bases de datos. Estos elementos permiten controlar transacciones, gestionar permisos, encapsular lógica reutilizable y simplificar consultas complejas.

Si deseas profundizar más en estos temas, te recomiendo el siguiente video:

[Aprende DDL, DML, DCL, TCL y DQL - YouTube](https://www.youtube.com/watch?v=fC266fitT9g&utm_source=chatgpt.com)

---

[1]: https://blog.walthercuro.com/sql-ddl-dml-dcl-y-tcl/?utm_source=chatgpt.com "SQL – DDL, DML, DCL y TCL - Apuntes de Walther Curo"
[2]:  ""
[3]: https://es.wikipedia.org/wiki/PL/SQL?utm_source=chatgpt.com "PL/SQL"
[4]: https://www.urianviera.com/sql/vistas-y-procedimientos-almacenados-en-sql?utm_source=chatgpt.com "Vistas y Procedimientos Almacenados en SQL - Urian Viera"
