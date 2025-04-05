# **🔹 Explicación y Código Mejorado**
Antes de ver el código, te explico los elementos clave usados en las consultas a la base de datos.

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

### **🔹 `rowAffected (numFilas)`**
✔️ Guarda el número de filas afectadas en operaciones **INSERT, UPDATE o DELETE**.  
✔️ Si `numFilas == 0`, significa que la consulta no tuvo efecto.  

---

## **1️⃣ Clase Singleton para la conexión (`InstanceBbdd`)**
```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class InstanceBbdd {
    private static InstanceBbdd instancia; // Instancia única del Singleton
    private static Connection conexion; // Única conexión compartida en toda la app

    private static final String URL = "jdbc:mysql://localhost:3306/mi_db";
    private static final String USUARIO = "usuario";
    private static final String PASSWORD = "password";

    // 🔹 Constructor privado para evitar que se creen instancias fuera de la clase
    private InstanceBbdd() {
        try {
            conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 🔹 Método estático para obtener la única instancia del Singleton
    public static synchronized InstanceBbdd getInstance() {
        if (instancia == null) {
            instancia = new InstanceBbdd();
        }
        return instancia;
    }

    // 🔹 Devuelve la conexión a la BBDD
    public static Connection getConexion() {
        return conexion;
    }
}
```
✔️ **Por qué el constructor es `private`?**  
- Para evitar múltiples instancias que podrían generar **errores en la conexión**.  

✔️ **Por qué los atributos y métodos son `static`?**  
- Para que se pueda acceder a la misma conexión sin necesidad de crear objetos nuevos.  

---

## **2️⃣ Clase Abstracta para Consultas Genéricas (`AbsLlamadaBbddGenerica`)**
```java
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class AbsLlamadaBbddGenerica {

    protected Connection conexion;

    public AbsLlamadaBbddGenerica() {
        this.conexion = InstanceBbdd.getInstance().getConexion();
    }

    // 🔹 Método genérico para ejecutar consultas INSERT, UPDATE y DELETE
    protected int ejecutarUpdate(String sql, Object... parametros) {
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            setParametros(ps, parametros);
            return ps.executeUpdate(); // 🔹 Devuelve el número de filas afectadas (numFilas)
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    // 🔹 Método genérico para ejecutar SELECT y devolver un ResultSet
    protected ResultSet ejecutarQuery(String sql, Object... parametros) {
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            setParametros(ps, parametros);
            return ps.executeQuery(); // 🔹 Devuelve el resultado de la consulta
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // 🔹 Método auxiliar para asignar parámetros a un PreparedStatement
    private void setParametros(PreparedStatement ps, Object... parametros) throws SQLException {
        for (int i = 0; i < parametros.length; i++) {
            ps.setObject(i + 1, parametros[i]);
        }
    }
}
```
✔️ **Evita repetir código en cada DAO**.  
✔️ **Reduce errores** al gestionar `preparedStatement` y parámetros de manera genérica.  

---

## **3️⃣ Interfaz `IUsuarioDao`**
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
✔️ Define la estructura sin implementar lógica.  

---

## **4️⃣ Implementación `UsuarioDaoImpl`**
```java
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDaoImpl extends AbsLlamadaBbddGenerica implements IUsuarioDao {

    @Override
    public void agregarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nombre, email) VALUES (?, ?)";
        int numFilas = ejecutarUpdate(sql, usuario.getNombre(), usuario.getEmail());

        System.out.println(numFilas > 0 ? "Usuario agregado correctamente." : "Error al agregar usuario.");
    }

    @Override
    public Usuario obtenerUsuarioPorId(int id) {
        String sql = "SELECT * FROM usuarios WHERE id = ?";
        try (ResultSet rs = ejecutarQuery(sql, id)) {
            if (rs != null && rs.next()) {
                return new Usuario(rs.getInt("id"), rs.getString("nombre"), rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Usuario> obtenerTodosLosUsuarios() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        try (ResultSet rs = ejecutarQuery(sql)) {
            while (rs != null && rs.next()) {
                lista.add(new Usuario(rs.getInt("id"), rs.getString("nombre"), rs.getString("email")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        String sql = "UPDATE usuarios SET nombre = ?, email = ? WHERE id = ?";
        int numFilas = ejecutarUpdate(sql, usuario.getNombre(), usuario.getEmail(), usuario.getId());

        System.out.println(numFilas > 0 ? "Usuario actualizado correctamente." : "Error al actualizar usuario.");
    }

    @Override
    public void eliminarUsuario(int id) {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        int numFilas = ejecutarUpdate(sql, id);

        System.out.println(numFilas > 0 ? "Usuario eliminado correctamente." : "No se encontró el usuario.");
    }
}
```
✔️ **Usa `ejecutarUpdate` y `ejecutarQuery`** de la clase abstracta.  
✔️ **Muestra mensajes según `numFilas`** para indicar el éxito de la operación.  

---

## **5️⃣ Clase `Usuario`**
```java
public class Usuario {
    private int id;
    private String nombre;
    private String email;

    public Usuario(int id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
}
```

---

## ✅ **Conclusión**
✔️ **Estructura modular y reutilizable**.  
✔️ **Menos código repetido** gracias a `AbsLlamadaBbddGenerica`.  
✔️ **Seguridad y eficiencia** con `preparedStatement`.  
