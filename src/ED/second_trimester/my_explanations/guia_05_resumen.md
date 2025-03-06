### ✅ **Guía Completa para Configurar un Proyecto en IntelliJ IDEA con JUnit 5 y JavaDoc**

Aquí tienes una **explicación completa sobre cómo configurar un proyecto en IntelliJ IDEA**, crear los tests con JUnit y añadir los comentarios de JavaDoc adecuados.  

---

## **1️⃣ Crear un Proyecto en IntelliJ IDEA**

### 🔹 **Crear un Proyecto Nuevo**
1. **Abre IntelliJ IDEA**.
2. **Haz clic en "New Project"**.
3. **Selecciona "Java"** y elige el SDK adecuado.
4. **Haz clic en "Next"**, y asigna un nombre al proyecto.
5. **Selecciona el directorio** donde se almacenará el proyecto y haz clic en **Finish**.

---

## **2️⃣ Agregar Dependencias de JUnit**

### 🔹 **Si usas Maven** (`pom.xml`):

Agrega las siguientes dependencias para usar JUnit 5:

```xml
<dependencies>
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter-api</artifactId>
        <version>5.9.2</version>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter-engine</artifactId>
        <version>5.9.2</version>
    </dependency>
</dependencies>
```

### 🔹 **Si usas Gradle** (`build.gradle.kts`):

```kotlin
dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.2")
}
```

### 🔹 **Si no usas Maven ni Gradle:**

1. Ve a **File > Project Structure > Libraries**.
2. Haz clic en "Add" y selecciona **"From Maven"**.
3. Busca **`org.junit.jupiter:junit-jupiter`** y agrégalo.

---

## **3️⃣ Crear Tests con JUnit en IntelliJ IDEA**

### 🔹 **Generar Tests Automáticamente**

1. **Abre la clase** que deseas probar (por ejemplo, `Cociente.java`).
2. Haz clic derecho sobre la clase → **Generate** → **Test** (`Alt + Insert`).
3. Selecciona **JUnit 5** como framework.
4. **Marca los métodos que deseas probar** y presiona **OK**.
5. IntelliJ generará una clase de prueba en **`src/test/java`**.

### Ejemplo de estructura de proyecto:
```
/src
  ├── main/java
  │      ├── Cociente.java
  ├── test/java
  │      ├── CocienteTest.java
```

---

## **4️⃣ Escribir Tests Unitarios con JUnit 5**

En tu archivo `CocienteTest.java`, escribe los tests como se muestra a continuación:

```java
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CocienteTest {

    /**
     * Este método se ejecuta una vez antes de todas las pruebas.
     */
    @BeforeAll
    static void setup() {
        System.out.println("🔹 Inicializando pruebas...");
    }

    /**
     * Este método se ejecuta antes de cada prueba.
     */
    @BeforeEach
    void beforeEach() {
        System.out.println("✅ Ejecutando prueba...");
    }

    /**
     * Test para verificar la división de dos números enteros.
     */
    @Test
    @DisplayName("División de 2 números enteros")
    void dividirNumEntero() {
        assertEquals(2, Cociente.dividir(6, 3));
    }

    /**
     * Test para verificar que una división por cero lanza una excepción.
     */
    @Test
    @DisplayName("División entre cero debe lanzar ZeroMathException")
    void dividirEntreCeroDebeLanzarExcepcion() {
        assertThrows(Cociente.ZeroMathException.class, () -> Cociente.dividir(6, 0));
    }

    /**
     * Este método se ejecuta después de cada prueba.
     */
    @AfterEach
    void afterEach() {
        System.out.println("🔹 Prueba finalizada.");
    }

    /**
     * Este método se ejecuta una vez después de todas las pruebas.
     */
    @AfterAll
    static void teardown() {
        System.out.println("🛑 Finalizando pruebas...");
    }
}
```

---

## **5️⃣ Añadir JavaDoc en tus Clases y Métodos**

### 🔹 **Uso de JavaDoc**

Asegúrate de documentar tu código con JavaDoc para que sea fácilmente entendible y pueda generar documentación automáticamente.

- **Métodos**: Cada método debe tener una descripción clara de su propósito, parámetros y el valor de retorno.
  
### Ejemplo de JavaDoc para los métodos:

```java
/**
 * Este método calcula el cociente de dos números enteros.
 * 
 * @param a el dividendo
 * @param b el divisor
 * @return el cociente de la división
 * @throws ZeroMathException si el divisor es cero
 */
public static int dividir(int a, int b) throws ZeroMathException {
    if (b == 0) {
        throw new ZeroMathException("No se puede dividir por cero.");
    }
    return a / b;
}
```

---

## **6️⃣ Ejecutar y Depurar Tests**

### 🔹 **Ejecutar los Tests**

1. **Abre la clase de prueba** (`CocienteTest.java`).
2. Haz clic derecho en la clase → **Run 'CocienteTest'**.

### 🔹 **Depurar los Tests**

1. Coloca un **breakpoint** en la línea del test donde quieras depurar.
2. Haz clic derecho en la clase de prueba → **Debug 'CocienteTest'**.
3. Usa las herramientas de depuración para examinar el flujo de ejecución.

---

## **7️⃣ Anotaciones Importantes en JUnit**

| **Anotación**      | **Descripción** |
|--------------------|----------------|
| `@Test`           | Indica que el método es una prueba unitaria. |
| `@DisplayName`    | Da un nombre descriptivo a la prueba. |
| `@BeforeAll`      | Se ejecuta **una vez antes de todas las pruebas**. |
| `@BeforeEach`     | Se ejecuta **antes de cada prueba**. |
| `@AfterEach`      | Se ejecuta **después de cada prueba**. |
| `@AfterAll`       | Se ejecuta **una vez al final de todas las pruebas**. |

---

## **8️⃣ Métodos de Aserciones en JUnit**

JUnit proporciona varias funciones útiles para verificar los resultados de las pruebas:

| **Método** | **Uso** |
|------------|---------|
| `assertEquals(expected, actual)` | Verifica que dos valores sean iguales. |
| `assertNotEquals(unexpected, actual)` | Verifica que dos valores sean diferentes. |
| `assertTrue(condition)` | Verifica que una condición sea verdadera. |
| `assertFalse(condition)` | Verifica que una condición sea falsa. |
| `assertThrows(Exception.class, () -> método())` | Verifica que un método lanza una excepción. |
| `assertNull(object)` | Verifica que un objeto sea `null`. |
| `assertNotNull(object)` | Verifica que un objeto no sea `null`. |

---

## **9️⃣ Conclusión**

- **Configura JUnit 5** en tu proyecto usando Maven, Gradle o manualmente.
- **Crea clases de prueba** en IntelliJ IDEA utilizando el generador de tests.
- **Usa las anotaciones y métodos de aserción** de JUnit para verificar el comportamiento de tu código.
- **Documenta tu código con JavaDoc** para mejorar la claridad y facilitar el mantenimiento.
- **Ejecuta y depura tus tests** usando las herramientas integradas de IntelliJ IDEA.

