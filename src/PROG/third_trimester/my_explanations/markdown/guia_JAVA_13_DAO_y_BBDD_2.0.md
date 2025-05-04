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

## **1️⃣ Clase Javabean**

```java
package modelo.javabean;

import java.io.Serializable;
import java.util.Objects;

public class Cliente implements Serializable {

	// Attributes
    private static final long serialVersionUID = 1L;

    private String cif;
    private String nombre;
    private String apellidos;
    private String domicilio;
    private double facturacionAnual;
    private int numeroEmpledos;

    // Constructor con nada
    public Cliente() {
        super();
    }

    // Constructor con todo
    public Cliente(String cif, String nombre, String apellidos, String domicilio, double facturacionAnual,
            int numeroEmpledos) {
        super();
        this.cif = cif;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.domicilio = domicilio;
        this.facturacionAnual = facturacionAnual;
        this.numeroEmpledos = numeroEmpledos;
    }

    // Getters & Setters
    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public double getFacturacionAnual() {
        return facturacionAnual;
    }

    public void setFacturacionAnual(double facturacionAnual) {
        this.facturacionAnual = facturacionAnual;
    }

    public int getNumeroEmpledos() {
        return numeroEmpledos;
    }

    public void setNumeroEmpledos(int numeroEmpledos) {
        this.numeroEmpledos = numeroEmpledos;
    }

    // Equals & Hash-Code
    @Override
    public int hashCode() {
        return Objects.hash(cif);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) obj;
        return Objects.equals(cif, other.cif);
    }

    // ToString
    @Override
    public String toString() {
        return "Cliente [cif=" + cif + ", nombre=" + nombre + ", apellidos=" + apellidos + ", domicilio=" + domicilio
                + ", facturacionAnual=" + facturacionAnual + ", numeroEmpledos=" + numeroEmpledos + "]";
    }

}
```

### **Explicación**

- **`Usuario`**:
  - Es una clase **POJO (Plain Old Java Object)** que representa en código JAVA una Tabla de la BBDD.

---

## **2️⃣ Singleton para la Conexión**

El Singleton va **abstract**.

