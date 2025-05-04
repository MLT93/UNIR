## **🔥 Guía Completa sobre los Bucles en Java 🔥**

### **1️⃣ Introducción a los Bucles en Java**

En **Java**, los bucles (o **ciclos**) son estructuras de control que permiten ejecutar un bloque de código varias veces de manera repetitiva, dependiendo de una condición. Los bucles son fundamentales en la programación para realizar tareas repetitivas sin tener que escribir código repetido.

Java ofrece varios tipos de bucles, cada uno adecuado para diferentes escenarios. Los bucles más comunes en Java son:

1. **Bucle `for`**
2. **Bucle `while`**
3. **Bucle `do-while`**
4. **Bucle `for-each`**

A continuación, se explican en detalle, incluyendo ejemplos prácticos de cómo se usan en Java.

---

### **2️⃣ El Bucle `for`**

El bucle **`for`** es probablemente el tipo de bucle más común. Es útil cuando sabes cuántas veces deseas que se repita un bloque de código. Su sintaxis general es:

```java
for (inicialización; condición; incremento) {
    // Bloque de código a ejecutar
}
```

- **Inicialización**: Es el primer paso, donde se inicializa una variable. Se ejecuta solo una vez antes de que el bucle empiece.
- **Condición**: Es una expresión booleana que se evalúa antes de cada iteración. Si la condición es **`true`**, el bloque de código dentro del bucle se ejecutará; si es **`false`**, el bucle se detendrá.
- **Incremento/Decremento**: Este paso se ejecuta después de cada iteración y normalmente se usa para modificar la variable de control.

#### **Ejemplo: Bucle `for` básico**

```java
public class BucleFor {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            System.out.println("El valor de i es: " + i);
        }
    }
}
```

**Explicación:**

- El bucle comienza con `i = 1`.
- Se ejecuta mientras `i <= 5`.
- Después de cada iteración, `i` se incrementa en 1.

**Salida:**

```
El valor de i es: 1
El valor de i es: 2
El valor de i es: 3
El valor de i es: 4
El valor de i es: 5
```

#### **Ejemplo: Bucle `for` con paso negativo (decreciendo)**

```java
public class BucleForDecreciente {
    public static void main(String[] args) {
        for (int i = 5; i >= 1; i--) {
            System.out.println("El valor de i es: " + i);
        }
    }
}
```

**Salida:**

```
El valor de i es: 5
El valor de i es: 4
El valor de i es: 3
El valor de i es: 2
El valor de i es: 1
```

---

### **3️⃣ El Bucle `while`**

El bucle **`while`** ejecuta un bloque de código mientras una condición sea **`true`**. La diferencia principal con el bucle **`for`** es que **`while`** no tiene una parte de incremento/decremento por defecto y se usa cuando no se sabe cuántas veces se ejecutará el bucle. La sintaxis es la siguiente:

```java
while (condición) {
    // Bloque de código a ejecutar
}
```

**Ejemplo: Bucle `while` básico**

```java
public class BucleWhile {
    public static void main(String[] args) {
        int i = 1;
        while (i <= 5) {
            System.out.println("El valor de i es: " + i);
            i++;  // Incremento manual
        }
    }
}
```

**Explicación:**

- El bucle comienza con `i = 1`.
- Se ejecuta mientras `i <= 5`.
- Después de cada iteración, `i` se incrementa en 1 (manualmente).

**Salida:**

```
El valor de i es: 1
El valor de i es: 2
El valor de i es: 3
El valor de i es: 4
El valor de i es: 5
```

**Ejemplo: Bucle `while` con condición falsa al principio**

```java
public class BucleWhileFalso {
    public static void main(String[] args) {
        int i = 6;
        while (i <= 5) {
            System.out.println("Este código no se ejecutará.");
        }
    }
}
```

**Salida:**

```
(No imprime nada, ya que la condición es falsa desde el principio.)
```

**Ejemplo: Bucle `while` + `switch` para crear un menú (es poco usado para para crear menús)**

```java
import java.util.Scanner;

public class MenuWhileSwitch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option = 0;

        System.out.println("\n\r--- MENÚ PRINCIPAL ---\n\r");

        while (option != 3) {
            System.out.println("1. Saludar");
            System.out.println("2. Mostrar hora");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.println("¡Hola, usuario!");
                    break;
                case 2:
                    System.out.println("Hora actual: " + java.time.LocalTime.now());
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }

        sc.close();
    }
}
```

