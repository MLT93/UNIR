## **🔥 Guía Completa sobre Genéricos en Java 🔥**

### **1️⃣ Introducción a los Genéricos en Java**

Los **genéricos** en Java son una poderosa característica del lenguaje que permite **definir clases, interfaces y métodos** con **tipos de datos parametrizados**. Esto significa que puedes crear componentes reutilizables que operan sobre cualquier tipo de datos sin perder la seguridad de tipo en tiempo de compilación.

#### **¿Por qué usar genéricos?**
1. **Seguridad de tipo en tiempo de compilación**: Los errores de tipo se detectan antes de que el programa se ejecute.
2. **Código más limpio y reutilizable**: Permite que una misma clase o método trabaje con distintos tipos de datos sin tener que duplicar el código.
3. **Mejor legibilidad**: Al declarar el tipo de los datos con los que trabajas, el código es más fácil de leer y entender.

---

### **2️⃣ Sintaxis de los Genéricos**

En Java, los genéricos se definen utilizando **parámetros de tipo** entre los signos de mayor y menor (`<>`). Estos parámetros se sustituyen por un tipo real cuando se instancia una clase o se invoca un método.

#### **Generics en Clases**
```java
public class Caja<T> {
    private T contenido;

    public T getContenido() {
        return contenido;
    }

    public void setContenido(T contenido) {
        this.contenido = contenido;
    }
}
```
En este ejemplo:
- `T` es un **parámetro de tipo**. Puede ser cualquier tipo de datos.
- La clase `Caja` puede contener **cualquier tipo** de objeto.

#### **Uso de la Clase Genérica**

```java
public class Main {
    public static void main(String[] args) {
        // Crear una caja de tipo Integer
        Caja<Integer> cajaInt = new Caja<>();
        cajaInt.setContenido(10);
        System.out.println(cajaInt.getContenido()); // 10

        // Crear una caja de tipo String
        Caja<String> cajaString = new Caja<>();
        cajaString.setContenido("Hola, Mundo");
        System.out.println(cajaString.getContenido()); // "Hola, Mundo"
    }
}
```
En este caso, cuando instanciamos `Caja<Integer>`, el tipo de `T` se convierte en `Integer` y cuando instanciamos `Caja<String>`, el tipo de `T` se convierte en `String`.

---

### **3️⃣ Genéricos en Métodos**

Los genéricos no solo se pueden utilizar en clases, sino también en **métodos**. Esto permite que el tipo sea determinado al llamar al método, lo que hace que el código sea más flexible.

#### **Método Genérico**

```java
public class Genericos {
    public static <T> void imprimir(T valor) {
        System.out.println(valor);
    }

    public static void main(String[] args) {
        imprimir(100); // Imprime un Integer
        imprimir("Hola Mundo"); // Imprime un String
    }
}
```
En este ejemplo:
- `<T>` en el encabezado del método indica que `imprimir` puede aceptar cualquier tipo de datos.
- `imprimir(100)` pasa un `Integer` al método y `imprimir("Hola Mundo")` pasa un `String`.

#### **Tipos Específicos de Genéricos en Métodos**

```java
public class EjemploGenericos {
    public static <T> T retornar(T valor) {
        return valor;
    }

    public static void main(String[] args) {
        Integer numero = retornar(10);  // Devuelve un Integer
        String texto = retornar("Genericos en Java");  // Devuelve un String
        System.out.println(numero);
        System.out.println(texto);
    }
}
```
En este caso, el tipo `T` es inferido por el valor que se pasa al método. Al llamar a `retornar(10)`, el tipo `T` se convierte en `Integer`, y al llamar a `retornar("Genericos en Java")`, el tipo `T` se convierte en `String`.

---

### **4️⃣ Límites en Genéricos (Bounded Types)**

A veces es útil restringir el tipo de datos que se puede usar como parámetro en un genérico. Esto se logra mediante los **límites** (bounds).

#### **Tipos Bounded con `extends`**

Con `extends`, puedes restringir los genéricos a tipos que son **subclases** de una clase específica o **implementan una interfaz**.

