## **🔥 Guía Completa sobre Condicionales en Java 🔥**

### **1️⃣ Introducción a los Condicionales en Java**

Los **condicionales** en Java permiten ejecutar diferentes bloques de código dependiendo de si una condición es **verdadera** o **falsa**. Son estructuras de control fundamentales que permiten que el flujo de un programa tome decisiones y ejecute acciones diferentes en función de los valores de las variables o resultados de las operaciones.

### **2️⃣ Tipos de Condicionales en Java**

Java tiene varias estructuras de control condicional que permiten manejar decisiones en el flujo del programa. Estas son:

#### **1. Sentencia `if`**

La sentencia `if` se utiliza para **evaluar una condición** y ejecutar un bloque de código solo si la condición es **verdadera**.

```java
public class EjemploIf {
    public static void main(String[] args) {
        int edad = 18;
        if (edad >= 18) {
            System.out.println("Eres mayor de edad");
        }
    }
}
```

En este ejemplo, el bloque de código dentro del `if` solo se ejecuta si la condición `edad >= 18` es verdadera.

#### **2. Sentencia `if-else`**

La sentencia `if-else` es una **expansión** del `if`. Si la condición es **verdadera**, se ejecuta el bloque de código dentro del `if`; de lo contrario, se ejecuta el bloque de código dentro del `else`.

```java
public class EjemploIfElse {
    public static void main(String[] args) {
        int edad = 16;
        if (edad >= 18) {
            System.out.println("Eres mayor de edad");
        } else {
            System.out.println("Eres menor de edad");
        }
    }
}
```

En este caso, si la condición `edad >= 18` no es verdadera, el bloque dentro del `else` se ejecutará.

#### **3. Sentencia `else-if`**

La sentencia `else-if` se utiliza cuando tenemos múltiples condiciones a evaluar. Es una forma de **encadenar varios `if`**. Si la primera condición no es verdadera, la evaluación continúa con las siguientes condiciones.

```java
public class EjemploElseIf {
    public static void main(String[] args) {
        int edad = 25;
        if (edad < 18) {
            System.out.println("Eres menor de edad");
        } else if (edad <= 35) {
            System.out.println("Eres joven");
        } else {
            System.out.println("Eres adulto");
        }
    }
}
```

En este ejemplo, dependiendo del valor de `edad`, el programa imprimirá un mensaje diferente. Solo se ejecuta el primer bloque de código cuyo `if` es verdadero.

#### **4. Sentencia `switch`**

La sentencia `switch` permite **evaluar una expresión** y ejecutar un bloque de código basado en el valor de esa expresión. Es una forma más compacta de escribir condicionales múltiples cuando se tienen muchos casos posibles.

```java
public class EjemploSwitch {
    public static void main(String[] args) {
        int dia = 3;
        switch (dia) {
            case 1:
                System.out.println("Lunes");
                break;
            case 2:
                System.out.println("Martes");
                break;
            case 3:
                System.out.println("Miércoles");
                break;
            case 4:
                System.out.println("Jueves");
                break;
            case 5:
                System.out.println("Viernes");
                break;
            default:
                System.out.println("Fin de semana");
                break;
        }
    }
}
```

En este caso, dependiendo del valor de la variable `dia`, el programa imprimirá el día correspondiente. Si ningún caso coincide, se ejecutará el bloque dentro del `default`.

#### **5. Sentencia `switch` con cadenas (`String`)**

Desde Java 7, el `switch` también es compatible con el tipo `String`, lo cual es muy útil para comparar cadenas de texto de manera eficiente.

```java
public class EjemploSwitchString {
    public static void main(String[] args) {
        String color = "rojo";
        switch (color) {
            case "rojo":
                System.out.println("El color es rojo");
                break;
            case "verde":
                System.out.println("El color es verde");
                break;
            case "azul":
                System.out.println("El color es azul");
                break;
            default:
                System.out.println("Color no reconocido");
                break;
        }
    }
}
```

Este ejemplo muestra cómo `switch` se puede usar con cadenas, lo cual mejora la legibilidad y el rendimiento en comparación con múltiples `if`-`else`.

---

