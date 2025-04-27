### 📌 **Componentes del Diagrama de Clases UML**

#### **1️⃣ Clase Abstracta: `ConnectBBDD`**

- **Descripción**: Clase abstracta que implementa el patrón Singleton para gestionar la conexión a la base de datos.

- **Atributos**:
  - `- instancia: ConnectBBDD`
  - `- conexion: Connection`

- **Métodos**:
  - `+ getInstancia(): ConnectBBDD`
  - `+ conectar(): void`
  - `+ desconectar(): void` **[Singleton Design Pattern - Medium](https://medium.com/%40mopurisreenath/singleton-design-pattern-1026374be6b2)**

- **Notas**:
  - El constructor es privado o protegido para evitar instancias directas y repetir la conexión a la base de datos.
  - El método `getInstancia()` asegura que solo exista una instancia de la clase. **[Singleton](https://es.wikipedia.org/wiki/Singleton)**.

#### **2️⃣ Interfaces y Clases de Entidades**

Para cada entidad (`Equipos`, `Jugadores`, `Partidas`, `Premios`, `Torneos`), se define:

- **Interfaz `IEntidad`**:
  - Define los métodos que deben implementar las clases concretas.

- **Clase `EntidadImpl`**:
  - Implementa la interfaz `IEntidad`.
  - Extiende de `ConnectBBDD` para acceder a la conexión a la base de datos.

**Ejemplo para `Equipos`**:

- **Interfaz `IEquipos`**:
  - `+ agregarEquipo(equipo: Equipo): void`
  - `+ obtenerEquipo(id: int): Equipo` **[Singleton - Design Patterns in TypeScript](https://sbcode.net/typescript/singleton/)**.

- **Clase `EquiposImpl`**:
  - Extiende de `ConnectBBDD`.
  - Implementa `IEquipos`.

Este patrón se repite para las demás entidades: `Jugadores`, `Partidas`, `Premios` y `Torneos`.

---

### 🎨 **Representación Gráfica del Diagrama de Clases**


```plaintext
┌────────────────────────────┐
│        ConnectBBDD          │
│----------------------------│
│ - instancia: ConnectBBDD    │
│ - conexion: Connection     │
│----------------------------│
│ + getInstancia(): ConnectBBDD │
│ + conectar(): void         │
│ + desconectar(): void      │
└────────────────────────────┘
           ▲
           │
           │
┌────────────────────────────┐
│        EquiposImpl         │
│----------------------------│
│ + agregarEquipo(equipo): void │
│ + obtenerEquipo(id): Equipo   │
└────────────────────────────┘
           ▲
           │
           │
┌────────────────────────────┐
│          IEquipos          │
│----------------------------│
│ + agregarEquipo(equipo): void │
│ + obtenerEquipo(id): Equipo   │
└────────────────────────────┘

(Similar estructura para JugadoresImpl/IJugadores, PartidasImpl/IPartidas, etc.)
```


---

### 🚀 **Guía Paso a Paso para Implementar este Diseño**

1. **Definir la Clase Abstracta `ConnectBBDD`**:
   - Implementar el patrón Singleton asegurando que solo exista una instancia de conexión a la base de datos.
   - Incluir métodos para conectar y desconectar la base de datos.

2. **Crear Interfaces para Cada Entidad**:
   - Definir los métodos que deben implementar las clases concretas para cada entidad (`IEquipos`, `IJugadores`, etc.).

3. **Implementar Clases Concretas para Cada Entidad**:
   - Cada clase (`EquiposImpl`, `JugadoresImpl`, etc.) debe:
     - Extender de `ConnectBBDD` para acceder a la conexión.
     - Implementar su respectiva interfaz para asegurar la implementación de los métodos definidos.

4. **Utilizar las Clases en la Aplicación**:
   - Instanciar las clases concretas y utilizar los métodos definidos para interactuar con la base de datos.

---

### 🧠 **Consejos y Buenas Prácticas**

- **Encapsulamiento**: Mantén los atributos de las clases como privados o protegidos para proteger la integridad de los datos.

- **Modularidad**: Separar la lógica de conexión (`ConnectBBDD`) de la lógica de negocio (clases de entidades) mejora la mantenibilidad del código.

- **Reutilización**: Al utilizar interfaces e implementar el patrón Singleton, se facilita la reutilización y escalabilidad del código.

- **Documentación**: Documenta cada clase e interfaz para facilitar la comprensión y mantenimiento del sistema.

---

### 🔗 **Recursos Adicionales**

- **[Diagramas de Clases UML en PlantUML](https://plantuml.com/class-diagram)**
- **[Patrón Singleton en GeeksforGeeks](https://www.geeksforgeeks.org/singleton-design-pattern/)**
