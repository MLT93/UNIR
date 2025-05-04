## **🔥 Guía Completa sobre Variables en Java 🔥**

### **1️⃣ Introducción a las Variables en Java**

Las **variables** en Java son elementos fundamentales en cualquier programa, ya que permiten almacenar **valores** que pueden ser utilizados y manipulados durante la ejecución del código. Estas variables son una representación de las **ubicaciones de memoria** dentro del programa, donde se almacenan los datos.

### **2️⃣ Tipos de Variables en Java**

En Java, las variables se pueden clasificar en varias categorías según su **alcance**, **tipo** y **lugar de almacenamiento**. Las variables son elementos clave para trabajar con **datos dinámicos** y **referencias a objetos**. Los principales tipos de variables en Java son:

#### **Variables locales**
- Son aquellas definidas dentro de un **método** o **bloque de código** y sólo pueden ser utilizadas dentro de ese método o bloque.
- Se **inicializan** en el momento de la declaración.

```java
public class VariablesLocales {
    public void ejemplo() {
        int numero = 10;  // Variable local
        System.out.println(numero);
    }
}
```

#### **Variables de instancia**
- Son variables declaradas dentro de una clase pero **fuera de los métodos**.
- Cada **instancia de la clase** (objeto) tiene una copia de estas variables.
- Son **inicializadas automáticamente** con valores por defecto si no se asignan explícitamente (por ejemplo, `null` para objetos, `0` para `int`).

```java
public class Persona {
    private String nombre;  // Variable de instancia

    public void setNombre(String nombre) {
        this.nombre = nombre;  // Asignación
    }
}
```

#### **Variables de clase (o estáticas)**
- Son variables que se declaran con la palabra clave `static` y son **compartidas** por todas las instancias de una clase.
- Tienen un **valor común** para todos los objetos de la clase.

```java
public class CuentaBancaria {
    static int totalCuentas = 0;  // Variable de clase

    public CuentaBancaria() {
        totalCuentas++;
    }
}
```

#### **Variables finales (constantes)**
- Se declara con la palabra clave `final` para hacer que su valor no pueda modificarse después de ser asignado.
- Generalmente se escriben en **mayúsculas** para indicar que son constantes.

```java
public class Constantes {
    public static final int MAX_EDAD = 100;  // Variable constante
}
```

---

### **3️⃣ Tipos de Datos en Java**

Las variables en Java tienen un tipo de datos asociado que determina qué tipo de valor pueden almacenar. Estos tipos se dividen en dos grandes categorías: **tipos primitivos** y **tipos de referencia**.

#### **Tipos Primitivos**
- Son los **tipos de datos básicos** que no son objetos. Son almacenados directamente en la memoria.
- Los **tipos primitivos** incluyen: `byte`, `short`, `int`, `long`, `float`, `double`, `char`, `boolean`.

```java
int edad = 30;       // Tipo primitivo (int)
char letra = 'A';    // Tipo primitivo (char)
boolean esVerdad = true;  // Tipo primitivo (boolean)
```

#### **Tipos de Referencia (Objetos)**
- Son aquellos que **hacen referencia a objetos** de clases o arrays. En lugar de almacenar directamente el valor, **almacenan la dirección** de memoria del objeto.
- Los **tipos de referencia** incluyen: `String`, `Array`, **clases** personalizadas.

```java
String nombre = "Juan";  // Tipo de referencia (String)
Persona persona = new Persona();  // Tipo de referencia (objeto de clase Persona)
```

---

### **4️⃣ Cómo se Manejan las Variables en la Memoria**

#### **Variables Primitivas**
- Las **variables primitivas** se almacenan **directamente** en la **memoria stack**. Esto significa que cuando una variable de tipo primitivo se pasa como parámetro a un método, su **valor** se pasa directamente (esto se llama **paso por valor**).

#### **Variables de Referencia**
- Las **variables de referencia** almacenan una **dirección de memoria** (es decir, **una referencia** a un objeto). El objeto en sí se almacena en la **memoria heap**.
- Cuando una variable de referencia se pasa a un método, lo que realmente se pasa es la **referencia** (dirección de memoria), no una copia del objeto. Esto se llama **paso por referencia**.