```java
public class EjemploBounded {
    public static <T extends Number> void mostrar(T valor) {
        System.out.println("Valor: " + valor);
    }

    public static void main(String[] args) {
        mostrar(5);     // OK, Integer es subclase de Number
        mostrar(3.14);  // OK, Double es subclase de Number
    }
}
```
En este ejemplo, `T` puede ser cualquier tipo que extienda `Number` (como `Integer`, `Double`, `Float`, etc.).

#### **Limitación Múltiple con `&`**

Puedes restringir el tipo a varias clases/interfaces utilizando el operador `&`.

```java
public class EjemploMultipleBound {
    public static <T extends Number & Comparable<T>> void mostrar(T valor) {
        System.out.println("Valor: " + valor);
    }

    public static void main(String[] args) {
        mostrar(10);   // OK, Integer es Comparable y extiende Number
    }
}
```
En este caso, `T` debe ser una clase que **extienda** `Number` y que **implemente** `Comparable`.

---

### **5️⃣ Genéricos y la Herencia**

La **herencia** también juega un papel importante con los genéricos. Si una clase genérica tiene una relación de herencia, el tipo genérico en la clase **subclase** puede ser un subtipo de la clase en la que se define.

```java
class Caja<T> {
    private T contenido;
    
    public void setContenido(T contenido) {
        this.contenido = contenido;
    }

    public T getContenido() {
        return contenido;
    }
}

class CajaString extends Caja<String> {
    public void setContenido(String contenido) {
        super.setContenido(contenido);
    }

    public String getContenido() {
        return super.getContenido();
    }
}
```
En este ejemplo, `CajaString` extiende `Caja<String>`, lo que significa que la clase `CajaString` solo puede trabajar con valores de tipo `String`.

---

### **6️⃣ Genéricos en Colecciones de Java**

Los genéricos son ampliamente utilizados en las colecciones de Java. De hecho, **todas las colecciones modernas** (como `ArrayList`, `HashMap`, etc.) hacen uso de genéricos para proporcionar **seguridad de tipo**.

#### **Uso de Genéricos en Listas**
```java
import java.util.ArrayList;
import java.util.List;

public class ListaGenerica {
    public static void main(String[] args) {
        List<String> lista = new ArrayList<>();
        lista.add("Java");
        lista.add("Genericos");

        for (String item : lista) {
            System.out.println(item);
        }
    }
}
```
En este caso, estamos utilizando `ArrayList<String>` para asegurar que solo se añadan elementos de tipo `String` a la lista.

---

### **7️⃣ Limitaciones de los Genéricos**

1. **No se puede usar tipos primitivos**: No se pueden usar tipos como `int`, `char`, `boolean` directamente con genéricos. Sin embargo, puedes usar las clases envoltorio (`Integer`, `Character`, `Boolean`, etc.) en lugar de los tipos primitivos.
   
   ```java
   List<int> lista = new ArrayList<>();  // Esto causará error
   List<Integer> listaInt = new ArrayList<>();  // Correcto
   ```

2. **No se puede crear instancias de un tipo genérico directamente**: No puedes crear una instancia de un tipo genérico sin especificar el tipo real.

   ```java
   T obj = new T(); // Esto dará error
   ```

3. **Tipos de parámetros genéricos son borrados en tiempo de ejecución**: Java utiliza **type erasure** (borrado de tipos) en tiempo de ejecución, lo que significa que la información sobre el tipo genérico se elimina una vez que el código se compila. Esto puede afectar algunos aspectos, como la creación de instancias de tipos genéricos.

---

### **8️⃣ Conclusión**
Los **genéricos en Java** son una herramienta poderosa que permite crear código más flexible, reutilizable y seguro en tiempo de compilación.  
### **Recapitulación:**
- Los genéricos permiten escribir clases, métodos e interfaces parametrizadas.
- Ayudan a mantener la **seguridad de tipo**.
- Son especialmente útiles en colecciones, como `ArrayList`, `HashMap`, y en otros casos que requieren **múltiples tipos**.