```java
package modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Singleton {
	
	static Singleton instance; // La única instancia de la conexión porque el constructor es privado
	
	private Connection conn; // Sirve para establecer la conexión con DriverManager a la BBDD
	private final String HTTP = "jdbc:mysql://localhost:3306/mi_db"; // Dirección de la BBDD
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

	public static synchronized Singleton getInstance() throws SQLException { // Función encargada de entregar el objeto con la conexión a la BBDD
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

Otra forma de hacer un **Singleton** es utilizando `enum`, consiguiendo un código más simple y con más seguridad usando el doble check. Para garantizar que solo se cree una instancia en entornos multi-hilo, puedes utilizar el **patrón de doble verificación de bloqueo (Double-Checked Locking)**.

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

### **Explicación**

- **`private Singleton`**: El **constructor es `private`** para evitar que se creen instancias adicionales de la clase fuera del Singleton. Esto asegura que solo haya **una única instancia de `Singleton`**, que administra la conexión a la base de datos.
- **`public static synchronized InstanceBbdd getInstance()`**:

- El **método es `static synchronized`** para poder acceder a él sin tener que crear un objeto `Singleton` primero.
  - **`static`**: Las funciones y atributos son **estáticos** porque deben ser compartidos entre todos los objetos de la aplicación sin necesidad de instanciarlos. Esto hace que el Singleton pueda mantener una única conexión durante toda la ejecución.
  - **`synchronized`** asegura que el método sea seguro para hilos concurrentes, garantizando que solo una instancia del Singleton se cree incluso en aplicaciones multi-hilo.

---

## **3️⃣ Clase abstract para manipular las sentencias SQL con Generic Types**

```java
package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class AbsGenericSQL<T, ID> {
	
	// Attributes para manejar el SQL y la info en la BBDD
    protected Connection conn; // Conexión a la BBDD
    protected PreparedStatement ps; // Quien prepara la sentencia y la ejecuta en el motor de la BBDD
    protected ResultSet rs; // Lee el fichero secuencial generado por el motor de la BBDD
    protected String sql; // La consulta SQL (opcional)
    protected int rowsAffected; // Las filas afectadas por la consulta. Esto me ayuda a determinar si ha sido exitosa o menos (opcional)

    // Constructor
    public AbsGenericSQL() {
        try {
            this.conn = Singleton.getInstance().getConn(); // Acá me conecto con el Singleton
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
```

### **Explicación**

- **`extends AbsGenericSQL`**:
  - Cada **DAO (como `ClienteDaoImpl`) extiende esta clase abstracta** para obtener la conexión a la base de datos de forma centralizada. Esto evita que cada clase DAO tenga que crear su propia conexión, haciendo el código más limpio y eficiente.

---

## **3️⃣.1️⃣ Interface para CRUD genérico**

```java
package modelo.dao;

import java.util.List;

public interface IGenericCRUD<T, ID> {

	// Para el CRUD
	List<T> findAll();
	T findById(ID atributoPK);
	int insertOne(T obj);
	int updateOne(T obj);
	int deleteById(ID atributoPK);
}
```

### **Explicación**

- **`extends IGenericCRUD`**:
  - Extendemos esta interfaz en la interfaz donde definimos los métodos específicos para cada Entidad en particular. De ésta forma, podemos evitar repetir código y crear un CRUD único que implemente `List`.

---

## **4️⃣ Interface Javabean que extiende interface de CRUD genérico**

```java
package modelo.dao;

import java.util.List;

import modelo.javabean.Cliente;

public interface IClienteDao extends IGenericCRUD<Cliente, String>{
	
	/* 
	 * Métodos para manejar los clientes en específico 
	 * Nos apoyamos en el 'extends' para adoptar el CRUD genérico
	*/
	String exportar(String nombreFichero);
	List<Cliente> importar(String nombreFichero);
}
```

### **Explicación**

- **`implements IClienteDao`**:
  - Las clases que implementan esta interfaz deben proporcionar **implementaciones específicas** para los métodos definidos en la interfaz, como `agregarUsuario`, `obtenerUsuarioPorId`, etc.
  - Esto se encarga de definir las llamadas a la Tabla específica de la BBDD.

---

## **5️⃣ Extends de la clase Abstract e Implements de la interface Javabean**

```java
package modelo.dao;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.javabean.Cliente;

public class ClienteDaoImpl extends AbsGenericSQL<Cliente, String> implements IClienteDao {

	String sql;

	@Override
	public List<Cliente> findAll() {

		sql = "SELECT * FROM clientes;";
		Cliente cli = null;
		List<Cliente> aux = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			/*
			 * Convertir mi 'ResultSet' en un 'ArrayList<>()' Para convertir el 'rs' en un
			 * 'ArrayList<Cliente>()', hay que iterar sobre el ResultSet dentro de un
			 * try-catch, crear un obj Cliente por cada fila (por eso se hace dentro del
			 * bucle) y añadirlo a la lista. Luego recibimos el valor de cada columna dentro
			 * del ResultSet o RowSet, se agrega al 'aux' y se devuelve
			 */
			while (rs.next()) {
				cli = new Cliente();

				cli.setCif(rs.getString("cif"));
				cli.setNombre(rs.getString("nombre"));
				cli.setApellidos(rs.getString("apellidos"));
				cli.setDomicilio(rs.getString("domicilio"));
				cli.setFacturacionAnual(rs.getDouble("facturacion_anual"));
				cli.setNumeroEmpledos(rs.getInt("numero_empleados"));

				aux.add(cli);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return aux;
	}

	@Override
	public Cliente findById(String atributoPK) {

		sql = "SELECT * FROM clientes WHERE cif = ?;";
		/*
		 * Itera, nuevo Obj por vuelta (RowSet), asignación de los valores de cada campo
		 * en el Obj (setea en 'cli' y recibe de 'rs'. Todo dentro de try-catch y
		 * devolvemos obj
		 */
		Cliente cli = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				cli = new Cliente();

				cli.setCif(rs.getString("cif"));
				cli.setNombre(rs.getString("nombre"));
				cli.setApellidos(rs.getString("apellidos"));
				cli.setDomicilio(rs.getString("domicilio"));
				cli.setFacturacionAnual(rs.getDouble("facturacion_anual"));
				cli.setNumeroEmpledos(rs.getInt("numero_empleados"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cli;
	}

	@Override
	public int insertOne(Cliente obj) {

		sql = "INSERT INTO clientes (cif, nombre, apellidos, domicilio, facturacion_anual, numero_empleados) VALUES (?,?,?,?,?,?);";
		/*
		 * Itera, nuevo Obj por vuelta (RowSet), asignación de los valores de cada campo
		 * en el Obj (setea en 'cli' y recibe de 'rs'. Todo dentro de try-catch y
		 * devolvemos obj
		 */
		rowsAffected = 0;
		try {
			ps = conn.prepareStatement(sql); // No me hace falta iterar el 'rs' porque el valor que se introduce es nuevo

			ps.setString(1, obj.getCif()); // Cada índice (el número) es la referencia de izq a dcha de cada VALUES correspondiente
			ps.setString(2, obj.getNombre());
			ps.setString(3, obj.getApellidos());
			ps.setString(4, obj.getDomicilio());
			ps.setDouble(5, obj.getFacturacionAnual());
			ps.setInt(6, obj.getNumeroEmpledos());

			rowsAffected = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowsAffected;
	}

	@Override
	public int updateOne(Cliente obj) {
		String sql = "update clientes set " + "nombre = ?," + "apellidos = ?," + "domicilio = ?,"
				+ "facturacion_anual = ?," + "numero_empleados = ?" + " where cif = ?;";
		rowsAffected = 0;
		try {

			ps = conn.prepareStatement(sql);

			ps.setString(1, obj.getNombre());
			ps.setString(2, obj.getApellidos());
			ps.setString(3, obj.getDomicilio());
			ps.setDouble(4, obj.getFacturacionAnual());
			ps.setInt(5, obj.getNumeroEmpledos());
			ps.setString(6, obj.getCif());

			rowsAffected = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error al actualizar el cliente");
			return -1;
		}

		return rowsAffected;
	}

	@Override
	public int deleteById(String atributoPK) {
		String sql = "DELETE FROM clientes WHERE cif = ?;";

		rowsAffected = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, atributoPK);

			rowsAffected = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}

		return rowsAffected;
	}

	@Override
	public String exportar(String nombreFichero) {
		File archivo = new File(nombreFichero);
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		String msj = null;

		try {
			fos = new FileOutputStream(archivo);
			oos = new ObjectOutputStream(fos);

			for (Cliente ele : findAll()) {
				oos.writeObject(ele);
			}

			msj = "Clientes bien exportados";

		} catch (Exception e) {
			e.printStackTrace();
			msj = "Fichero no existe";
		}

		return msj;
	}

	@Override
	public List<Cliente> importar(String nombreFichero) {
		File archivo = new File(nombreFichero);
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		List<Cliente> aux = new ArrayList<Cliente>();
		Cliente cli = null;

		try {

			fis = new FileInputStream(archivo);
			ois = new ObjectInputStream(fis);

			while (true) {
				
				try {
					cli = (Cliente) ois.readObject();
					aux.add(cli);
					
				} catch (EOFException e) {
					break;
				}
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return aux;
	}
}
```

### **Explicación**

- **`DELETE FROM clientes WHERE cif = ?;`**:

  - Se utilizan los **`?`** en las consultas SQL como **marcadores de posición**.
  - Los **marcadores de posición** se reemplazan con los valores correspondientes usando los métodos como `setString` y `setInt` de `PreparedStatement`.
  - Esos marcadores se setean después en un `aux` iterando `rs` dentro de un try-catch y accediendo a los datos con `ps.setString(1, obj.getNombre());`, por ejemplo.

- **`ResultSet rs = ps.executeQuery()`**:

  - **`executeQuery()`** se usa para **consultas SELECT**.
  - Devuelve un **`ResultSet`** contiene el resultado de la consulta, y puedes iterar sobre él con `while(rs.next())`.

- **`ps.executeUpdate()`**:
  - Se utiliza para **consultas INSERT, UPDATE y DELETE**, y devuelve el número de filas afectadas, lo cual es útil para comprobar si la operación fue exitosa.
  - Devuelve un **`Int`** que define las rowsAffected en la BBDD (las líneas que han sido modificadas al ejecutar la consulta).

---

## **✅ Conclusión**

- Cada **DAO maneja explícitamente las consultas SQL** usando `PreparedStatement`, `ResultSet`, `sql` y **el número de filas afectadas**.
- Las clases y métodos están estructurados para mantener un **código limpio y modular**, asegurando que la lógica de acceso a datos sea clara y reutilizable.