### **5️⃣ Copia por Valor vs. Copia por Referencia**

En Java, las variables de tipo primitivo y las variables de tipo referencia se manejan de manera diferente en cuanto al **paso de argumentos** en métodos.

#### **Copia por Valor (para tipos primitivos)**

Cuando pasamos una **variable primitiva** a un método, el valor se **copia** directamente, por lo que cualquier cambio realizado dentro del método **no afecta** a la variable original.

```java
public class CopiaPorValor {
    public static void modificarValor(int numero) {
        numero = 50;  // Esto no afecta al valor original
    }

    public static void main(String[] args) {
        int numero = 10;
        modificarValor(numero);  // Se pasa por valor
        System.out.println(numero);  // Imprime 10, no 50
    }
}
```

En este ejemplo, el valor de `numero` es copiado al método, por lo que la modificación dentro del método **no afecta al valor original**.

#### **Copia por Referencia (para objetos)**

Cuando pasamos un **objeto** (es decir, una variable de tipo referencia) a un método, lo que realmente estamos pasando es la **referencia** (dirección de memoria). Esto significa que si cambiamos un atributo del objeto dentro del método, **el objeto original se verá modificado**.

```java
class Persona {
    String nombre;

    public Persona(String nombre) {
        this.nombre = nombre;
    }
}

public class CopiaPorReferencia {
    public static void modificarPersona(Persona p) {
        p.nombre = "Carlos";  // Se modifica el objeto original
    }

    public static void main(String[] args) {
        Persona persona = new Persona("Juan");
        modificarPersona(persona);  // Se pasa por referencia
        System.out.println(persona.nombre);  // Imprime "Carlos"
    }
}
```

En este ejemplo, como `persona` es un objeto, cuando lo pasamos al método, lo que pasamos es una **referencia** al objeto. Cualquier cambio que se haga dentro del método afectará al **objeto original**.

---

### **6️⃣ Almacenamiento en Memoria: Stack vs. Heap**

En Java, la memoria se organiza en dos áreas principales: **stack** y **heap**.

#### **Memoria Stack**
- La **memoria stack** almacena las **variables primitivas** y las referencias a los objetos.
- Las variables locales, como los parámetros de los métodos, se almacenan en la **stack**.

#### **Memoria Heap**
- La **memoria heap** es donde se almacenan los **objetos** en Java. Cuando se crea un objeto con `new`, este se almacena en el heap, y la variable de referencia almacena la **dirección de memoria** de ese objeto.

---

### **7️⃣ Variables Estáticas y el Contexto de Memoria**

Las **variables estáticas** (`static`) son variables asociadas a la **clase** en lugar de a una **instancia** de la clase. Esto significa que todas las instancias de la clase comparten la misma variable estática.

```java
class Contador {
    static int cuenta = 0;  // Variable estática

    public Contador() {
        cuenta++;
    }
}

public class Main {
    public static void main(String[] args) {
        Contador c1 = new Contador();
        Contador c2 = new Contador();
        System.out.println(Contador.cuenta);  // Imprime 2
    }
}
```

En este ejemplo, tanto `c1` como `c2` comparten la misma variable `cuenta`, que se almacena de manera única en la memoria **heap** y está asociada a la **clase**.

---

### **8️⃣ Conclusión**

Las **variables** en Java son elementos clave para almacenar y manipular datos durante la ejecución de un programa. Dependiendo del **tipo de variable** (primitiva o referencia), la forma en que se **almacenan** y se **pasan** entre métodos cambia.

Recapitulación:
- Las **variables primitivas** se almacenan en la **stack** y se pasan por **valor**.
- Las **variables de referencia** se almacenan en la **heap** y se pasan por **referencia**.
- Las **variables estáticas** son compartidas entre todas las instancias de una clase y se almacenan de forma **única** en la **heap**.

Este entendimiento de las **variables** y su **manejo en memoria** es esencial para escribir código más eficiente y comprender cómo Java maneja la **asignación de memoria** durante la ejecución del programa.
