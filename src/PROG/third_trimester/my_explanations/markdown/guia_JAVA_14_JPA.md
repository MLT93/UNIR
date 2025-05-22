# 🧠 ¿Qué es JPA?

**JPA (Java Persistence API)** es una **especificación de Java** (una interfaz) para **gestionar datos relacionales con programación orientada a objetos**. No es una implementación, sino un estándar que define **cómo deben comportarse los frameworks que interactúan con bases de datos**.

🔧 Las implementaciones más comunes de JPA son:

* **Hibernate** (la más popular)
* EclipseLink
* OpenJPA

---

### 🎯 ¿Para qué sirve JPA?

#### 🔁 **1. Para mapear clases Java a tablas de una base de datos**

Con JPA puedes hacer que tus clases Java representen **tablas** de la base de datos, y los atributos de esas clases sean las **columnas**.

```java
@Entity
public class User {
    @Id
    private int id;
    private String nombre;
    private String email;
}
```

Esto te ahorra tener que escribir SQL manualmente para crear o leer datos. JPA lo hace por ti.

---

#### 🧾 **2. Para acceder a la base de datos desde Java sin escribir SQL explícito**

En vez de hacer esto:

```sql
SELECT * FROM users WHERE id = 1;
```

Haces esto en Java:

```java
User user = entityManager.find(User.class, 1);
```

Es decir, **JPA convierte las operaciones sobre objetos Java en sentencias SQL automáticamente**.

---

#### 📦 **3. Para gestionar el ciclo de vida de los datos**

JPA te permite:

* Guardar nuevos objetos (`persist`)
* Actualizar objetos (`merge`)
* Eliminar objetos (`remove`)
* Buscar objetos (`find`, `query`)

Y lo hace todo sin que tú te preocupes por la conexión o la transacción, si está bien configurado.

---

#### 🔒 **4. Para desacoplar tu aplicación del motor de base de datos**

Cambiar de **MySQL a PostgreSQL** no debería requerir cambios en tu código si usas JPA correctamente.

Solo cambias el **driver y el dialecto en `persistence.xml`**.

---

#### 🛠️ **5. Para evitar duplicación de código SQL**

JPA permite escribir **queries reutilizables**, llamadas `JPQL` o `NamedQuery`, o incluso usar filtros dinámicos sin escribir SQL explícito.

```java
TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.nombre = :nombre", User.class);
query.setParameter("nombre", "Pedro");
```

---

#### 💼 **6. Para trabajar con transacciones de forma automática**

JPA puede manejar las **transacciones** (commit, rollback) por ti, o te permite controlarlas manualmente.

---

### 🔁 Ciclo de uso de JPA (resumen)

| Paso | Acción                       | Código                                               |
| ---- | ---------------------------- | ---------------------------------------------------- |
| 1️⃣  | Crear `EntityManagerFactory` | `Persistence.createEntityManagerFactory("miUnidad")` |
| 2️⃣  | Crear `EntityManager`        | `emf.createEntityManager()`                          |
| 3️⃣  | Abrir transacción            | `em.getTransaction().begin()`                        |
| 4️⃣  | Operar con objetos           | `em.persist(obj)` / `em.find(...)`                   |
| 5️⃣  | Confirmar                    | `em.getTransaction().commit()`                       |
| 6️⃣  | Cerrar                       | `em.close()`                                         |

---

### 📌 Resumen

**¿Para qué sirve JPA?**

> JPA te permite guardar, leer, actualizar y eliminar objetos Java en una base de datos **sin escribir SQL manualmente**, manteniendo el código limpio, desacoplado y fácil de mantener.

---

### 🤔 **¿Qué es el archivo `persistence.xml`?**

Es un archivo **de configuración obligatorio para JPA** (Java Persistence API). Define cómo y dónde se conecta tu aplicación Java a la base de datos, y qué clases están mapeadas como entidades.

Se coloca en:

```
src/main/resources/META-INF/persistence.xml
```

