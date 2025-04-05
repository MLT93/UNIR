# **📌 ¿Qué es JDBC?**

**JDBC (Java Database Connectivity)** es una API de Java que permite interactuar con bases de datos desde una aplicación Java. Facilita la conexión, ejecución de consultas, y manipulación de datos en bases de datos mediante un conjunto de interfaces y clases. JDBC proporciona un mecanismo estándar para realizar operaciones de bases de datos en Java como el famoso CRUD (Create, Read, Update, Delete) para crear, leer, actualizar o borrar registros en las tablas de la base de datos.

### **📌 Componentes Clave de JDBC**

En JDBC, los componentes principales son:

1. **Driver JDBC**:  
   Un controlador específico para cada tipo de base de datos que implementa la interfaz de JDBC. Este permite a Java comunicarse con la base de datos de manera eficiente.

2. **Connection**:  
   Representa la conexión a la base de datos. A través de esta conexión, puedes crear `Statement`, `PreparedStatement`, o `CallableStatement` para ejecutar las consultas SQL.

3. **Statement/PreparedStatement**:  
   Se utilizan para ejecutar las consultas SQL. `PreparedStatement` es más seguro y eficiente, ya que permite la ejecución de consultas con parámetros.

4. **ResultSet**:  
   Es el objeto que contiene los resultados de las consultas de tipo `SELECT`. Permite iterar sobre las filas devueltas por la base de datos.

5. **SQLException**:  
   Las excepciones en JDBC se manejan con `SQLException`. Este objeto se lanza cuando ocurre un error en cualquier etapa del proceso JDBC.

6. **rowAffected**:  
   Es una variable que se utiliza para obtener el número de filas que se han visto afectadas por una consulta SQL (como un `INSERT`, `UPDATE` o `DELETE`). Es útil para saber si una consulta de modificación de datos ha tenido éxito o si ha cambiado algo en la base de datos.

---

### **📌 Flujo Básico de Trabajo con JDBC**

1. **Cargar el Driver JDBC**:  
   Primero se debe cargar el controlador correspondiente de la base de datos.

   ```java
   Class.forName("com.mysql.cj.jdbc.Driver"); // Cargar el driver para MySQL
   ```

2. **Establecer la conexión a la base de datos**:  
   Se establece la conexión utilizando `DriverManager`.

   ```java
   Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/mi_db", "usuario", "password");
   ```

3. **Crear un `PreparedStatement`**:  
   Una vez establecida la conexión, se crea un `PreparedStatement` para ejecutar consultas SQL. Usamos `PreparedStatement` para evitar inyecciones SQL y mejorar la eficiencia con parámetros dinámicos con una nomenclatura particular. 
   
   Para asignar valores en la consulta sql se utiliza `?` como variable (marcador de parámetro) y luego una función set + el tipo de dato (ej. ps.setInt, ps.setString...). El primer argumento de la función es el primer `?` que aparece en la consulta sql (el valor comienza siempre en 1, no en 0).

   ```java
   String sql = "SELECT * FROM usuarios WHERE id = ?";
   PreparedStatement ps = conexion.prepareStatement(sql);
   ps.setInt(1, 1);  // Establecer el parámetro en la consulta SQL
   ```

   ```java
   String sql = "SELECT * FROM jefes WHERE puesto = ? AND cargo = ?";
   PreparedStatement ps = conexion.prepareStatement(sql);
   ps.setString(1, "Ayudante");  // Establecer el primer parámetro en la consulta SQL
   ps.setString(2, "IT");  // Establecer el segundo parámetro en la consulta SQL
   ```

4. **Ejecutar la consulta**:  
   Si estamos ejecutando una consulta de tipo `SELECT`, obtenemos un `ResultSet`. Si es una consulta de tipo `UPDATE`, `DELETE`, o `INSERT`, usamos `executeUpdate()` para obtener el número de filas afectadas.

   ```java
   ResultSet rs = ps.executeQuery();  // Para consultas SELECT
   int rowAffected = ps.executeUpdate();  // Para consultas UPDATE, DELETE, INSERT
   ```

