## **🔥 Guía Completa sobre Operadores en Java 🔥**

### **1️⃣ Introducción a los Operadores en Java**

Los **operadores** en Java son símbolos que se utilizan para realizar operaciones en **variables** y **valores**. Permiten modificar, comparar y combinar datos de diferentes tipos. Los operadores son una parte esencial de cualquier lenguaje de programación, y en Java no son la excepción. 

Java ofrece una amplia variedad de operadores que se pueden clasificar en varias categorías, dependiendo de su función y uso.

### **2️⃣ Tipos de Operadores en Java**

Los operadores en Java se pueden clasificar en las siguientes categorías:

#### **1. Operadores Aritméticos**

Los operadores **aritméticos** se utilizan para realizar operaciones matemáticas sobre valores numéricos.

- **`+`**: Suma
- **`-`**: Resta
- **`*`**: Multiplicación
- **`/`**: División
- **`%`**: Módulo (resto de la división)
- **`++`**: Incremento (aumenta el valor de una variable en 1)
- **`--`**: Decremento (disminuye el valor de una variable en 1)

```java
public class OperadoresAritmeticos {
    public static void main(String[] args) {
        int a = 10;
        int b = 5;
        
        System.out.println("Suma: " + (a + b));     // 15
        System.out.println("Resta: " + (a - b));    // 5
        System.out.println("Multiplicación: " + (a * b)); // 50
        System.out.println("División: " + (a / b));  // 2
        System.out.println("Módulo: " + (a % b));    // 0
        
        a++;
        System.out.println("Incremento: " + a);     // 11
        
        b--;
        System.out.println("Decremento: " + b);     // 4
    }
}
```

#### **2. Operadores de Comparación**

Los **operadores de comparación** se utilizan para comparar dos valores y devuelven un **valor booleano** (`true` o `false`), indicando si la comparación es verdadera o falsa.

- **`==`**: Igual a
- **`!=`**: Diferente de
- **`>`**: Mayor que
- **`<`**: Menor que
- **`>=`**: Mayor o igual que
- **`<=`**: Menor o igual que

```java
public class OperadoresDeComparacion {
    public static void main(String[] args) {
        int x = 10;
        int y = 20;
        
        System.out.println("x == y: " + (x == y));  // false
        System.out.println("x != y: " + (x != y));  // true
        System.out.println("x > y: " + (x > y));    // false
        System.out.println("x < y: " + (x < y));    // true
        System.out.println("x >= y: " + (x >= y));  // false
        System.out.println("x <= y: " + (x <= y));  // true
    }
}
```

#### **3. Operadores Lógicos**

Los **operadores lógicos** se utilizan para combinar condiciones booleanas. Son fundamentales cuando se desean evaluar varias condiciones al mismo tiempo.

- **`&&`**: Y (AND). Devuelve `true` si ambas condiciones son verdaderas.
- **`||`**: O (OR). Devuelve `true` si al menos una de las condiciones es verdadera.
- **`!`**: No (NOT). Invierte el valor de la condición (si es `true`, se convierte en `false`, y viceversa).

```java
public class OperadoresLogicos {
    public static void main(String[] args) {
        boolean a = true;
        boolean b = false;
        
        System.out.println("a && b: " + (a && b)); // false
        System.out.println("a || b: " + (a || b)); // true
        System.out.println("!a: " + !a);            // false
    }
}
```

#### **4. Operadores de Asignación**

Los **operadores de asignación** permiten asignar valores a variables. Además, algunos operadores combinan operaciones con la asignación.

- **`=`**: Asignación simple
- **`+=`**: Suma y asignación
- **`-=`**: Resta y asignación
- **`*=`**: Multiplicación y asignación
- **`/=`**: División y asignación
- **`%=`**: Módulo y asignación

