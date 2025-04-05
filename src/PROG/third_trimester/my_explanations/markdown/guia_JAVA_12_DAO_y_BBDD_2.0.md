# **📌 Explicación y Código con Comentarios Detallados**

## 📌 **Conceptos Importantes en JDBC**

### **🔹 `preparedStatement (ps)`**

✔️ Se usa en lugar de `Statement` porque:

- Evita **inyección SQL** al utilizar **parámetros (`?`)** en lugar de concatenaciones de cadenas.
- Mejora el **rendimiento** al permitir la reutilización de la consulta.
- Es más seguro y eficiente.

### **🔹 `resultSet (rs)`**

✔️ Contiene los datos devueltos por la consulta SQL.  
✔️ Se usa en combinación con `while(rs.next())` para iterar sobre los resultados.

### **🔹 `sql`**

✔️ Variable que almacena la consulta SQL a ejecutar.  
✔️ Se usa en conjunto con `preparedStatement`.

### **🔹 `rowsAffected`**

✔️ Guarda el número de filas afectadas en operaciones **INSERT, UPDATE o DELETE**.  
✔️ Si `rowsAffected == 0`, significa que la consulta no tuvo efecto.

---

## **1️⃣ Clase `Usuario`**

```java
import java.io.Serializable;
import java.util.Objects;

public class Usuario implements Serializable {
    // Atributos
    private static final long serialVersionUID = 1L;

    private int usuarioID;
    private String usuarioNombre;
    private String usuarioEmail;

    // Constructor con todo
    public Usuario(int id, String nombre, String email) {
        super();

        this.usuarioID = id;
        this.usuarioNombre = nombre;
        this.usuarioEmail = email;
    }

    // Constructor con nada
    public Usuario() {
        super();
    }

    // getters & setters (quitando serialVersionUID)
    public int getId() { return usuarioID; }
    public String getNombre() { return usuarioNombre; }
    public String getEmail() { return usuarioEmail; }

    public void setId(int id) { this.usuarioID = id; }
    public void setNombre(String nombre) { this.usuarioNombre = nombre; }
    public void setEmail(String email) { this.usuarioEmail = email; }

    // equals & hashCode (con la Primary Key de la Tabla)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) obj;
        return usuarioID == other.usuarioID;
    }

    // toString (con todo, para los tests)
    @Override
    public String toString() {
        return "Usuario [ID=" + this.usuarioID + " NOMBRE=" + this.usuarioNombre + " EMAIL=" + this.usuarioEmail + "]";
    }
}
```

### **Explicación**

- **`Usuario`**:
  - Es una clase **POJO (Plain Old Java Object)** que representa en código JAVA una Tabla de la BBDD.

---

## **2️⃣ Singleton para la Conexión (`InstanceBbdd`)**

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class InstanceBbdd {
    private static Connection conexion;   // Conexión única compartida

    // Constantes para la URL de conexión, usuario y contraseña
    private final String URL = "jdbc:mysql://localhost:3306/mi_db";
    private final String USUARIO = "usuario";
    private final String PASSWORD = "password";

    // 🔹 Constructor privado para evitar la creación de múltiples instancias
    private InstanceBbdd() {
        try {
            // Establece la conexión única a la base de datos
            conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
            System.out.println("CONEXIÓN ESTABLECIDA");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("CONEXIÓN no ESTABLECIDA");
        }
    }

    // 🔹 Método estático que permite obtener la instancia única del Singleton
    public static Connection getConexion() {
        if (conexion == null) {
            // Si la conexión aún no ha sido creada, la crea
            new InstanceBbdd();
        }
        return conexion;
    }
}
```

### **Explicación**

- **`private InstanceBbdd()`**: El **constructor es `private`** para evitar que se creen instancias adicionales de la clase fuera del Singleton. Esto asegura que solo haya **una única instancia de `InstanceBbdd`**, que administra la conexión a la base de datos.
- **`public static synchronized InstanceBbdd getInstance()`**:

  - El **método es `static`** para poder acceder a él sin tener que crear un objeto `InstanceBbdd` primero.
  - **`synchronized`** asegura que el método sea seguro para hilos concurrentes, garantizando que solo una instancia del Singleton se cree incluso en aplicaciones multihilo.

- **`static`**: Las funciones y atributos son **estáticos** porque deben ser compartidos entre todos los objetos de la aplicación sin necesidad de instanciarlos. Esto hace que el Singleton pueda mantener una única conexión durante toda la ejecución.

---

## **3️⃣ Clase Abstracta para DAO (`AbsLlamadaBbddGenerica`)**

```java
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class AbsLlamadaBbddGenerica {
    protected Connection conexion; // Conexión desde el Singleton
    protected PreparedStatement ps; // Quien prepara la sentencia y la ejecuta en el motor de la BBDD
    protected ResultSet rs; // Lee el fichero secuencial generado por el motor de la BBDD
    protected String sql; // La consulta SQL
    protected int rowsAffected; // Las filas afectadas por la consulta. Esto me ayuda a determinar si ha sido exitosa o menos

    // 🔹 Constructor para inicializar la conexión utilizando Singleton
    public AbsLlamadaBbddGenerica() {
        // Establece la conexión única a la base de datos desde el Singleton
        this.conexion = InstanceBbdd.getConexion();
    }
}
```

### **Explicación**

- **`extends AbsLlamadaBbddGenerica`**:
  - Cada **DAO (como `UsuarioDaoImpl`) extiende esta clase abstracta** para obtener la conexión a la base de datos de forma centralizada. Esto evita que cada clase DAO tenga que crear su propia conexión, haciendo el código más limpio y eficiente.

---

## **4️⃣ Interfaz `IUsuarioDao`**

```java
import java.util.List;

