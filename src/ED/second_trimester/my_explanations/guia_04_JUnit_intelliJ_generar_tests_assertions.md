### ✅ **Generar Tests Automáticamente con IntelliJ IDEA y Explicación de Métodos de Assertions**

---

## **1️⃣ Crear un Test Automáticamente en IntelliJ IDEA**

IntelliJ IDEA permite generar un test automáticamente sin necesidad de escribirlo manualmente desde cero. Aquí te explico cómo hacerlo y cómo funciona.

### 🔹 **Pasos para Crear un Test Automáticamente:**

1. **Abre tu clase** en la que deseas crear un test (por ejemplo, `Calculadora.java`).
2. **Coloca el cursor** sobre el nombre de la clase (en la parte superior del archivo).
3. **Haz clic derecho** sobre el nombre de la clase o presiona **`Alt + Enter`**.
4. **Selecciona "Generate"** y luego elige **"Test"**.
   - También puedes usar el atajo **`Alt + Insert`**.
5. **Selecciona el framework JUnit** (en este caso, JUnit 5).
6. Se abrirá una ventana donde podrás elegir:
   - Los métodos que deseas probar (puedes seleccionar todos los métodos de la clase).
7. **Haz clic en OK**, y IntelliJ generará la clase de prueba en el directorio `src/test/java`.

La estructura del proyecto se verá algo así:
```
/src
  ├── main/java
  │      ├── Calculadora.java
  ├── test/java
  │      ├── CalculadoraTest.java
```

---

## **2️⃣ Explicación de los Métodos de Assertions**

Los **métodos de aserción** en JUnit se utilizan para comprobar si el comportamiento del código es el esperado. A continuación, te explico los más comunes y cómo funcionan:

| **Método de Aserción**           | **Descripción** |
|----------------------------------|-----------------|
| `assertEquals(expected, actual)` | Verifica que dos valores sean iguales. |
| `assertNotEquals(unexpected, actual)` | Verifica que dos valores no sean iguales. |
| `assertTrue(condition)`          | Verifica que una condición sea verdadera. |
| `assertFalse(condition)`         | Verifica que una condición sea falsa. |
| `assertNull(object)`             | Verifica que un objeto sea `null`. |
| `assertNotNull(object)`          | Verifica que un objeto no sea `null`. |
| `assertThrows(Exception.class, executable)` | Verifica que un método lanza una excepción específica. |

### **Explicación Detallada de Cada Método**

1. **`assertEquals(expected, actual)`**:
   Compara dos valores para asegurarse de que son **exactamente iguales**. Si no lo son, la prueba fallará.

   **Ejemplo**:
   ```java
   @Test
   void testSuma() {
       assertEquals(5, Calculadora.sumar(2, 3));
   }
   ```
   En este ejemplo, la prueba pasará si el resultado de `Calculadora.sumar(2, 3)` es igual a `5`.

2. **`assertNotEquals(unexpected, actual)`**:
   Verifica que dos valores **no sean iguales**.

   **Ejemplo**:
   ```java
   @Test
   void testNoSuma() {
       assertNotEquals(6, Calculadora.sumar(2, 3));
   }
   ```
   La prueba pasará si el resultado de `Calculadora.sumar(2, 3)` no es igual a `6`.

3. **`assertTrue(condition)`**:
   Verifica que la condición proporcionada sea **verdadera**.

   **Ejemplo**:
   ```java
   @Test
   void testCondicion() {
       assertTrue(Calculadora.esPositivo(5));
   }
   ```
   La prueba pasará si `Calculadora.esPositivo(5)` devuelve `true`.

4. **`assertFalse(condition)`**:
   Verifica que la condición proporcionada sea **falsa**.

   **Ejemplo**:
   ```java
   @Test
   void testCondicionFalse() {
       assertFalse(Calculadora.esPositivo(-5));
   }
   ```
   La prueba pasará si `Calculadora.esPositivo(-5)` devuelve `false`.