### **3️⃣ Expresiones Booleanas y Condiciones**

#### **1. Operadores de Comparación**

En Java, las condiciones dentro de los condicionales generalmente se basan en **expresiones booleanas**. Estas expresiones devuelven **verdadero (true)** o **falso (false)**.

Los operadores de comparación más comunes son:

- **`==`**: Igual a
- **`!=`**: Diferente de
- **`>`**: Mayor que
- **`<`**: Menor que
- **`>=`**: Mayor o igual que
- **`<=`**: Menor o igual que

```java
public class EjemploComparacion {
    public static void main(String[] args) {
        int x = 10;
        int y = 20;
        if (x < y) {
            System.out.println("x es menor que y");
        }
    }
}
```

#### **2. Operadores Lógicos**

También se pueden combinar varias condiciones con los **operadores lógicos**:

- **`&&`** (AND): Devuelve `true` si ambas condiciones son verdaderas.
- **`||`** (OR): Devuelve `true` si al menos una de las condiciones es verdadera.
- **`!`** (NOT): Invierte el valor lógico de la condición.

```java
public class EjemploOperadoresLogicos {
    public static void main(String[] args) {
        int edad = 20;
        boolean tienePermiso = true;
        
        if (edad >= 18 && tienePermiso) {
            System.out.println("Puedes conducir");
        }
    }
}
```

En este ejemplo, la condición se evalúa como verdadera si **edad es mayor o igual a 18** y **tienePermiso es verdadero**.

---

### **4️⃣ Jerarquía de Evaluación de Condiciones**

Cuando se usan varias condiciones en un `if`, `else-if`, o `switch`, es importante entender la **jerarquía de evaluación**:

- En una secuencia de **`if-else-if`**, el programa evalúa las condiciones de arriba hacia abajo, ejecutando el primer bloque de código cuyo `if` sea verdadero.
- En un **`switch`**, la evaluación de la expresión se realiza en función del valor específico de la variable.

**Importante**: El orden de las condiciones en un `if-else-if` puede afectar el comportamiento del programa. Siempre debe colocarse la condición más **específica** primero para evitar errores.

```java
public class EjemploOrden {
    public static void main(String[] args) {
        int numero = 10;
        
        if (numero > 10) {
            System.out.println("Mayor que 10");
        } else if (numero > 5) {
            System.out.println("Mayor que 5");
        } else {
            System.out.println("Menor o igual a 5");
        }
    }
}
```

En este caso, el orden es importante: si la condición `numero > 5` se coloca antes de `numero > 10`, **no se evaluará correctamente**.

---

### **5️⃣ Mejores Prácticas para Condicionales**

- **Simplicidad**: Intenta hacer que tus condicionales sean **simples y fáciles de entender**. Evita condiciones complejas que dificulten la lectura del código.
- **Evitar anidamiento excesivo**: Si tienes muchos `if` dentro de otros `if`, considera refactorizar tu código para hacerlo más limpio y legible.
- **Usar `switch` cuando haya múltiples opciones**: Si tienes muchas condiciones basadas en una misma variable, es más eficiente usar un `switch` en lugar de múltiples `if`-`else-if`.
- **Evitar el uso de `else` innecesarios**: Si un bloque `if` cubre todas las posibles condiciones, no es necesario un `else` o un `default`.

---

### **6️⃣ Resumen y Conclusión**

Los **condicionales** en Java permiten que el flujo de ejecución del programa se adapte a diferentes situaciones mediante la evaluación de **condiciones**. Las principales estructuras son `if`, `else-if`, `else`, y `switch`. Utilizar los operadores de comparación y los operadores lógicos te permite crear condiciones complejas para tomar decisiones dentro de tu código.

Es fundamental:
- Evaluar correctamente las condiciones.
- Elegir el tipo de estructura condicional que mejor se adapte a la situación.
- Escribir condiciones claras y legibles para mantener un código eficiente y fácil de entender.

Los condicionales son herramientas poderosas para **controlar el flujo** y **tomar decisiones dinámicas** en el programa, lo que permite construir aplicaciones más robustas y con mayor capacidad de interacción con el usuario o el entorno.