public interface IUsuarioDao {
    void agregarUsuario(Usuario usuario);
    Usuario obtenerUsuarioPorId(int id);
    List<Usuario> obtenerTodosLosUsuarios();
    void actualizarUsuario(Usuario usuario);
    void eliminarUsuario(int id);
}
```

### **Explicación**

- **`implements IUsuarioDao`**:
  - Las clases que implementan esta interfaz deben proporcionar **implementaciones específicas** para los métodos definidos en la interfaz, como `agregarUsuario`, `obtenerUsuarioPorId`, etc.
  - Esto se encarga de definir las llamadas a la Tabla específica de la BBDD.

---

## **5️⃣ Implementación `UsuarioDaoImpl`**

```java
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDaoImpl extends AbsLlamadaBbddGenerica implements IUsuarioDao {

    // Recibo todos los métodos de mis otras clases donde tengo la conexión y los métodos necesarios
    // No haría falta crear constructor porque lo tenemos por defecto, que sería un constructor sin nada con el super(); que llama al padre (la clase abstracta)

    @Override
    public void agregarUsuario(Usuario usuario) {
        sql = "INSERT INTO usuarios (nombre, email) VALUES (?, ?)"; // Consulta SQL
        rowsAffected = 0; // Inicializa el número de filas afectadas

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            // 🔹 Asignamos los valores de los parámetros (?) en la consulta SQL
            ps.setString(1, usuario.getNombre()); // Se asigna el nombre del usuario al primer '?'
            ps.setString(2, usuario.getEmail());  // Se asigna el email del usuario al segundo '?'

            rowsAffected = ps.executeUpdate(); // 🔹 Ejecuta la consulta (INSERT) y obtiene el número de filas afectadas
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(rowsAffected > 0 ? "Usuario agregado correctamente." : "Error al agregar usuario.");
    }

    @Override
    public Usuario obtenerUsuarioPorId(int id) {
        sql = "SELECT * FROM usuarios WHERE id = ?"; // Consulta SQL
        Usuario usuario = null;

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id); // 🔹 Asignamos el valor de `id` al primer '?'
            ResultSet rs = ps.executeQuery(); // 🔹 Ejecuta la consulta (SELECT)

            if (rs.next()) {
                usuario = new Usuario(rs.getInt("id"), rs.getString("nombre"), rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuario;
    }

    @Override
    public List<Usuario> obtenerTodosLosUsuarios() {
        this.sql = "SELECT * FROM usuarios"; // Consulta SQL

        try {
            this.ps = this.conexion.prepareStatement(sql);
            this.rs = this.ps.executeQuery() // 🔹 Ejecuta la consulta (SELECT)

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        String sql = "UPDATE usuarios SET nombre = ?, email = ? WHERE id = ?"; // Consulta SQL
        int numFilas = 0;

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, usuario.getNombre()); // Asigna el nombre del usuario
            ps.setString(2, usuario.getEmail());  // Asigna el email del usuario
            ps.setInt(3, usuario.getId());        // Asigna el ID del usuario

            numFilas = ps.executeUpdate(); // 🔹 Ejecuta la consulta (UPDATE)
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(numFilas > 0 ? "Usuario actualizado correctamente." : "Error al actualizar usuario.");
    }

    @Override
    public void eliminarUsuario(int id) {
        String sql = "DELETE FROM usuarios WHERE id = ?"; // Consulta SQL
        int numFilas = 0;

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id); // Asigna el ID del usuario a eliminar
            numFilas = ps.executeUpdate(); // 🔹 Ejecuta la consulta (DELETE)
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(numFilas > 0 ? "Usuario eliminado correctamente." : "No se encontró el usuario.");
    }
}
```

### **Explicación**

- **`ps.setString(1, usuario.getNombre())`** y **`ps.setInt(1, id)`**:

  - Se utilizan los **`?`** en las consultas SQL como **marcadores de posición**.
  - Los **marcadores de posición** se reemplazan con los valores correspondientes usando los métodos como `setString` y `setInt` de `PreparedStatement`.

- **`ResultSet rs = ps.executeQuery()`**:

  - **`executeQuery()`** se usa para **consultas SELECT**.
  - **`ResultSet`** contiene el resultado de la consulta, y puedes iterar sobre él con `while(rs.next())`.

- **`ps.executeUpdate()`**:
  - Se utiliza para **consultas INSERT, UPDATE y DELETE**, y devuelve el número de filas afectadas, lo cual es útil para comprobar si la operación fue exitosa.

---

## **✅ Conclusión**

- Cada **DAO maneja explícitamente las consultas SQL** usando `PreparedStatement`, `ResultSet`, `sql` y **el número de filas afectadas**.
- Las clases y métodos están estructurados para mantener un **código limpio y modular**, asegurando que la lógica de acceso a datos sea clara y reutilizable.