5. **Procesar los resultados**:  
   Para consultas `SELECT`, iteramos sobre el `ResultSet` y extraemos los valores de las columnas.

   ```java
   while (rs.next()) {
       int id = rs.getInt("id");
       String nombre = rs.getString("nombre");
       System.out.println("ID: " + id + ", Nombre: " + nombre);
   }
   ```

   Para consultas `UPDATE`, `INSERT`, o `DELETE`, evaluamos el valor de `rowAffected` para ver cuántas filas han sido afectadas.

   ```java
   if (rowAffected > 0) {
       System.out.println(rowAffected + " filas fueron afectadas.");
   } else {
       System.out.println("No se realizaron cambios en la base de datos.");
   }
   ```

6. **Cerrar los recursos**:  
   Es importante cerrar la conexión, el `PreparedStatement`, y el `ResultSet` después de usarlos para evitar fugas de recursos.

   ```java
   rs.close();
   ps.close();
   conexion.close();
   ```

---

### **📌 Ejemplo de Uso de JDBC con `rowAffected`**

A continuación, un ejemplo donde ejecutamos una consulta `UPDATE` y utilizamos `rowAffected` para ver cuántas filas fueron modificadas en la base de datos.

```java
import java.sql.*;

public class JdbcExample {
    public static void main(String[] args) {
        // Cargar el controlador para MySQL
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecer la conexión a la base de datos
            Connection conexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mi_db", "usuario", "password");

            // Crear la consulta SQL para actualizar un registro
            String sql = "UPDATE usuarios SET nombre = ? WHERE id = ?";
            PreparedStatement ps = conexion.prepareStatement(sql);

            // Establecer los parámetros de la consulta
            ps.setString(1, "Nuevo Nombre");
            ps.setInt(2, 1);  // Modificar el usuario con id = 1

            // Ejecutar la consulta de actualización
            int rowAffected = ps.executeUpdate();  // Obtiene el número de filas afectadas

            // Evaluar si hubo cambios
            if (rowAffected > 0) {
                System.out.println(rowAffected + " filas fueron afectadas.");
            } else {
                System.out.println("No se realizaron cambios en la base de datos.");
            }

            // Cerrar los recursos
            ps.close();
            conexion.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
```

### **📌 Explicación del Código:**

1. **`ps.executeUpdate()`**:  
   Este método se usa para ejecutar consultas `UPDATE`, `INSERT` o `DELETE`. En lugar de un `ResultSet`, devuelve un entero que indica cuántas filas fueron afectadas por la consulta. Este valor se almacena en la variable `rowAffected`.

2. **`rowAffected > 0`**:  
   Si `rowAffected` es mayor que 0, significa que la consulta ha modificado (o insertado/eliminado) al menos una fila en la base de datos. Si es 0, significa que no hubo cambios.

3. **`PreparedStatement`**:  
   Es utilizado para ejecutar consultas con parámetros, protegiendo contra ataques de inyección SQL y mejorando la eficiencia de las consultas repetitivas.

---

### **📌 Importancia de `rowAffected`**

El atributo `rowAffected` es clave en los casos donde estamos realizando operaciones que modifican los datos en la base de datos (`UPDATE`, `INSERT`, `DELETE`). Nos ayuda a:

- **Verificar si los cambios fueron exitosos**: Si el valor de `rowAffected` es mayor que 0, significa que las filas en la base de datos fueron modificadas.
- **Controlar el flujo del programa**: Dependiendo de cuántas filas se vean afectadas, puedes tomar decisiones, como mostrar un mensaje de éxito o realizar otras acciones.
- **Evaluar la consistencia de los datos**: Si esperabas que una consulta afectara a varias filas pero `rowAffected` es 0, podría indicar que algo no salió como esperabas (por ejemplo, que no se encontró ninguna fila que coincida con la condición del `WHERE`).

---

### **📌 Conclusión**

JDBC es una herramienta poderosa que permite a las aplicaciones Java interactuar con bases de datos. Al utilizar `PreparedStatement` y `rowAffected`, puedes mejorar la seguridad, eficiencia y control sobre las operaciones de bases de datos en tu aplicación.