```java
public class OperadoresDeAsignacion {
    public static void main(String[] args) {
        int a = 10;
        
        a += 5; // a = a + 5
        System.out.println("a += 5: " + a); // 15
        
        a -= 3; // a = a - 3
        System.out.println("a -= 3: " + a); // 12
        
        a *= 2; // a = a * 2
        System.out.println("a *= 2: " + a); // 24
        
        a /= 4; // a = a / 4
        System.out.println("a /= 4: " + a); // 6
        
        a %= 3; // a = a % 3
        System.out.println("a %= 3: " + a); // 0
    }
}
```

#### **5. Operadores de Incremento y Decremento**

Los **operadores de incremento y decremento** permiten modificar el valor de una variable aumentando o disminuyendo su valor en una unidad.

- **`++`**: Incremento (añade 1 al valor de la variable).
- **`--`**: Decremento (disminuye 1 al valor de la variable).

Estos operadores pueden ser **prefijos** (antes de la variable) o **sufijos** (después de la variable).

- **`++a`**: Incremento antes de la evaluación.
- **`a++`**: Incremento después de la evaluación.

```java
public class IncrementoYDecremento {
    public static void main(String[] args) {
        int a = 10;
        
        System.out.println("a++: " + a++); // Muestra 10, pero luego a vale 11
        System.out.println("++a: " + ++a); // Muestra 12
        
        System.out.println("a--: " + a--); // Muestra 12, pero luego a vale 11
        System.out.println("--a: " + --a); // Muestra 10
    }
}
```

#### **6. Operadores de Bit a Bit (Bitwise)**

Los operadores **bit a bit** se utilizan para realizar operaciones a nivel de bits en números enteros.

- **`&`**: AND bit a bit
- **`|`**: OR bit a bit
- **`^`**: XOR bit a bit
- **`~`**: NOT bit a bit (invierte los bits)
- **`<<`**: Desplazamiento a la izquierda
- **`>>`**: Desplazamiento a la derecha

```java
public class OperadoresBitwise {
    public static void main(String[] args) {
        int a = 5; // 0101 en binario
        int b = 3; // 0011 en binario
        
        System.out.println("a & b: " + (a & b)); // AND bit a bit
        System.out.println("a | b: " + (a | b)); // OR bit a bit
        System.out.println("a ^ b: " + (a ^ b)); // XOR bit a bit
        System.out.println("~a: " + (~a)); // NOT bit a bit
        
        System.out.println("a << 1: " + (a << 1)); // Desplazamiento a la izquierda
        System.out.println("a >> 1: " + (a >> 1)); // Desplazamiento a la derecha
    }
}
```

#### **7. Operadores Ternarios**

El **operador ternario** es una forma compacta de escribir una expresión `if-else`. Se utiliza cuando queremos devolver un valor basado en una condición.

```java
public class OperadorTernario {
    public static void main(String[] args) {
        int a = 10;
        int b = 5;
        
        int max = (a > b) ? a : b; // Si a es mayor que b, max es a, de lo contrario, max es b
        System.out.println("El mayor es: " + max);
    }
}
```

---

### **3️⃣ Resumen y Conclusión**

En Java, los **operadores** son herramientas fundamentales que permiten realizar **operaciones matemáticas**, **comparaciones**, **modificaciones de variables** y **manipulaciones a nivel de bits**. Los tipos principales de operadores en Java incluyen:

- **Aritméticos**: Para realizar operaciones matemáticas.
- **De comparación**: Para comparar valores y determinar relaciones.
- **Lógicos**: Para combinar condiciones booleanas.
- **De asignación**: Para modificar valores en variables.
- **Incremento/Decremento**: Para modificar el valor de una variable en 1.
- **Bit a bit**: Para manipular bits de números enteros.
- **Ternario**: Para expresar condiciones de manera compacta.

Al comprender cómo funcionan los operadores, se pueden escribir programas más eficientes, legibles y fáciles de mantener. Son elementos clave para el control del flujo de un programa, así como para la manipulación y procesamiento de datos en cualquier tipo de aplicación Java.