**Ejemplo: Bucle `while` para la entrada del usuario (se usa bastante para pedir info al usuario)**

```java
Scanner sc = new Scanner(System.in);
int edad;
System.out.print("Introduce tu edad: ");
edad = sc.nextInt();
while (edad < 0 || edad > 120) {
    System.out.print("Edad no válida. Introduce tu edad: ");
    edad = sc.nextInt();
}

```

---

### **4️⃣ El Bucle `do-while`**

El bucle **`do-while`** es similar al **`while`**, pero tiene la diferencia de que **siempre ejecuta el bloque de código al menos una vez**, incluso si la condición es falsa al principio. La sintaxis es la siguiente:

```java
do {
    // Bloque de código a ejecutar
} while (condición);
```

**Ejemplo: Bucle `do-while` básico**

```java
public class BucleDoWhile {
    public static void main(String[] args) {
        int i = 6;
        do {
            System.out.println("El valor de i es: " + i);
            i++;
        } while (i <= 5);
    }
}
```

**Explicación:**

- El bloque de código se ejecuta al menos una vez, aunque la condición `i <= 5` no sea verdadera en el primer ciclo.
- Después de cada iteración, `i` se incrementa en 1.

**Salida:**

```
El valor de i es: 1
El valor de i es: 2
El valor de i es: 3
El valor de i es: 4
El valor de i es: 5
```

**Ejemplo: Bucle `do-while` + `switch` para crear un menú (se usa bastante para crear menús)**

```java
import java.util.Scanner;

public class MenuDoWhileSwitch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n\r--- MENÚ PRINCIPAL ---\n\r");
            System.out.println("1. Saludar");
            System.out.println("2. Mostrar hora");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("¡Hola, usuario!");
                    break;
                case 2:
                    System.out.println("Hora actual: " + java.time.LocalTime.now());
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 3);

        sc.close();
    }
}
```

---

### **5️⃣ El Bucle `for-each`**

El **`for-each`** es una versión simplificada del bucle `for` diseñado específicamente para recorrer **colecciones** de datos como arrays, listas, y otros tipos de colecciones de Java. Su sintaxis es:

```java
for (tipoDeDato variable : colección) {
    // Bloque de código a ejecutar
}
```

**Ejemplo: Bucle `for-each` sobre un array**

```java
public class BucleForEach {
    public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 4, 5};
      
        for (int num : numeros) {
            System.out.println("El valor del número es: " + num);
        }
    }
}
```

**Explicación:**

- El bucle recorre automáticamente el array `numeros` y asigna cada valor a la variable `num` en cada iteración.

**Salida:**

```
El valor del número es: 1
El valor del número es: 2
El valor del número es: 3
El valor del número es: 4
El valor del número es: 5
```

---

### **6️⃣ Resumen de los Tipos de Bucles en Java**

- **Bucle `for`**: Ideal cuando conoces la cantidad de iteraciones. Es útil para realizar repeticiones controladas.
- **Bucle `while`**: Ideal para bucles indefinidos que dependen de una condición externa. Se ejecuta mientras la condición sea verdadera.
- **Bucle `do-while`**: Similar al `while`, pero garantiza que el bloque de código se ejecute al menos una vez, incluso si la condición es falsa.
- **Bucle `for-each`**: Simplificado para recorrer colecciones de datos como arrays y listas sin necesidad de usar un índice manualmente.

### **7️⃣ Consideraciones Importantes:**

- **Evitar bucles infinitos**: Asegúrate de que la condición de un bucle cambie para evitar un bucle infinito, lo que puede hacer que tu programa se congele.
- **Control de flujo dentro de bucles**:
  - **`break`**: Permite salir de un bucle antes de que la condición sea falsa.
  - **`continue`**: Permite saltar una iteración del bucle y continuar con la siguiente.

---

### **8️⃣ Conclusión**

En **Java**, los bucles son estructuras esenciales para realizar tareas repetitivas. Saber cuándo y cómo usar cada tipo de bucle es clave para escribir código eficiente y fácil de mantener. Ya sea utilizando un bucle `for`, `while`, `do-while`, o `for-each`, cada uno tiene su caso de uso ideal.
