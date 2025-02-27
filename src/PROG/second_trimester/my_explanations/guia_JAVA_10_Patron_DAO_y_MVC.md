## **🔥 Guía Completa sobre DAO (Data Access Object) en Eclipse con Java 21 🔥**

### **1️⃣ Introducción al Patrón DAO en Java**

El **Patrón DAO (Data Access Object)** es un patrón de diseño que permite separar la lógica de acceso a datos de la lógica de negocio en una aplicación. Esto facilita la **mantenibilidad**, **modularidad** y **reutilización del código** en proyectos que interactúan con bases de datos. [Patrón DAO](http://reactiveprogramming.io/blog/es/patrones-arquitectonicos/dao) | [Stack-Overflow DAO](https://es.stackoverflow.com/questions/217518/duda-sobre-mvc-dao-en-java).

#### **¿Por qué usar el Patrón DAO?**

1. **Separación de responsabilidades**: Mantiene el código organizado al separar la lógica de acceso a la base de datos de la lógica del negocio.
2. **Facilita la escalabilidad**: Permite modificar la capa de persistencia sin afectar otras partes de la aplicación.
3. **Código más limpio y reutilizable**: Los métodos de acceso a datos pueden ser reutilizados sin duplicación de código.

---

### **2️⃣ Configuración del Entorno en Eclipse con Java 21**

Para usar DAO en un proyecto en **Eclipse con Java 21**, sigue estos pasos:

1. **Crear un Proyecto Java en Eclipse**

   - Abre **Eclipse** y selecciona: `File` → `New` → `Java Project`
   - Asigna un nombre al proyecto, por ejemplo, `DAOExample`
   - Asegúrate de seleccionar **Java 21** como JDK.
2. **Agregar JDBC Driver** (si usas bases de datos como MySQL, PostgreSQL, etc.)

   - Descarga el **driver JDBC** correspondiente (`mysql-connector-java-xx.jar`, `postgresql-xx.jar`, etc.).
   - Añádelo a las librerías del proyecto en Eclipse:
     - Click derecho en el proyecto → `Build Path` → `Add External JARs...`
     - Selecciona el archivo `.jar` descargado.

---

### **3️⃣ Creando una Clase Modelo (Entidad)**

Primero, definimos una clase `Usuario` que representará nuestra tabla en la base de datos.

```java
public class Usuario {
    private int id;
    private String nombre;
    private String email;

    public Usuario() {}

    public Usuario(int id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "Usuario{id=" + id + ", nombre='" + nombre + "', email='" + email + "'}";
    }
}
```

📌 **Esta clase representa un usuario con tres atributos: `id`, `nombre`, y `email`.**

---

### **4️⃣ Creando la Interfaz DAO (Definición de Métodos)**

El siguiente paso es definir una **interfaz `UsuarioDAO`** con los métodos para acceder a la base de datos.

```java
import java.util.List;

public interface UsuarioDAO {
    void insertar(Usuario usuario);
    Usuario obtenerPorId(int id);
    List<Usuario> obtenerTodos();
    void actualizar(Usuario usuario);
    void eliminar(int id);
}
```

📌 **Esta interfaz define los métodos CRUD (Create, Read, Update, Delete) que deben ser implementados.**

---

### **5️⃣ Implementando DAO con JDBC**

Ahora implementamos la interfaz en una clase `UsuarioDAOImpl` que se conectará a la base de datos.

```java
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOImpl implements UsuarioDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/mi_base";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "123456";

    public UsuarioDAOImpl() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Cargar el driver JDBC
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertar(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nombre, email) VALUES (?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Usuario obtenerPorId(int id) {
        String sql = "SELECT * FROM usuarios WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Usuario(rs.getInt("id"), rs.getString("nombre"), rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Usuario> obtenerTodos() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                usuarios.add(new Usuario(rs.getInt("id"), rs.getString("nombre"), rs.getString("email")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    @Override
    public void actualizar(Usuario usuario) {
        String sql = "UPDATE usuarios SET nombre = ?, email = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getEmail());
            stmt.setInt(3, usuario.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
```

📌 **Esta implementación maneja las operaciones CRUD con JDBC de manera eficiente.**

---

### **6️⃣ Probando el DAO en `main()`**

Finalmente, probamos nuestra implementación en el método `main()`.

```java
public class Main {
    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

        // Insertar usuario
        Usuario nuevoUsuario = new Usuario(0, "Juan Pérez", "juan@example.com");
        usuarioDAO.insertar(nuevoUsuario);
        System.out.println("Usuario insertado.");

        // Obtener usuario por ID
        Usuario usuario = usuarioDAO.obtenerPorId(1);
        System.out.println("Usuario obtenido: " + usuario);

        // Obtener todos los usuarios
        System.out.println("Lista de usuarios:");
        usuarioDAO.obtenerTodos().forEach(System.out::println);

        // Actualizar usuario
        if (usuario != null) {
            usuario.setNombre("Juan P. Actualizado");
            usuarioDAO.actualizar(usuario);
            System.out.println("Usuario actualizado.");
        }

        // Eliminar usuario
        usuarioDAO.eliminar(1);
        System.out.println("Usuario eliminado.");
    }
}
```

📌 **Este código prueba la funcionalidad de nuestro DAO.**

---

### **7️⃣ Conclusión**

El **Patrón DAO en Java** ayuda a organizar el acceso a bases de datos separando la lógica de negocio de la lógica de persistencia.

✅ **Ventajas del DAO:**

- Código modular y reutilizable.
- Separación de responsabilidades.
- Mayor facilidad de mantenimiento.

---

### **🔍 Diferencias entre DAO y MVC**

El **Patrón DAO (Data Access Object)** está relacionado con el **Patrón MVC (Modelo-Vista-Controlador)**, pero tienen propósitos diferentes y complementarios.

| **Característica**   | **DAO (Data Access Object)**                                       | **MVC (Modelo-Vista-Controlador)**                                                                                             |
| --------------------------- | ------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------ |
| **Propósito**        | Gestiona la lógica de acceso a la base de datos.                        | Separa la lógica de la aplicación en tres capas (Modelo, Vista, Controlador).                                                      |
| **Ubicación en MVC** | Generalmente, es parte del**Modelo** en MVC.                       | Es una arquitectura completa con tres capas.                                                                                         |
| **Responsabilidad**   | Se encarga de conectar con la base de datos y ejecutar operaciones CRUD. | Divide la aplicación en partes para organizar el código y mejorar la mantenibilidad.                                               |
| **Ejemplo de uso**    | `UsuarioDAO` maneja la consulta y manipulación de datos en la BD.     | El**Modelo** maneja los datos, la **Vista** muestra la información y el **Controlador** coordina la interacción. |

---

### **🛠 ¿Cómo se integran DAO y MVC?**

En una aplicación basada en **MVC**, el **DAO** se usa dentro del **Modelo** para acceder a los datos, mientras que la **Vista** muestra la información y el **Controlador** maneja la lógica de la aplicación [DAO vs MVC](https://jossjack.wordpress.com/2014/06/22/patron-de-diseno-mvc-modelo-vista-controlador-y-dao-data-access-object/).

📌 **Ejemplo de integración MVC con DAO en Java:**

1. **Modelo (`Usuario.java`)** → Representa los datos.
2. **DAO (`UsuarioDAO.java`, `UsuarioDAOImpl.java`)** → Maneja la persistencia.
3. **Controlador (`UsuarioController.java`)** → Llama al DAO y envía datos a la Vista.
4. **Vista (`index.jsp` o `UsuarioView.java`)** → Muestra la información al usuario.

🔹 **Flujo de datos en MVC con DAO:**

1. **El usuario interactúa con la Vista.**
2. **El Controlador recibe la solicitud y usa el DAO** para obtener datos del Modelo.
3. **El DAO se conecta a la base de datos** y devuelve los resultados.
4. **El Controlador pasa los datos a la Vista.**
5. **La Vista muestra la información al usuario.**

🔹 **Patrón DAO:** se encarga exclusivamente de **manejar la consulta a la base de datos de manera eficaz**, separando la lógica de acceso a los datos del resto del código.

🔹 **Patrón MVC (Modelo-Vista-Controlador):** Se **acopla perfectamente con DAO**, ya que divide la aplicación en tres capas principales.

- **Modelo (M)** → Representa los datos y usa DAO para acceder a la base de datos.
- **Vista (V)** → Muestra la información al usuario (puede ser una página web, una interfaz gráfica o una API).
- **Controlador (C)** → Recibe las solicitudes del usuario y llama al DAO a través del Modelo para obtener o modificar datos.

💡 **Beneficio clave:** Gracias a esta combinación, obtenemos un código **modular, limpio y escalable**, donde cada parte de la aplicación tiene una única responsabilidad clara.

🚀 En resumen: **DAO** facilita la conexión con la BD, mientras que **MVC** organiza la aplicación para hacerla más mantenible.

---

## **🔥 Guía Completa para Implementar el Patrón DAO en Java 🚀**

El **Patrón DAO (Data Access Object)** es un patrón de diseño utilizado para **separar la lógica de acceso a datos** del resto de la aplicación. Su objetivo es **mantener un código limpio, modular y fácil de mantener** al encapsular las operaciones CRUD (**Create, Read, Update, Delete**) en una capa específica.

---

### **1️⃣ ¿Por qué usar DAO?**

✅ **Separación de preocupaciones**: Mantiene el acceso a datos independiente del resto del código.
✅ **Facilidad de mantenimiento**: Si cambia la base de datos, solo hay que modificar la capa DAO.
✅ **Reutilización de código**: Los métodos DAO pueden ser reutilizados en diferentes partes de la aplicación.
✅ **Facilidad de prueba**: Permite hacer pruebas unitarias del código sin necesidad de conectarse a la BD real.

---

### **2️⃣ Estructura del Patrón DAO en Java**

Un sistema con DAO suele tener la siguiente estructura de paquetes y clases:

```
/src
  /modelo
    Usuario.java       # Modelo de datos
  /dao
    UsuarioDAO.java    # Interfaz DAO
    UsuarioDAOImpl.java # Implementación DAO
  /controlador
    UsuarioController.java # Controlador que usa el DAO
  /vista
    index.jsp          # Interfaz gráfica o vista
```

---

### **3️⃣ Paso a Paso: Implementación del Patrón DAO en Java con MySQL**

Vamos a crear una aplicación en Java que **maneja usuarios** en una base de datos **MySQL** utilizando **DAO**.

---

#### **📌 Paso 1: Configurar la Base de Datos MySQL**

📍 Ejecuta este SQL en MySQL para crear la base de datos y la tabla `usuarios`:

```sql
CREATE DATABASE mi_base_datos;

USE mi_base_datos;

CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL
);
```

---

#### **📌 Paso 2: Crear la Clase de Modelo (`Usuario.java`)**

El modelo representa un usuario en la aplicación.

```java
package modelo;

public class Usuario {
    private int id;
    private String nombre;
    private String email;

    public Usuario() {}

    public Usuario(int id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "Usuario{id=" + id + ", nombre='" + nombre + "', email='" + email + "'}";
    }
}
```

---

#### **📌 Paso 3: Crear la Interfaz DAO (`UsuarioDAO.java`)**

Define los métodos CRUD sin implementarlos.

```java
package dao;

import modelo.Usuario;
import java.util.List;

public interface UsuarioDAO {
    void insertar(Usuario usuario);
    Usuario obtenerPorId(int id);
    List<Usuario> obtenerTodos();
    void actualizar(Usuario usuario);
    void eliminar(int id);
}
```

---

#### **📌 Paso 4: Implementar el DAO (`UsuarioDAOImpl.java`)**

Implementa la interfaz **UsuarioDAO** usando **JDBC** para conectar con MySQL.

```java
package dao;

import modelo.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOImpl implements UsuarioDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/mi_base_datos";
    private static final String USUARIO = "root";
    private static final String CLAVE = "password";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Cargar el driver de MySQL
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertar(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nombre, email) VALUES (?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, CLAVE);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Usuario obtenerPorId(int id) {
        String sql = "SELECT * FROM usuarios WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, CLAVE);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Usuario(rs.getInt("id"), rs.getString("nombre"), rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Usuario> obtenerTodos() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, CLAVE);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Usuario(rs.getInt("id"), rs.getString("nombre"), rs.getString("email")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public void actualizar(Usuario usuario) {
        String sql = "UPDATE usuarios SET nombre=?, email=? WHERE id=?";
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, CLAVE);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getEmail());
            stmt.setInt(3, usuario.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM usuarios WHERE id=?";
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, CLAVE);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
```

---

#### **📌 Paso 5: Crear un Controlador (`UsuarioController.java`)**

```java
package controlador;

import dao.UsuarioDAO;
import dao.UsuarioDAOImpl;
import modelo.Usuario;
import java.util.List;

public class UsuarioController {
    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

        // Insertar un usuario
        Usuario nuevoUsuario = new Usuario(0, "Juan Pérez", "juan@gmail.com");
        usuarioDAO.insertar(nuevoUsuario);

        // Obtener todos los usuarios
        List<Usuario> usuarios = usuarioDAO.obtenerTodos();
        usuarios.forEach(System.out::println);

        // Actualizar usuario
        nuevoUsuario.setNombre("Juan Actualizado");
        usuarioDAO.actualizar(nuevoUsuario);

        // Obtener usuario por ID
        Usuario usuario = usuarioDAO.obtenerPorId(1);
        System.out.println("Usuario obtenido: " + usuario);

        // Eliminar usuario
        usuarioDAO.eliminar(1);
    }
}
```

---

### **🔥 Conclusión**

Con este enfoque:
✔ DAO **mantiene la lógica de acceso a datos separada** del resto del código.
✔ Es más fácil **cambiar de base de datos** sin afectar otras capas.
✔ Se obtiene **código más organizado y escalable**.

🚀 **¿Listo para implementar DAO en tu proyecto?** 💪
