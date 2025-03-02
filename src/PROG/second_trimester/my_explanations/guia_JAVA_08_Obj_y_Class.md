## **🔥 Guía Completa sobre Objetos y Clases en Java 🔥**

### **1️⃣ Introducción a Objetos y Clases en Java**

En **Java**, los **objetos** son instancias de **clases**. Una **clase** es una plantilla o modelo que define las propiedades (atributos) y comportamientos (métodos) que tendrán los objetos creados a partir de ella. Los objetos son instancias de esas clases y pueden contener valores específicos para los atributos definidos en la clase. **[Intro a POO](https://openwebinars.net/blog/introduccion-a-poo-en-java-atributos-y-constructores/)**

**Conceptos Clave**:

- **Clase**: Es una plantilla o definición para un objeto. Contiene atributos y métodos que definen el comportamiento y las características del objeto.
- **Objeto**: Es una instancia de una clase. Un objeto tiene su propio estado y comportamiento según lo definido por la clase.

---

### **2️⃣ Creación de una Clase en Java**

Para crear una clase en Java, debes definirla usando la palabra clave `class`, seguida del nombre de la clase. En Java, el nombre de la clase debe seguir las convenciones de nomenclatura, como empezar con una letra mayúscula (por convención).

#### **Sintaxis básica para crear una clase**:

```java
public class MiClase {
    // Atributos de la clase
    private String nombre;
    private int edad;
  
    // Constructor de la clase
    public MiClase(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Métodos de la clase
    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
    }

    // Getters y Setters (opcional, dependiendo de la necesidad de acceder a los atributos)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
```

#### **Entendiendo los Constructores**

Antes de sumergirnos en la asignación de tipos de datos, repasemos rápidamente qué son los constructores:

- **Métodos Especiales:** Los constructores son métodos especiales en una clase Java que se llaman automáticamente cuando se crea un objeto de esa clase.
- **Inicialización:** Su propósito principal es inicializar las variables de instancia (campos) del objeto con valores apropiados.
- **Mismo Nombre que la Clase:** El nombre de un constructor debe ser exactamente el mismo que el nombre de la clase.
- **Sin Tipo de Retorno:** Los constructores no tienen un tipo de retorno, ni siquiera `void`.

**Asignando Varios Tipos de Datos**

Cuando creas un constructor, defines sus parámetros, que determinan los tipos de datos que puede recibir. Estos parámetros se utilizan luego para asignar valores a las variables de instancia del objeto.

También existe la posibilidad de asignar más de un tipo de dato a un atributo en la clase, utilizando **Tipos Genéricos** que se explicarán en **guia_JAVA_09_Class_con_Tipos_Genericos.md**.

#### **Tipos de Datos Básicos (Primitivos):**
Los tipos de datos primitivos de Java incluyen `int`, `double`, `boolean`, `char`, `float`, `byte`, `short` y `long`.

```java
public class Producto {
    private int id;
    private String nombre;
    private double precio;
    private boolean enStock;

    // Constructor con tipos de datos primitivos
    public Producto(int id, String nombre, double precio, boolean enStock) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.enStock = enStock;
    }

    // Ejemplo de uso
    public static void main(String[] args) {
        Producto producto1 = new Producto(123, "Laptop", 1200.50, true);
        System.out.println("ID del Producto: " + producto1.id);
        System.out.println("Nombre del Producto: " + producto1.nombre);
        System.out.println("Precio del Producto: " + producto1.precio);
        System.out.println("Producto en Stock: " + producto1.enStock);
    }
}
```

- En este ejemplo, el constructor `Producto` toma parámetros `int`, `String`, `double` y `boolean`.
- La palabra clave `this` se utiliza para diferenciar entre las variables de instancia y los parámetros del constructor.

#### **Tipos de Datos de Referencia (Objetos):**
Los tipos de datos de referencia se refieren a objetos, como `String`, arrays e instancias de otras clases.

```java
public class Direccion {
    private String calle;
    private String ciudad;

    public Direccion(String calle, String ciudad) {
        this.calle = calle;
        this.ciudad = ciudad;
    }
}

public class Persona {
    private String nombre;
    private int edad;
    private Direccion direccion; // Referencia a un objeto Direccion

    public Persona(String nombre, int edad, Direccion direccion) {
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion;
    }

    public static void main(String[] args) {
        Direccion direccionCasa = new Direccion("123 Calle Principal", "Ciudad Cualquiera");
        Persona persona1 = new Persona("Alicia", 30, direccionCasa);
        System.out.println("Nombre de la Persona: " + persona1.nombre);
        System.out.println("Ciudad de la Persona: " + persona1.direccion.ciudad);
    }
}
```

- Aquí, el constructor `Persona` toma un objeto `Direccion` como parámetro.
- Esto demuestra cómo pasar y almacenar referencias a otros objetos dentro de una clase.

#### **Arrays y ArrayList:**
Los arrays también son tipos de referencia, y puedes pasarlos a los constructores.

```java
// Array normal
public class Estudiante {
    private String nombre;
    private int[] calificaciones;

    public Estudiante(String nombre, int[] calificaciones) {
        this.nombre = nombre;
        this.calificaciones = calificaciones;
    }

    public static void main(String[] args) {
        int[] calificacionesEstudiante = {90, 85, 95};
        Estudiante estudiante1 = new Estudiante("Bob", calificacionesEstudiante);
        System.out.println("Nombre del Estudiante: " + estudiante1.nombre);
        System.out.println("Primera Calificación: " + estudiante1.calificaciones[0]);
    }
}
```

```java
// Con ArrayList
import java.util.ArrayList;

public class Estudiante {
    private String nombre;
    private ArrayList<Integer> calificaciones;

    public Estudiante(String nombre, ArrayList<Integer> calificaciones) {
        this.nombre = nombre;
        this.calificaciones = calificaciones;
    }

    public static void main(String[] args) {
        ArrayList<Integer> calificacionesEstudiante = new ArrayList<>();
        calificacionesEstudiante.add(90);
        calificacionesEstudiante.add(85);
        calificacionesEstudiante.add(95);

        Estudiante estudiante1 = new Estudiante("Bob", calificacionesEstudiante);
        System.out.println("Nombre del Estudiante: " + estudiante1.nombre);
        System.out.println("Primera Calificación: " + estudiante1.calificaciones.get(0));

        // Ejemplo de añadir una nueva calificación
        estudiante1.calificaciones.add(100);
        System.out.println("Calificaciones Actualizadas: " + estudiante1.calificaciones);
    }
}
```

- El constructor `Estudiante` toma un `int[]` (array de enteros) como parámetro.

**Consideraciones Clave**

- **Sobrecarga de Constructores:** Puedes tener múltiples constructores en una clase con diferentes listas de parámetros (sobrecarga de constructores). Esto te permite crear objetos con diferentes niveles de inicialización.
- **Constructor Predeterminado:** Si no defines ningún constructor, Java proporciona un constructor predeterminado sin argumentos.
- **Validación de Datos:** Es una buena práctica validar los parámetros del constructor para asegurarte de que cumplen con tus requisitos.
- **Inmutabilidad:** Si quieres crear objetos inmutables (objetos cuyo estado no se puede cambiar después de la creación), inicializa todas las variables de instancia en el constructor y hazlas `final`.

---

### **3️⃣ Componentes de una Clase**

1. **Atributos** (también llamados variables de instancia o campos):
   - Son las propiedades del objeto.
   - Se definen dentro de la clase, pero fuera de los métodos.
   - El modificador de acceso más común para los atributos es `private`, lo que ayuda a implementar el principio de **encapsulación**.

2. **Métodos**:
   - Son las funciones o acciones que puede realizar un objeto de esa clase.
   - Los métodos pueden tener modificadores de acceso como `public`, `private` o `protected`.
   - Los métodos suelen definir la lógica para manipular los atributos del objeto.

3. **Constructores**:
   - Son especiales en las clases y se utilizan para inicializar los objetos cuando se crean.
   - Un constructor tiene el mismo nombre que la clase y no tiene tipo de retorno.
   - Si no se define un constructor, Java proporciona un constructor predeterminado sin argumentos.

4. **Getters y Setters**:
   - Son métodos que permiten acceder o modificar los valores de los atributos de un objeto.
   - Los **getters** retornan el valor de un atributo.
   - Los **setters** modifican el valor de un atributo.

---

### **4️⃣ Creación de un Objeto a partir de una Clase**

Para crear un objeto, se utiliza la palabra clave `new` seguida del constructor de la clase. El constructor inicializa los atributos del objeto.

#### **Sintaxis para crear un objeto**:

```java
// Crear un objeto de la clase MiClase
MiClase objeto = new MiClase("Juan", 25);
```

En este ejemplo, el objeto `objeto` es una instancia de la clase `MiClase`, y se inicializa con el nombre `"Juan"` y la edad `25`.

#### **Uso del objeto**:

```java
public class Main {
    public static void main(String[] args) {
        // Crear el objeto
        MiClase persona = new MiClase("Carlos", 30);
      
        // Llamar a un método del objeto
        persona.mostrarInformacion();
    }
}
```

**Salida:**

```
Nombre: Carlos
Edad: 30
```

---

### **5️⃣ Tipos de Métodos en una Clase**

Dentro de las clases, puedes tener diferentes tipos de métodos. Los más comunes son:

#### **Métodos de instancia**:

- Son métodos que operan sobre los atributos de un objeto específico.
- Se acceden a través de una instancia de la clase (un objeto).

```java
public void saludar() {
    System.out.println("Hola, " + nombre);
}
```

#### **Métodos estáticos (static)**:

- Son métodos que pertenecen a la clase, no a los objetos.
- Se pueden invocar directamente utilizando el nombre de la clase.
- No se puede acceder a los atributos de instancia de la clase (ya que no pertenecen a un objeto específico).

```java
public static void imprimirMensaje() {
    System.out.println("Este es un mensaje estático");
}
```

**Uso de un método estático:**

```java
MiClase.imprimirMensaje();
```

---

### **6️⃣ Ejemplo Completo: Creación de una Clase con Atributos, Métodos y Constructor**

```java
public class Persona {
    // Atributos
    private String nombre;
    private int edad;
  
    // Constructor
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Métodos
    public void saludar() {
        System.out.println("Hola, soy " + nombre + " y tengo " + edad + " años.");
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    // Método estático
    public static void imprimirMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
```

**Uso en `Main`**:

```java
public class Main {
    public static void main(String[] args) {
        // Crear objetos
        Persona p1 = new Persona("Juan", 25);
        Persona p2 = new Persona("Ana", 28);
      
        // Llamar a métodos
        p1.saludar();
        p2.saludar();
      
        // Llamada a un método estático
        Persona.imprimirMensaje("Mensaje de clase Persona");
    }
}
```

**Salida:**

```
Hola, soy Juan y tengo 25 años.
Hola, soy Ana y tengo 28 años.
Mensaje de clase Persona
```

---

### **7️⃣ Conceptos Avanzados**

- **Encapsulación**: En Java, se recomienda utilizar modificadores de acceso como `private` para los atributos y acceder/modificar estos valores a través de métodos `public` (getters y setters). Esto ayuda a controlar el acceso y modificar el comportamiento de los objetos sin exponer directamente los atributos.
- **Polimorfismo**: El polimorfismo permite que un objeto sea tratado como una instancia de su clase base (superclase). El polimorfismo también permite que un método se comporte de diferentes maneras según el objeto que lo invoque.
- **Herencia**: En Java, una clase puede heredar de otra clase usando la palabra clave `extends`. Esto permite que la clase hija herede los atributos y métodos de la clase padre.

---

### **8️⃣ Conclusión**

En Java, la creación de clases y objetos es fundamental para la programación orientada a objetos (OOP). Las clases definen los **atributos** y **comportamientos** de los objetos, mientras que los objetos son instancias de esas clases que contienen valores específicos. Al entender cómo funcionan las clases y los objetos, puedes estructurar tu código de manera eficiente, reutilizarlo y hacer que tu programa sea más modular y mantenible.

- **Clases**: Plantillas que definen la estructura de un objeto.
- **Objetos**: Instancias de clases que tienen datos y comportamientos específicos.
