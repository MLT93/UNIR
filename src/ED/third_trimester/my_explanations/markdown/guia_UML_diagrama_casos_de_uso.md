### 🤔 **¿Qué es un diagrama de casos de uso UML?**

Un **diagrama de casos de uso UML** representa gráficamente las interacciones entre los **actores** (usuarios o sistemas externos) y el **sistema** que se está modelando, mostrando las funcionalidades (casos de uso) que el sistema ofrece. Es una herramienta esencial para capturar los requisitos funcionales y comprender el comportamiento del sistema desde la perspectiva del usuario. **[Diagrama de casos de uso](https://es.wikipedia.org/wiki/Diagrama_de_casos_de_uso?utm_source=chatgpt.com)**.

---

### 📌 **Componentes clave de un diagrama de casos de uso**

- **Actores**: Representados por figuras de palito, son entidades externas que interactúan con el sistema.
- **Casos de uso**: Representados por óvalos, describen las funcionalidades o servicios que el sistema proporciona a los actores.
- **Sistema**: Representado por un rectángulo que encapsula los casos de uso, define el límite del sistema.
- **Relaciones**: Líneas que conectan actores con casos de uso o entre casos de uso, indicando interacciones o dependencias.

---

### 🎯 **¿Para qué sirve un diagrama de casos de uso UML?**

✅ **Capturar requisitos funcionales**: Ayuda a identificar y documentar las funcionalidades que el sistema debe ofrecer.

✅ **Comunicación con stakeholders**: Proporciona una representación visual comprensible para usuarios, analistas y desarrolladores.

✅ **Definir el alcance del sistema**: Clarifica qué funcionalidades están dentro o fuera del sistema.

✅ **Identificar interacciones externas**: Muestra cómo los actores externos interactúan con el sistema.

---

### 🚀 **Guía paso a paso para crear un diagrama de casos de uso UML**

#### **1️⃣ Identificar los actores**

📍 **¿Quién interactúa con el sistema?**

- Usuarios finales
- Sistemas externos
- Organizaciones **[Use Case Diagram – Unified Modeling Language (UML)](https://www.geeksforgeeks.org/use-case-diagram/?utm_source=chatgpt.com)**

💡 **Ejemplo**: En un sistema de reservas de vuelos, los actores podrían ser "Cliente", "Agente de viajes" y "Sistema de pago".

---

#### **2️⃣ Identificar los casos de uso**

📍 **¿Qué funcionalidades ofrece el sistema?**

- Reservar vuelo
- Cancelar reserva
- Emitir boleto **[Use Case - Extend and Include : r/businessanalysis - Reddit](https://www.reddit.com/r/businessanalysis/comments/zt7o23/use_case_extend_and_include/)**

💡 **Ejemplo**: El caso de uso "Reservar vuelo" implica seleccionar vuelos, ingresar información del pasajero y realizar el pago.

---

#### **3️⃣ Establecer relaciones entre actores y casos de uso**

📍 **¿Cómo interactúan los actores con el sistema?**

- Conectar actores con los casos de uso que utilizan mediante líneas.

💡 **Ejemplo**: El "Cliente" está conectado a "Reservar vuelo" y "Cancelar reserva".

---

#### **4️⃣ Definir relaciones entre casos de uso**

📍 **¿Hay funcionalidades comunes o variantes?**

- **<<include>>**: Cuando un caso de uso siempre incluye el comportamiento de otro (por defecto se acciona).
- **<<extend>>**: Cuando un caso de uso opcional extiende el comportamiento de otro bajo ciertas condiciones (uso condicional). **[Include vs Extend in Use Case Diagrams: Pros and Cons - LinkedIn](https://www.linkedin.com/advice/1/what-benefits-drawbacks-using-include)**.

💡 **Ejemplo**:

- "Reservar vuelo" <<include>> "Procesar pago" (el pago es siempre necesario).
- "Reservar vuelo" <<extend>> "Seleccionar asiento preferido" (opcional).

---

#### **5️⃣ Dibujar el sistema**

📍 **Representar gráficamente el sistema**

- Dibujar un rectángulo que encapsule los casos de uso.
- Colocar los actores fuera del rectángulo.

💡 **Ejemplo**: El rectángulo representa el "Sistema de Reservas de Vuelos", conteniendo los casos de uso identificados.

---

### 📌 **Diferencias entre <<include>> y <<extend>>**

#### **<<include>>**

- **Uso**: Cuando múltiples casos de uso comparten un comportamiento común obligatorio.
- **Relación**: El caso de uso base incluye siempre al caso de uso incluido.
- **Ejemplo**: "Procesar pago" es una funcionalidad común que se incluye en "Reservar vuelo" y "Comprar equipaje adicional".

#### **<<extend>>**

- **Uso**: Para modelar comportamientos opcionales o condicionales.
- **Relación**: El caso de uso extendido se ejecuta solo bajo ciertas condiciones.
- **Ejemplo**: "Seleccionar asiento preferido" extiende "Reservar vuelo" si el cliente elige esa opción.

💡 **Nota**: Aunque `<<extend>>` puede parecer similar a la herencia en programación orientada a objetos, en UML se utiliza para modelar extensiones condicionales de comportamiento, no para compartir atributos o métodos como en la herencia de clases.

---

### 🧐 **¿Cuándo utilizar `<<include>>` y `<<extend>>`?**

#### **`<<include>>`**:

- Se utiliza cuando múltiples casos de uso comparten un comportamiento común.

- El caso de uso incluido siempre se ejecuta como parte del caso de uso principal.

- Ayuda a evitar la duplicación de comportamientos comunes. **[Two actors have same use case but can access different extends ...](https://softwareengineering.stackexchange.com/questions/439249/two-actors-have-same-use-case-but-can-access-different-extends-use-case-diagram?utm_source=chatgpt.com)**.

#### **`<<extend>>`**:

- Se utiliza para modelar comportamientos opcionales o condicionales. **[Structuring Use Cases with Base, Include, and Extend](https://guides.visual-paradigm.com/structuring-use-cases-with-base-include-and-extend-a-guide-for-effective-software-development/?utm_source=chatgpt.com)**.

- El caso de uso extendido se ejecuta solo si se cumple una condición específica.

- Permite mantener el caso de uso principal simple, delegando comportamientos adicionales a casos de uso extendidos.

---

### 🧠 **Trucos para simplificar la creación de diagramas de casos de uso**

- 🔹 **Enfócate en el valor para el actor**: Cada caso de uso debe representar una funcionalidad que aporte valor al actor.

- 🔹 **Evita la sobrecomplicación**: No intentes modelar todos los detalles en el diagrama; utiliza descripciones textuales para complementar.

- 🔹 **Utiliza relaciones adecuadas**: Aplica `<<include>>` y `<<extend>>` correctamente para mantener el diagrama claro y modular.

- 🔹 **Itera y valida**: Revisa el diagrama con los stakeholders para asegurarte de que refleja correctamente los requisitos.

---

### 🎨 **Dibujar el Diagrama**

📍 **Representar visualmente los elementos y sus relaciones.**

- Utilizar elipses para casos de uso.

- Figuras de palillo para actores.

- Líneas continuas para asociaciones.

- Flechas punteadas etiquetadas con <<include>> o <<extend>> según corresponda.

💡 **Herramientas recomendadas:**

- **[Lucidchart](https://www.lucidchart.com/)**

- **[Draw.io](https://app.diagrams.net/)**

- **[Creately](https://creately.com/)**

---

### 🚀 **Ejemplo práctico**

**Sistema de Reservas de Vuelos**

- **Actores**: Cliente, Agente de viajes
- **Casos de uso**:
  - Reservar vuelo
  - Procesar pago
  - Seleccionar asiento preferido

**Relaciones**:

- "Reservar vuelo" <<include>> "Procesar pago"
- "Reservar vuelo" <<extend>> "Seleccionar asiento preferido"

---

### 🔗 **Recursos adicionales**

- **[Video tutorial sobre diagramas de casos de uso UML (el mejor video)](https://www.youtube.com/watch?v=4emxjxonNRI)**
- **[Guía de diagramas de casos de uso en Lucidchart](https://www.lucidchart.com/pages/uml-use-case-diagram)**
- **[Tutorial de diagramas de casos de uso en Visual Paradigm](https://online.visual-paradigm.com/diagrams/tutorials/use-case-diagram-tutorial/)**
- **[Comprensive guide on Use Case Diagram](https://www.archimetric.com/comprehensive-guide-on-use-cases-and-the-concepts-of-extend-and-include/?utm_source=chatgpt.com)**
- **[UML Use Case Diagram: Actors and relationships - Sparx Systems](https://www.sparxsystems.eu/languages/uml/diagrams/usecasediagram/)**
- **[Use Case Diagram - UML 2 Tutorial - Sparx Systems](https://sparxsystems.com/resources/tutorials/uml2/use-case-diagram.html)**

---

### 🎯 **Conclusión**

Los diagramas de casos de uso UML son herramientas poderosas para capturar y comunicar los requisitos funcionales de un sistema. Comprender y aplicar correctamente las relaciones <<include>> y <<extend>> permite modelar de manera efectiva comportamientos comunes y variantes, facilitando el diseño y desarrollo de sistemas robustos y flexibles.

