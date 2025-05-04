### 📌 **Conceptos Importantes en JDBC**

Antes de ver el código, te explico los elementos clave usados en las consultas a la base de datos.

#### **🔹 `preparedStatement (ps)`**

✔️ Se usa en lugar de `Statement` porque:

- Evita **inyección SQL** al utilizar **parámetros (`?`)** en lugar de concatenaciones de cadenas.
- Mejora el **rendimiento** al permitir la reutilización de la consulta.
- Es más seguro y eficiente.

#### **🔹 `resultSet (rs)`**

✔️ Contiene los datos devueltos por la consulta SQL.
✔️ Se usa en combinación con `while(rs.next())` para iterar sobre los resultados.

#### **🔹 `sql`**

✔️ Variable que almacena la consulta SQL a ejecutar.
✔️ Se usa en conjunto con `preparedStatement`.

#### **🔹 `rowAffected (numFilas)`**

✔️ Guarda el número de filas afectadas en operaciones **INSERT, UPDATE o DELETE**.
✔️ Si `numFilas == 0`, significa que la consulta no tuvo efecto.

---

### **1️⃣ Clase Singleton para la conexión (`Singleton`)**

- **[Singleton explanation in Pseudocode](https://refactoring.guru/design-patterns/singleton)**
- **[Singleton in JAVA](https://www.baeldung.com/java-singleton)**
- **[Accessing protected attributes in JAVA](https://www.geeksforgeeks.org/accessing-protected-members-in-java/)**

```java
package modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Singleton {

	static Singleton instance; // La única instancia de la conexión porque el constructor es privado

	private Connection conn; // Sirve para establecer la conexión con DriverManager a la BBDD
	private final String HTTP = "jdbc:mysql://localhost:3306/my_db"; // Dirección de la BBDD
	private final String USER = "user"; // Usuario de la BBDD
	private final String PASS = "password"; // Pass del usuario de la BBDD

	// Constructor privado
    private Singleton() {
    	super();
  
        try {
            conn = DriverManager.getConnection(HTTP, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	if (conn != null) {
        		System.out.println("Conexión establecida");
        	}
        }
    }

	public static Singleton getInstance() throws SQLException { // Función encargada de entregar el objeto con la conexión a la BBDD
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}

	public Connection getConn() {
		return conn;
	}

	public String getHTTP() {
		return HTTP;
	}

	public String getUSER() {
		return USER;
	}

	public String getPASS() {
		return PASS;
	}
}
```

✔️ **Por qué el constructor es `private`?**

- Para evitar múltiples instancias que podrían generar **errores en la conexión**.

✔️ **Por qué los atributos son `private` y el `getInstance()` es `static`?**

- Para que los atributos queden inaccesibles y para que la conexión guarde una única instancia.

#### **🧩 Análisis de tu implementación actual**

Arriba se ha implementado un Singleton con inicialización diferida (lazy initialization), lo cual es adecuado para casos donde la instancia puede no ser necesaria inmediatamente. Sin embargo, existen algunos aspectos que podrían mejorarse:

1. **Seguridad en entornos multi-hilo**: El método `getInstance()` no está sincronizado, lo que puede llevar a la creación de múltiples instancias en entornos multi-hilo.
2. **Manejo de excepciones**: El constructor maneja las excepciones de conexión, pero si la conexión falla, la instancia aún se crea, lo que puede llevar a errores posteriores al intentar usar una conexión nula.
3. **Encapsulamiento de la conexión**: Exponer directamente el objeto `Connection` puede ser riesgoso, ya que permite operaciones no controladas sobre la conexión.

#### **✅ Recomendaciones para mejorar tu Singleton**

#### **Implementar seguridad en entornos multi-hilo**

Para garantizar que solo se cree una instancia en entornos multi-hilo, puedes utilizar el patrón de **doble verificación de bloqueo (Double-Checked Locking)**:

```java
public class Singleton {
  
    private static volatile Singleton instance;
  
    private Connection conn;
    private final String HTTP = "jdbc:mysql://localhost:3306/my_db";
    private final String USER = "user";
    private final String PASS = "password";

    private Singleton() throws SQLException {
        conn = DriverManager.getConnection(HTTP, USER, PASS);
    }

    public static Singleton getInstance() throws SQLException {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() {
        return conn;
    }
}
```

---

### **🧠 Alternativa: Usar un `enum` para implementar el Singleton**

En entornos multi-hilo y para un mejor manejo de excepciones, se implementa el patrón de doble verificación de bloqueo o utilizar un `enum` para una solución más robusta y sencilla.**[The Singleton Pattern: Pros, Cons, and Best Practices - Medium](https://medium.com/%40nathanbyers13/the-singleton-pattern-pros-cons-and-best-practices-9e4d256132de)**.

Como mencioné anteriormente, utilizar un `enum` es una forma sencilla y segura de implementar un Singleton en Java:

```java
public enum Singleton {
    INSTANCE;

    private Connection conn;
    private final String HTTP = "jdbc:mysql://localhost:3306/mi_db";
    private final String USER = "user";
    private final String PASS = "password";

    Singleton() {
        try {
            conn = DriverManager.getConnection(HTTP, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return conn;
    }
}
```

---

### **2️⃣ Clase Abstracta para Consultas Genéricas (`AbsGenericCrud`)**

```java
package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class AbsGenericCrud<T, ID> {

	abstract List<T> findAll();
	abstract T findById(ID atributoPK);
	abstract int insertOne(T obj);
	abstract int updateOne(T obj);
	abstract int deleteById(ID atributoPK);
	
    protected Connection conn;    
    protected PreparedStatement ps; // Quien prepara la sentencia y la ejecuta en el motor de la BBDD
    protected ResultSet rs; // Lee el fichero secuencial generado por el motor de la BBDD
    protected String sql; // La consulta SQL (opcional)
    protected int rowsAffected; // Las filas afectadas por la consulta. Esto me ayuda a determinar si ha sido exitosa o menos

    // Constructor
    public AbsGenericCrud() {
        try {
			this.conn = Singleton.getInstance().getConn(); // Acá me conecto con el Singleton
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    /*  
     * Evita la inyección SQL asignando a cada '?' (que según su asignación se le atribuye un número como índice, 
     * empezando por el 1, luego el 2, el 3, 4, 5, etc...). Entonces, recorre los parámetros y los asigna a 'ps' 
     * usando un 'setObject' que permite la asignación genérica para varios interrogantes
    */
    private void setValueInterroganteQuery(PreparedStatement ps, Object... valueInterroganteQuery) throws SQLException {
        for (int i = 0; i < valueInterroganteQuery.length; i++) {
            ps.setObject(i + 1, valueInterroganteQuery[i]);
        }
    }

    // Ejecutar query SQL
    public ResultSet executeQuery(String sql, Object... valueInterroganteQuery) {
        try {
            ps = conn.prepareStatement(sql);
            setValueInterroganteQuery(ps, valueInterroganteQuery);
            rs = ps.executeQuery(); // Devuelve el resultado de la consulta
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
```

✔️ **Ejemplo:**

```sql
INSERT INTO empleados (nombre, edad, salario) VALUES (?, ?, ?)
```

```java
String sql = "INSERT INTO empleados (nombre, edad, salario) VALUES (?, ?, ?)";
PreparedStatement ps = conn.prepareStatement(sql);
setValueInterroganteQuery(ps, "Ana", 30, 45000.00); // Podemos agregar más de un valor a cada '?'
ps.executeUpdate();
```

✔️ **Evita repetir código en cada DAO**.
✔️ **Reduce errores** al gestionar `preparedStatement` y parámetros de manera genérica.

---

### **3️⃣ Interfaz `IUsuarioDao`**

```java
import java.util.List;

public interface IUsuarioDao {
    List<Usuario> buscarPorEmpiezaEnName(String cadena);
    List<Usuario> buscarPorDNI(String cadena);
}
```

✔️ Define la estructura sin implementar lógica.

---

### **4️⃣ Implementación `UsuarioDaoImpl`**

```java
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDaoImpl extends AbsGenericCrud implements IUsuarioDao {

    @Override
    public void insertOne(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nombre, email) VALUES (?, ?)";
        int numFilas = executeQuery(sql, usuario.getNombre(), usuario.getEmail());

        System.out.println(numFilas > 0 ? "Usuario agregado correctamente." : "Error al agregar usuario.");
    }

    @Override
    public Usuario findById(int id) {
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

### **5️⃣ Clase `Usuario`**

```java
import java.io.Serializable;
import java.util.Objects;

public class Usuario implements Serializable {
    // Atributos
    @Serial
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
