Aquí tienes una **explicación completa y detallada sobre JUnit en IntelliJ IDEA**, incluyendo conceptos avanzados y herramientas útiles. 🚀  

---

# ✅ **Guía Completa de JUnit 5 en IntelliJ IDEA**
JUnit es un **framework de pruebas unitarias** para Java que permite verificar que nuestro código funciona correctamente. IntelliJ IDEA ofrece **soporte nativo** para JUnit, lo que facilita la creación, ejecución y depuración de pruebas.

---

## **1️⃣ Agregar JUnit al Proyecto en IntelliJ**
Antes de empezar, debemos asegurarnos de que JUnit está incluido en nuestro proyecto.  

### 🔹 **Si usas Maven** (`pom.xml`)  
Añade esta dependencia:  
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

### 🔹 **Si usas Gradle** (`build.gradle.kts` en Kotlin DSL)  
```kotlin
dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.2")
}
```

### 🔹 **Si no usas Maven ni Gradle**
1. **Ve a** `File > Project Structure > Libraries`.
2. **Haz clic en "Add" > "From Maven"**.
3. Busca `org.junit.jupiter:junit-jupiter` y agrégalo.

---

## **2️⃣ Crear una Clase de Prueba en IntelliJ**
1. **Abre la clase que quieres probar** (por ejemplo, `Cociente.java`).
2. **Haz clic derecho en el nombre de la clase** → `Generate` (`Alt + Insert`) → `Test`.
3. Selecciona **JUnit 5** como framework.
4. **Marca los métodos que deseas probar** y presiona `OK`.
5. IntelliJ generará una clase de prueba en `src/test/java`.

📌 **Ejemplo de estructura del proyecto:**
```
/src
  ├── main/java
  │      ├── Cociente.java
  ├── test/java
  │      ├── CocienteTest.java
```

---

## **3️⃣ Escribir Test Unitarios con JUnit 5**
Ejemplo de una clase de prueba en `CocienteTest.java`:  
```java
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CocienteTest {

    @BeforeAll
    static void setup() {
        System.out.println("🔹 Inicializando pruebas...");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("✅ Ejecutando prueba...");
    }

    @Test
    @DisplayName("División de 2 números enteros")
    void dividirNumEntero() {
        assertEquals(2, Cociente.dividir(6, 3));
    }

    @Test
    @DisplayName("División entre cero debe lanzar ZeroMathException")
    void dividirEntreCeroDebeLanzarExcepcion() {
        assertThrows(Cociente.ZeroMathException.class, () -> Cociente.dividir(6, 0));
    }

    @AfterEach
    void afterEach() {
        System.out.println("🔹 Prueba finalizada.");
    }

    @AfterAll
    static void teardown() {
        System.out.println("🛑 Finalizando pruebas...");
    }
}
```

---

## **4️⃣ Anotaciones Importantes en JUnit**
| **Anotación**      | **Descripción** |
|--------------------|----------------|
| `@Test`           | Indica que el método es una prueba unitaria. |
| `@DisplayName`    | Da un nombre descriptivo a la prueba. |
| `@BeforeAll`      | Se ejecuta **una vez antes de todas las pruebas**. |
| `@BeforeEach`     | Se ejecuta **antes de cada prueba**. |
| `@AfterEach`      | Se ejecuta **después de cada prueba**. |
| `@AfterAll`       | Se ejecuta **una vez al final de todas las pruebas**. |

---

## **5️⃣ Métodos de Aserciones en JUnit**
JUnit ofrece muchas **funciones para verificar resultados**:

| **Método** | **Uso** |
|------------|---------|
| `assertEquals(expected, actual)` | Verifica que dos valores sean iguales. |
| `assertNotEquals(unexpected, actual)` | Verifica que dos valores sean diferentes. |
| `assertTrue(condition)` | Verifica que una condición sea verdadera. |
| `assertFalse(condition)` | Verifica que una condición sea falsa. |
| `assertThrows(Exception.class, () -> método())` | Verifica que un método lanza una excepción. |
| `assertNull(object)` | Verifica que un objeto sea `null`. |
| `assertNotNull(object)` | Verifica que un objeto no sea `null`. |

📌 **Ejemplo:**
```java
@Test
void testSuma() {
    assertEquals(5, Calculadora.sumar(2, 3));
    assertNotEquals(6, Calculadora.sumar(2, 3));
}
```

---

## **6️⃣ Probar Múltiples Casos con `@ParameterizedTest`**
Si quieres probar varios valores sin escribir múltiples métodos, usa `@ParameterizedTest`:

```java
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CocienteTest {
    @ParameterizedTest
    @CsvSource({"6, 3, 2", "10, 2, 5", "9, 3, 3"})
    void testDividirMultiplesCasos(int a, int b, int resultadoEsperado) {
        assertEquals(resultadoEsperado, Cociente.dividir(a, b));
    }
}
```
✅ **Explicación**:
- `@CsvSource({"6, 3, 2", "10, 2, 5", "9, 3, 3"})` define múltiples casos de prueba en una sola línea.

---

## **7️⃣ Ejecutar Pruebas en IntelliJ**
### 📌 **Método 1: Desde la Clase de Prueba**
1. **Abre `CocienteTest.java`**.
2. **Haz clic derecho en la clase** → `Run 'CocienteTest'`.
3. IntelliJ ejecutará las pruebas y mostrará los resultados.

### 📌 **Método 2: Desde el Menú de Ejecución**
1. **Ve a `Run > Edit Configurations`**.
2. Agrega una nueva configuración de **JUnit**.
3. Selecciona la clase de prueba y ejecuta.

### 📌 **Método 3: Atajos Rápidos**
- **Ejecutar todos los tests**: `Ctrl + Shift + F10`
- **Ejecutar un test específico**: `Ctrl + Shift + R`
- **Repetir última prueba**: `Ctrl + F5`

---

## **8️⃣ Depuración de Tests en IntelliJ**
Si un test falla y necesitas analizarlo paso a paso:
1. **Coloca un breakpoint** (`Ctrl + Click Izquierdo`) en la línea problemática.
2. **Haz clic derecho en la prueba** → `Debug 'CocienteTest'`.
3. Usa las herramientas de depuración (`Step Over`, `Step Into`, etc.).

---

## **9️⃣ Integración con Mockito (Para Mocks)**
Si necesitas probar métodos que dependen de otros objetos, usa **Mockito**:

```java
import static org.mockito.Mockito.*;

@Test
void testConMock() {
    Calculadora mockCalculadora = mock(Calculadora.class);
    when(mockCalculadora.sumar(2, 3)).thenReturn(5);
    assertEquals(5, mockCalculadora.sumar(2, 3));
}
```

---

## **🔟 Conclusión**
- **Configura JUnit 5** con Maven/Gradle o manualmente.
- **Crea clases de prueba** con IntelliJ.
- **Usa `@Test` y `assertions`** para validar los resultados.
- **Ejecuta y depura tests** con IntelliJ.
- **Usa `@ParameterizedTest` y Mockito** para mejorar tus pruebas.
