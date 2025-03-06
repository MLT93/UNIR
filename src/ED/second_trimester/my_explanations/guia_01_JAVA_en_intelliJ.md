Aquí tienes una **explicación detallada de Java**, incluyendo **JavaBeans**, clases de prueba, y la librería **Lombok**. 🚀  

---

# 🔥 **Guía Completa de Java con JavaBeans, Pruebas y Lombok**
Java es un lenguaje de programación **orientado a objetos**, ampliamente usado en desarrollo web, aplicaciones empresariales y Android.

---

## **1️⃣ Instalación y Configuración de Java**
### 🔹 **Descargar e Instalar JDK**
Para programar en Java, necesitas el **JDK (Java Development Kit)**. Puedes descargarlo desde:
- [Oracle JDK](https://www.oracle.com/java/technologies/javase-downloads.html)
- [OpenJDK](https://openjdk.org/)
- [Adoptium (Eclipse Temurin)](https://adoptium.net/)

### 🔹 **Verificar Instalación**
Después de instalar Java, verifica su versión en la terminal:
```sh
java -version
javac -version
```

Si todo está correcto, verás algo como:
```
java version "17.0.2" 2023-01-17 LTS
Java(TM) SE Runtime Environment (build 17.0.2+8)
```

---

## **2️⃣ Concepto de Clases en Java**
En Java, existen **diferentes tipos de clases**, dependiendo de su uso:

1. **Clases regulares** → Contienen lógica de negocio.
2. **Clases JavaBean** → Definen entidades reutilizables con atributos privados y métodos getter/setter.
3. **Clases de prueba** → Se usan para testear la funcionalidad de otras clases con JUnit.

### 🔹 **Ejemplo de Clase Regular**
```java
public class Calculadora {
    public int sumar(int a, int b) {
        return a + b;
    }
}
```

---

## **3️⃣ ¿Qué es un JavaBean?**
Un **JavaBean** es una clase que sigue estas reglas:
✔ Tiene un constructor vacío.  
✔ Sus atributos son `private`.  
✔ Usa métodos `getter` y `setter` para acceder a los atributos.  
✔ Es **serializable** (implementa `Serializable` en algunos casos).  

### **Ejemplo de JavaBean (POJO)**
```java
import java.io.Serializable;

public class Persona implements Serializable {
    private String nombre;
    private int edad;

    public Persona() {} // Constructor vacío

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }
}
```
🔹 **¿Dónde se usa un JavaBean?**  
Un JavaBean es ideal para **transportar datos** en aplicaciones empresariales y frameworks como **Spring**.

---

## **4️⃣ Pruebas de JavaBeans con Clases de Test**
Para probar un JavaBean, creamos una clase con un `main()` o usamos **JUnit**.

### 🔹 **Prueba Manual en una Clase con `main()`**
```java
public class PruebaPersona {
    public static void main(String[] args) {
        Persona persona = new Persona();
        persona.setNombre("Juan");
        persona.setEdad(30);

        System.out.println("Nombre: " + persona.getNombre());
        System.out.println("Edad: " + persona.getEdad());
    }
}
```

### 🔹 **Prueba con JUnit**
JUnit permite realizar pruebas automáticas en Java.

#### **Dependencias para JUnit en Maven (`pom.xml`)**
```xml
<dependencies>
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter-api</artifactId>
        <version>5.8.1</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

#### **Test Unitario con JUnit**
```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonaTest {
    @Test
    void testPersona() {
        Persona p = new Persona();
        p.setNombre("Ana");
        p.setEdad(25);

        assertEquals("Ana", p.getNombre());
        assertEquals(25, p.getEdad());
    }
}
```

🔹 **¿Qué hace JUnit?**  
✅ Verifica que los métodos `getNombre()` y `getEdad()` devuelvan los valores correctos.  
✅ Si el test falla, nos avisa que la implementación es incorrecta.  

---

## **5️⃣ Simplificando JavaBeans con Lombok**
[Lombok](https://projectlombok.org/) es una librería que **reduce el código repetitivo** en JavaBeans.

### 🔹 **Añadir Lombok en Maven (`pom.xml`)**
```xml
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.26</version>
    <scope>provided</scope>
</dependency>
```

### 🔹 **Usar Lombok en un JavaBean**
```java
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class Persona {
    private String nombre;
    private int edad;
}
```

🔹 **¿Qué hace Lombok?**  
✅ **`@Getter` y `@Setter`** → Generan automáticamente los métodos `get` y `set`.  
✅ **`@NoArgsConstructor`** → Crea un constructor vacío.  

---

## **6️⃣ Estructura de un Proyecto en IntelliJ**
En **IntelliJ IDEA**, un proyecto Java estándar tiene esta estructura:

```
📂 mi-proyecto
 ┣ 📂 src
 ┃ ┣ 📂 main
 ┃ ┃ ┗ 📂 java
 ┃ ┃   ┗ 📂 com.miapp
 ┃ ┃      ┣ 📄 Persona.java  (JavaBean)
 ┃ ┃      ┣ 📄 Calculadora.java (Clase de negocio)
 ┃ ┃      ┗ 📄 App.java (Clase con `main()`)
 ┃ ┣ 📂 test
 ┃ ┃ ┗ 📂 java
 ┃ ┃   ┗ 📄 PersonaTest.java (JUnit)
 ┗ 📄 pom.xml (Dependencias Maven)
```

📌 **Clases en `main/java`** → Contienen la lógica del programa.  
📌 **Clases en `test/java`** → Contienen pruebas unitarias con JUnit.  

---

## **7️⃣ Resumen Final**
| **Concepto** | **Descripción** |
|-------------|----------------|
| **JavaBean** | Clase con atributos privados, `getter` y `setter`. Se usa para datos. |
| **Clase de Negocio** | Contiene la lógica del programa (ej. `Calculadora`). |
| **Clase de Prueba** | Usa JUnit para validar código. |
| **Lombok** | Simplifica los JavaBeans, eliminando código repetitivo. |
| **JUnit** | Permite realizar pruebas unitarias. |
| **IntelliJ** | IDE potente para desarrollar en Java. |

---

## **8️⃣ Conclusión**
✅ Ahora entiendes la diferencia entre **JavaBeans**, clases normales y clases de prueba.  
✅ Aprendiste a usar **JUnit** para pruebas y **Lombok** para reducir código repetitivo.  
✅ ¡Listo para desarrollar aplicaciones más eficientes en Java! 🚀
