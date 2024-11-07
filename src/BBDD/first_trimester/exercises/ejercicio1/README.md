# Enunciado
 
Tenemos una tienda donde se venden una serie de productos y necesitamos almacenar datos de las facturas que se emiten. El funcionamiento principal del modelo es el siguiente.
 
- En cada venta se pueden vender varios productos y se emite una factura. 
- De las facturas necesitamos el DNI y nombre del cliente, la fecha, el importe y el número de factura que identificará a la factura de forma única. 
- Relacionado con la factura que emitimos en nuestra tienda es necesario almacenar los productos que se han comprado y se han incluido en esa factura, o sea, las líneas de factura. 
- Necesitamos saber el código de cada producto, el nombre del producto, el importe y la cantidad de artículos de ese producto.
 
Se pide:
- Crear el modelo E/R con las entidades y atributos correspondientes.
- Identificar el atributo clave de cada entidad.
- Indicar el dominio de cada uno de los atributos.
- Identificar de qué tipo es cada uno de los atributos de las entidades (derivado, compuesto...).
- Crear las relaciones oportunas.
- Poner la cardinalidad a las relaciones.


### Paso 1: Identificar Entidades y Atributos

Basándonos en los requisitos, identificaremos las **entidades** necesarias y sus **atributos clave**.

1. **Factura**
   - **Atributo clave:** `num_factura` (clave primaria).
   - **Atributos**:
     - `dni_cliente` (Texto).
     - `nombre_cliente` (Texto).
     - `fecha` (Fecha).
     - `importe_total` (Decimal) - Atributo **derivado**, calculado a partir de las líneas de factura.
   - **Tipo de atributos**:
     - `importe_total` es **derivado**.

2. **Producto**
   - **Atributo clave:** `cod_producto` (clave primaria).
   - **Atributos**:
     - `nombre_producto` (Texto).
     - `precio_unitario` (Decimal).
   - **Tipo de atributos**: Todos son **simples**.

3. **linea_factura** (para representar los productos incluidos en una factura)
   - **Atributo clave:** `num_linea_factura` (clave primaria compuesta por `num_factura` + `cod_producto` en el esquema relacional).
   - **Atributos**:
     - `cantidad` (Entero).
     - `importe_linea` (Decimal) - Atributo **derivado**, calculado como `cantidad * precio_unitario`.
   - **Tipo de atributos**:
     - `importe_linea` es **derivado**.

### Paso 2: Crear Relaciones y Cardinalidades

1. **Factura -> almacenar linea_factura**:
   - Relación **1:N** (una factura puede almacenar muchas líneas, pero cada línea pertenece a una sola factura).
   - En el esquema relacional, `num_factura` será una **clave foránea** en **linea_factura**.

2. **almacenar linea_factura -> Producto**:
   - Relación **N:1** (una línea de factura puede almacenar un solo producto, pero un producto puede aparecer en muchas líneas de diferentes facturas).
   - En el esquema relacional, `cod_producto` será una **clave foránea** en **linea_factura**.

En el diagrama E/R, **linea_factura** se puede representar como una Entidad de relación (en forma de diamante) que conecta las entidades Factura y Producto. En este caso, **linea_factura no solo es una relación, sino que también actúa como una entidad que almacena información adicional sobre cada producto** en cada factura, como la cantidad y el importe de la línea.

### Paso 3: Diagrama E/R con Cardinalidades

En el diagrama E/R:

- **Factura** se conecta a **linea_factura** con una relación de **1:N**. Esto implica que el `num_factura` será una clave foránea en **linea_factura** en la implementación relacional.
- **Producto** se conecta a **linea_factura** con una relación de **1:N**. Esto implica que el `cod_producto` será una clave foránea en **linea_factura** en la implementación relacional.

---

### Ejemplo en Texto del Diagrama E/R

Para visualizarlo de forma más estructurada:

```
Factura (num_factura, dni, nombre_cliente, fecha, importe_total)
   │
   │ 1:N
   │
Relación "Almacenar" [donde deriva linea_factura (num_linea_factura, cantidad, importe_linea) al ser una relación N:M]
   │
   │ N:1
   │
Producto (cod_producto, nombre_producto, precio_unitario)
```

En este diseño:

- `num_factura` y `cod_producto` actuarán como **claves foráneas implícitas** en la entidad **linea_factura** en el modelo relacional.
- **linea_factura** se comporta como la tabla intermedia para la relación entre **Factura** y **Producto** y también representa las **líneas de factura**.

### Resumen

Este enfoque en el diagrama E/R implica los siguientes pasos al migrar a un esquema relacional:

1. **Factura** y **Producto** se mantienen como tablas independientes con sus claves primarias (`num_factura` y `cod_producto`).
2. **linea_factura** contiene las claves foráneas `num_factura` y `cod_producto` para representar las relaciones de **1:N** y **N:1** respectivamente.