📎 **[Documentación oficial - JPA persistence.xml](https://jakarta.ee/specifications/persistence/3.1/jakarta-persistence-spec-3.1.html#persistencexml)**

---

### 🧩 **¿Qué contiene un archivo `persistence.xml` típico?**

```xml
<?xml version="1.0" encoding="UTF-8"?>
<persistence xmlns="https://jakarta.ee/xml/ns/persistence"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="https://jakarta.ee/xml/ns/persistence
                                 https://jakarta.ee/xml/ns/persistence/persistence_3_1.xsd"
             version="3.1">

  <persistence-unit name="MY_APP" transaction-type="RESOURCE_LOCAL">

    <provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>

    <class>modelo.javabean.User</class>

    <properties>
      <property name="jakarta.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver" />
      <property name="jakarta.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/mi_bbdd" />
      <property name="jakarta.persistence.jdbc.user" value="root" />
      <property name="jakarta.persistence.jdbc.password" value="1234" />

      <property name="hibernate.dialect" value="org.hibernate.dialect.MySQL8Dialect" />
      <property name="hibernate.hbm2ddl.auto" value="update" />
      <property name="hibernate.show_sql" value="true" />
    </properties>

  </persistence-unit>
</persistence>
```

---

### 🔑 **¿Cómo se enlaza este archivo con el código Java?**

En tu clase `SingletonConnection` (dentro de `modelo.dao`), usas:

```java
EntityManagerFactory emf = Persistence.createEntityManagerFactory("MY_APP");
```

El parámetro `"MY_APP"` debe coincidir **exactamente** con el `name="MY_APP"` definido en el `persistence-unit`.

> Es lo que le dice a JPA: "usa esta configuración para conectarte a la base de datos".

---

### 🧠 **¿Cómo interactúa JPA con `persistence.xml`?**

| Acción                                 | ¿Qué hace JPA usando `persistence.xml`?                                                                             |
| -------------------------------------- | ------------------------------------------------------------------------------------------------------------------- |
| `createEntityManagerFactory("MY_APP")` | Busca el archivo `persistence.xml` en `META-INF` y extrae la configuración del `persistence-unit` llamado `MY_APP`. |
| Crea conexiones                        | Usa `jdbc.url`, `user`, `password`, `driver`, `dialect` para crear la conexión con la base de datos.                |
| Gestiona entidades                     | Usa `<class>` para registrar qué clases POJO son entidades JPA.                                                     |
| Ejecuta SQL                            | Usa `hibernate.show_sql` y `hbm2ddl.auto` para mostrar consultas y actualizar tablas automáticamente.               |

---

### 🚀 **Guía paso a paso para crear y usar `persistence.xml`**

#### **1️⃣ Crea la carpeta META-INF**

* Ruta exacta: `src/main/resources/META-INF`
* Dentro de esta carpeta, crea `persistence.xml`

#### **2️⃣ Escribe el archivo**

* Define el `persistence-unit` con nombre (ej: `MY_APP`)
* Añade tus entidades con `<class>...`
* Configura conexión (JDBC, usuario, pass, dialecto, etc.)

#### **3️⃣ En tu código Java**

* Usa:

```java
EntityManagerFactory emf = Persistence.createEntityManagerFactory("MY_APP");
EntityManager em = emf.createEntityManager();
```

> 💡 Este patrón normalmente se encapsula dentro de tu clase `SingletonConnection`.

---

### 🔎 **¿Qué significa cada propiedad importante?**

| Propiedad           | Propósito                                                                             |
| ------------------- | ------------------------------------------------------------------------------------- |
| `jdbc.url`          | Dirección de la base de datos (localhost, puerto, nombre de BD)                       |
| `jdbc.driver`       | Clase del driver JDBC (depende de tu motor: MySQL, PostgreSQL, etc.)                  |
| `hibernate.dialect` | Adaptador de SQL para ese motor (traduce JPA a SQL correcto)                          |
| `hbm2ddl.auto`      | `update`, `create`, `validate`, `none`... controla la creación/modificación de tablas |
| `show_sql`          | Muestra en consola las consultas generadas por JPA                                    |

📘 Más info:

- **[https://www.baeldung.com/jpa-persistence-xml](https://www.baeldung.com/jpa-persistence-xml)**
- **[https://www.theserverside.com/blog/Coffee-Talk-Java-News-Stories-and-Opinions/Java-persistencexml-file-How-to-create-it-use-it-and-load-it](https://www.theserverside.com/blog/Coffee-Talk-Java-News-Stories-and-Opinions/Java-persistencexml-file-How-to-create-it-use-it-and-load-it)**

---

### 📌 **Consejos clave**

* ✅ Solo necesitas **un `persistence.xml`** en la mayoría de los casos.
* ✅ Asegúrate de que el nombre del `persistence-unit` coincida con el nombre usado en `createEntityManagerFactory("...")`.
* ✅ Las clases POJO mapeadas deben estar **anotadas con `@Entity`** y registradas en el XML (o bien autodetectadas con JPA moderno si usas Spring Boot o anotación `@EntityScan`).

---

### 🔗 **Recursos adicionales**

- 🧪 **[Ejemplo completo con Hibernate + JPA + XML](https://www.javaguides.net/2018/11/jpa-hibernate-5-xml-configuration-example.html)**
- 🧩 **[Hibernate dialects (MySQL, PostgreSQL, etc.)](https://docs.jboss.org/hibernate/orm/current/userguide/html_single/Hibernate_User_Guide.html#configurations-dialect)**
- 🧠 **[persistence.xml explicaciones en profundidad (Stack Overflow)](https://stackoverflow.com/questions/3413130/how-does-persistence-xml-work-in-jpa)**

---

### ✅ **Resumen visual rápido**

| Paso | Acción clave                                            |
| ---- | ------------------------------------------------------- |
| 1️⃣  | Crea archivo `persistence.xml` en `META-INF`            |
| 2️⃣  | Define `persistence-unit` con nombre e info de conexión |
| 3️⃣  | Usa `Persistence.createEntityManagerFactory("MY_APP")`  |
| 4️⃣  | Accede a la BD a través de `EntityManager`              |
| 5️⃣  | Usa ese `EntityManager` en tus DAOs (`AbsBBDD`)         |

---

### 🥊 **JPA vs JDBC – Comparación**

| 📌 Característica                       | ✅ JPA                                                     | 🔧 JDBC tradicional                                                     |
| --------------------------------------- | --------------------------------------------------------- | ----------------------------------------------------------------------- |
| 🔁 **Mapeo Objeto-Relacional (ORM)**    | ✅ Automático con anotaciones (`@Entity`, `@Id`, etc.)     | ❌ Manual: debes mapear cada campo desde `ResultSet`                     |
| 📄 **SQL requerido**                    | ✅ Opcional (`JPQL` o sin SQL)                             | ❌ Obligatorio: debes escribir todas las sentencias SQL                  |
| 🧠 **Nivel de abstracción**             | ✅ Alto nivel: trabajas con objetos Java                   | ❌ Bajo nivel: trabajas con SQL, `Connection`, `ResultSet`, etc.         |
| 🔄 **Gestión de transacciones**         | ✅ Integrado (`em.getTransaction()...`)                    | ❌ Manual: debes controlar `conn.setAutoCommit(false)`, `commit()`, etc. |
| ♻️ **Reutilización de queries**         | ✅ Sí: `NamedQuery`, `JPQL`, Criteria API                  | ❌ No: debes escribir la query cada vez                                  |
| 📦 **Gestión de conexiones**            | ✅ Transparente: el contenedor lo hace                     | ❌ Manual: tú abres y cierras cada `Connection`                          |
| 🧪 **Testabilidad**                     | ✅ Alta: se puede mockear `EntityManager`                  | ❌ Baja: depende de conexión directa con la BBDD                         |
| 💥 **Complejidad en grandes proyectos** | ✅ Menor: separa DAO, entidades, servicios                 | ❌ Alta: se vuelve difícil mantener                                      |
| 🧰 **Curva de aprendizaje**             | ⚠️ Media: requiere entender conceptos de ORM              | ✅ Rápida: solo saber SQL y Java                                         |
| ⚡ **Rendimiento**                       | ⚠️ Un poco más lento, pero optimizable (`fetch`, `cache`) | ✅ Rápido si está bien escrito, pero propenso a errores humanos          |

---

### 🧪 Ejemplo comparado: Buscar un usuario por ID

#### ✅ **Con JPA**

```java
User user = entityManager.find(User.class, 1); // El 1 corresponde al ID buscado
```

#### 🔧 **Con JDBC**

```java
Connection conn = DriverManager.getConnection("jdbc:mysql://<dominio_de_la_BBDD/<nombre_BBDD>", "user", "pass");
PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE id = ?"); // Necesario operar con '?' para definir los valores que se buscan
stmt.setInt(1, 1); // Aquí se opera con '?'
ResultSet rs = stmt.executeQuery();

User user = null;
if (rs.next()) {
    user = new User();
    user.setId(rs.getInt("id"));
    user.setNombre(rs.getString("nombre"));
    user.setEmail(rs.getString("email"));
}
rs.close();
stmt.close();
conn.close();
```

💣 **¿Ves la diferencia?** Con JPA escribes **una línea**, con JDBC al menos **10 líneas y mucho código repetido**.

---

### 🎯 ¿Cuándo usar cada uno?

| Contexto                                        | Recomendación |
| ----------------------------------------------- | ------------- |
| Proyectos grandes, con entidades complejas      | ✅ **JPA**     |
| Aplicaciones empresariales (Spring, Jakarta EE) | ✅ **JPA**     |
| Scripts rápidos, sin lógica compleja            | 🔧 **JDBC**   |
| Requiere máximo rendimiento y control total     | 🔧 **JDBC**   |
| Estás aprendiendo sobre ORM                     | ✅ **JPA**     |

---

### 🔗 Recursos útiles

- 🧠 **[Hibernate vs JDBC - Baeldung](https://www.baeldung.com/hibernate-vs-jdbc)**
- 📝 **[Spring Data JPA vs JDBC Template](https://www.baeldung.com/spring-data-jpa-vs-jdbc-template)**
- 📘 **[Documentación oficial de JPA – Oracle](https://docs.oracle.com/javaee/7/tutorial/persistence-intro.htm)**

---

### 🧠 Conclusión

> **JDBC** es como escribir a mano todo el SQL y gestionar cada parte del flujo de datos.
>
> **JPA** es como usar un asistente que traduce entre Java y SQL por ti, permitiéndote enfocarte en **la lógica de negocio**, no en detalles técnicos.
