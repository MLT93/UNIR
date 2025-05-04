Aquí tienes una **guía completa** sobre los **tipos de datos en Java**, con explicaciones detalladas, ejemplos prácticos y buenas prácticas.  

---

# **🔥 Guía Completa de Tipos de Datos en Java 🔥**  

## **1️⃣ Introducción a los Tipos de Datos en Java**  
En Java, los datos que usamos en las variables pueden clasificarse en dos grandes categorías:  

### ✅ **Tipos Primitivos**  
Son los tipos de datos más básicos. Se almacenan directamente en la memoria y tienen un tamaño fijo.  

### ✅ **Tipos de Referencia**  
Son objetos que almacenan direcciones de memoria en lugar de valores directos.  

---

## **2️⃣ Tipos de Datos Primitivos en Java**  
| Tipo | Tamaño | Rango | Ejemplo |
|------|--------|--------|---------|
| `byte` | 8 bits | -128 a 127 | `byte b = 100;` |
| `short` | 16 bits | -32,768 a 32,767 | `short s = 20000;` |
| `int` | 32 bits | -2^31 a 2^31-1 | `int i = 123456;` |
| `long` | 64 bits | -2^63 a 2^63-1 | `long l = 9876543210L;` |
| `float` | 32 bits | ±3.4E-38 a ±3.4E+38 | `float f = 3.14f;` |
| `double` | 64 bits | ±1.7E-308 a ±1.7E+308 | `double d = 3.141592653589793;` |
| `char` | 16 bits | Caracteres Unicode | `char c = 'A';` |
| `boolean` | 1 bit | `true` o `false` | `boolean flag = true;` |

### **📌 Ejemplo de Tipos Primitivos**
```java
public class TiposPrimitivos {
    public static void main(String[] args) {
        byte b = 100;
        short s = 20000;
        int i = 123456;
        long l = 9876543210L;
        float f = 3.14f;
        double d = 3.141592653589793;
        char c = 'A';
        boolean flag = true;

        System.out.println("byte: " + b);
        System.out.println("short: " + s);
        System.out.println("int: " + i);
        System.out.println("long: " + l);
        System.out.println("float: " + f);
        System.out.println("double: " + d);
        System.out.println("char: " + c);
        System.out.println("boolean: " + flag);
    }
}
```
✅ **Salida esperada:**
```
byte: 100
short: 20000
int: 123456
long: 9876543210
float: 3.14
double: 3.141592653589793
char: A
boolean: true
```

---

## **3️⃣ Tipos de Datos de Referencia en Java**  
Los tipos de referencia son **objetos** o **arrays** y no almacenan valores directamente, sino direcciones de memoria.  

### **📌 Ejemplo de Tipos de Referencia**
```java
public class TiposReferencia {
    public static void main(String[] args) {
        String texto = "Hola, Java!";
        int[] numeros = {1, 2, 3, 4, 5};
        Persona persona = new Persona("Juan", 30);

        System.out.println("String: " + texto);
        System.out.println("Array: " + numeros[0] + ", " + numeros[1]);
        System.out.println("Objeto Persona: " + persona.getNombre());
    }
}

class Persona {
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }
}
```
✅ **Diferencias clave con los tipos primitivos:**
- Se almacenan en el **Heap**, no en el Stack.
- Se accede a ellos a través de **referencias**.
- Pueden ser **nulos** (`null`), mientras que los primitivos no pueden.

---

## **4️⃣ Conversión entre Tipos de Datos**
### **📌 Conversión Implícita (Widening)**
Java **automáticamente** convierte tipos más pequeños en más grandes.  
```java
int num = 10;
double numD = num; // Conversión automática de int a double
System.out.println(numD); // 10.0
```

### **📌 Conversión Explícita (Narrowing)**
Debemos hacer una **conversión manual** cuando pasamos de un tipo grande a uno más pequeño.  
```java
double numD = 9.99;
int num = (int) numD; // Conversión manual de double a int
System.out.println(num); // 9 (se pierde la parte decimal)
```

---

## **5️⃣ Clases Wrapper para Tipos Primitivos**
Java proporciona **clases envoltorio (Wrapper Classes)** en `java.lang` para cada tipo primitivo.  

| Primitivo | Clase Wrapper |
|-----------|--------------|
| `byte` | `Byte` |
| `short` | `Short` |
| `int` | `Integer` |
| `long` | `Long` |
| `float` | `Float` |
| `double` | `Double` |
| `char` | `Character` |
| `boolean` | `Boolean` |

### **📌 Ejemplo de Uso de Wrapper**
```java
public class WrapperExample {
    public static void main(String[] args) {
        Integer numero = Integer.valueOf(100); // Boxing (convertir primitivo en objeto)
        int primitivo = numero.intValue(); // Unboxing (convertir objeto en primitivo)

        System.out.println("Wrapper Integer: " + numero);
        System.out.println("Primitivo int: " + primitivo);
    }
}
```

✅ **Desde Java 5, Java hace esto automáticamente con autoboxing y unboxing.**

```java
Integer numero = 100;  // Autoboxing
int primitivo = numero; // Unboxing
```

---

## **6️⃣ Tipos de Datos en Arrays**
Un **array** almacena múltiples valores del mismo tipo.  
```java
int[] numeros = {10, 20, 30, 40};
System.out.println(numeros[2]); // 30
```
---

## **7️⃣ Tipos de Datos en Colecciones**
Cuando necesitamos almacenar múltiples valores sin un tamaño fijo, usamos **colecciones**.

| Colección | Descripción |
|-----------|------------|
| `ArrayList<T>` | Lista dinámica de elementos. |
| `LinkedList<T>` | Lista enlazada eficiente en inserciones/eliminaciones. |
| `HashSet<T>` | Conjunto de valores únicos. |
| `HashMap<K, V>` | Estructura clave-valor. |

### **📌 Ejemplo con `ArrayList`**
```java
import java.util.ArrayList;

public class EjemploArrayList {
    public static void main(String[] args) {
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Java");
        lista.add("Python");
        lista.add("C++");

        System.out.println(lista.get(1)); // Python
    }
}
```

---

## **8️⃣ Conclusión**
| **Concepto** | **Descripción** |
|-------------|----------------|
| **Tipos Primitivos** | Datos básicos almacenados en memoria (int, double, boolean, etc.). |
| **Tipos de Referencia** | Objetos y arrays almacenados en el Heap. |
| **Conversión de Tipos** | Widening (automática) y Narrowing (manual). |
| **Clases Wrapper** | Clases que envuelven primitivos para uso en colecciones y OOP. |
| **Colecciones** | Arrays, listas y mapas para almacenar datos dinámicos. |
