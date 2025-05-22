# 🤔 **¿Qué queremos lograr?**

Crear una arquitectura profesional y mantenible para una aplicación Java con acceso a base de datos usando **JPA**. Usaremos un patrón de diseño que incluye:

✅ Singleton para conexión JPA
✅ DAO con interfaces y clases abstractas
✅ Separación en paquetes (`modelo.dao`, `modelo.javabean`)
✅ POJO serializable (`User`)
✅ Interfaz DAO genérica (`ICrudList`)

**JPA** finalmente usará **JDBC** por debajo para manipular la base de datos.

---

### 🧱 **Arquitectura general**

📦 `modelo.dao`

* `SingletonConnection` (enum class que devuélve la conexión)
* `AbsBBDD` (abstract class que crea las vars para manipular sentencias SQL)
* `UserImplBBDDAndList` (extends `AbsBBDD`, implements `IUserDao` itera el objeto que llega de la BBDD y lo )
* `IUserDao` (interface, extiende `ICrudList<User>`)
* `ICrudList<T, ID>` (interface genérica)

📦 `modelo.javabean`

* `User` (POJO que implementa `Serializable`)

---

### 📌 **Componentes clave del sistema**

#### 🔹 **1. SingletonConnection (enum)**

El patrón enum Singleton es una forma segura y efectiva de garantizar una **única instancia de `EntityManagerFactory`**.

```java
package modelo.dao;

import jakarta.persistence.*;

public enum SingletonConnection {
    INSTANCE;

    private EntityManagerFactory emf;

    SingletonConnection() {
        emf = Persistence.createEntityManagerFactory("miUnidadPersistencia");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
```

📚 [Java Enum Singleton](https://www.baeldung.com/java-singleton#enum-singleton)
📚 [JPA EntityManager](https://www.baeldung.com/jpa-entitymanager)

---

#### 🔹 **2. Clase abstracta AbsBBDD**

Provee acceso a EntityManager y métodos comunes para DAOs.

```java
package modelo.dao;

import jakarta.persistence.*;

public abstract class AbsBBDD {
    protected EntityManager em;

    public AbsBBDD() {
        this.em = SingletonConnection.INSTANCE.getEntityManager();
    }

    protected void close() {
        if (em != null && em.isOpen()) {
            em.close();
        }
    }
}
```

---

#### 🔹 **3. Interfaz genérica ICrudList `<T, ID>`**

Define operaciones básicas CRUD + listados.

```java
package modelo.dao;

import java.util.List;

public interface ICrudList<T, ID> {
    List<T> findAll();
    T read(ID id);
    boolean create(T t);
    boolean update(T t);
    boolean delete(ID id);
}
```

---

#### 🔹 **4. Interfaz IUserDao**

Especialización de `ICrudList` para entidad `User`.

```java
package modelo.dao;

import modelo.javabean.User;

public interface IUserDao extends ICrudList<User> {
    User findByUsername(String username);
}
```

---

#### 🔹 **5. Clase UserImplBBDDAndList**

Implementa la lógica de negocio y hereda acceso JPA.

```java
package modelo.dao;

import modelo.javabean.User;
import jakarta.persistence.*;

import java.util.List;

public class UserImplBBDDAndList extends AbsBBDD implements IUserDao {

    @Override
    public boolean create(User user) {
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        } finally {
            close();
        }
    }

    @Override
    public User read(Object id) {
        try {
            return em.find(User.class, id);
        } finally {
            close();
        }
    }

    @Override
    public boolean update(User user) {
        try {
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        } finally {
            close();
        }
    }

    @Override
    public boolean delete(Object id) {
        try {
            em.getTransaction().begin();
            User user = em.find(User.class, id);
            if (user != null) em.remove(user);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        } finally {
            close();
        }
    }

    @Override
    public List<User> findAll() {
        try {
            return em.createQuery("SELECT u FROM User u", User.class).getResultList();
        } finally {
            close();
        }
    }

    @Override
    public User findByUsername(String username) {
        try {
            TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class);
            query.setParameter("username", username);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            close();
        }
    }
}
```

---

#### 🔹 **6. Clase POJO User**

Debe estar en `modelo.javabean` e implementar `Serializable`.

```java
package modelo.javabean;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;
    private String password;
    private String email;

    // Constructores
    public User() {}
    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
```

---

### 🚀 **Guía paso a paso para crear tu sistema JPA DAO con Singleton Enum**

#### **1️⃣ Crear el archivo `persistence.xml` en `/META-INF`**

```xml
<persistence xmlns="https://jakarta.ee/xml/ns/persistence" version="3.0">
  <persistence-unit name="miUnidadPersistencia">
    <class>modelo.javabean.User</class>
    <properties>
      <property name="jakarta.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/tu_bbdd"/>
      <property name="jakarta.persistence.jdbc.user" value="root"/>
      <property name="jakarta.persistence.jdbc.password" value="tu_password"/>
      <property name="jakarta.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver"/>
      <property name="jakarta.persistence.schema-generation.database.action" value="update"/>
    </properties>
  </persistence-unit>
</persistence>
```

#### **2️⃣ Implementar los componentes explicados**

✅ `SingletonConnection`
✅ `AbsBBDD`
✅ Interfaces `ICrudList`, `IUserDao`
✅ Clase `UserImplBBDDAndList`
✅ POJO `User`

#### **3️⃣ Crear una clase de prueba para insertar y leer usuarios**

```java
public class TestUser {
    public static void main(String[] args) {
        IUserDao dao = new UserImplBBDDAndList();

        User newUser = new User("admin", "1234", "admin@correo.com");
        dao.create(newUser);

        User user = dao.findByUsername("admin");
        System.out.println("Usuario: " + user.getUsername());
    }
}
```

---

### 📚 **Recursos útiles para profundizar**

* 🔗 [JPA con Jakarta EE 10](https://jakarta.ee/specifications/persistence/)
* 🔗 [Java Enum Singleton - Baeldung](https://www.baeldung.com/java-enum-singleton)
* 🔗 [CRUD con JPA y Hibernate](https://www.baeldung.com/hibernate-entitymanager)
* 🔗 [Diseño DAO en Java - JournalDev](https://www.journaldev.com/1689/dao-design-pattern-in-java)

---

### 🧠 **Resumen final (Regla 80/20)**

Con este patrón:

✅ Solo necesitas entender 3 clases base: `SingletonConnection`, `AbsBBDD`, `UserImplBBDDAndList`
✅ Implementas `JPA` sin complicarte con frameworks externos
✅ Separas claramente responsabilidades: conexión, lógica DAO y modelos