5. **`assertNull(object)`**:
   Verifica que el objeto proporcionado sea **null**.

   **Ejemplo**:
   ```java
   @Test
   void testObjetoNull() {
       assertNull(Calculadora.obtenerResultado(null));
   }
   ```
   La prueba pasará si el objeto devuelto por `Calculadora.obtenerResultado(null)` es `null`.

6. **`assertNotNull(object)`**:
   Verifica que el objeto proporcionado **no sea null**.

   **Ejemplo**:
   ```java
   @Test
   void testObjetoNoNull() {
       assertNotNull(Calculadora.obtenerResultado(10));
   }
   ```
   La prueba pasará si el objeto devuelto por `Calculadora.obtenerResultado(10)` **no es null**.

7. **`assertThrows(Exception.class, executable)`**:
   Verifica que se **lanza una excepción** específica cuando se ejecuta un método.

   **Ejemplo**:
   ```java
   @Test
   void testExcepcion() {
       assertThrows(IllegalArgumentException.class, () -> Calculadora.sumar(-1, 1));
   }
   ```
   La prueba pasará si el método `Calculadora.sumar(-1, 1)` lanza una excepción `IllegalArgumentException`.

---

## **3️⃣ Ejemplo Real con Tests y Assertions**

Imaginemos que tienes una clase `Calculadora` con métodos de suma, resta y división. Aquí hay un ejemplo de cómo se vería tanto la clase de producción como la clase de prueba:

### **Clase `Calculadora.java`**:
```java
public class Calculadora {

    /**
     * Suma dos números enteros.
     *
     * @param a el primer número
     * @param b el segundo número
     * @return la suma de a y b
     */
    public static int sumar(int a, int b) {
        return a + b;
    }

    /**
     * Resta dos números enteros.
     *
     * @param a el primer número
     * @param b el segundo número
     * @return la resta de a y b
     */
    public static int restar(int a, int b) {
        return a - b;
    }

    /**
     * Divide dos números enteros.
     *
     * @param a el dividendo
     * @param b el divisor
     * @return el cociente de a dividido por b
     * @throws ArithmeticException si el divisor es cero
     */
    public static int dividir(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("División por cero no permitida");
        }
        return a / b;
    }

    /**
     * Verifica si el número es positivo.
     *
     * @param num el número
     * @return true si el número es positivo
     */
    public static boolean esPositivo(int num) {
        return num > 0;
    }
}
```

### **Clase de Prueba `CalculadoraTest.java`**:
```java
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    @Test
    void testSuma() {
        assertEquals(5, Calculadora.sumar(2, 3));
    }

    @Test
    void testResta() {
        assertEquals(1, Calculadora.restar(3, 2));
    }

    @Test
    void testDividir() {
        assertEquals(2, Calculadora.dividir(6, 3));
    }

    @Test
    void testDividirPorCero() {
        assertThrows(ArithmeticException.class, () -> Calculadora.dividir(6, 0));
    }

    @Test
    void testEsPositivo() {
        assertTrue(Calculadora.esPositivo(5));
    }

    @Test
    void testEsNegativo() {
        assertFalse(Calculadora.esPositivo(-5));
    }

    @Test
    void testObjetoNull() {
        // Supón que este método devuelve null si el parámetro es negativo
        assertNull(Calculadora.obtenerResultado(-1));
    }
}
```

---

### **Explicación del Ejemplo Real**

- **`testSuma()`**: Verifica que la suma de 2 y 3 es igual a 5.
- **`testResta()`**: Verifica que la resta de 3 y 2 es igual a 1.
- **`testDividir()`**: Verifica que la división de 6 entre 3 da 2.
- **`testDividirPorCero()`**: Verifica que la división por cero lanza una excepción `ArithmeticException`.
- **`testEsPositivo()`**: Verifica que el número 5 es positivo.
- **`testEsNegativo()`**: Verifica que el número -5 no es positivo.
- **`testObjetoNull()`**: Verifica que un método retorna `null` cuando el parámetro es negativo.

---
