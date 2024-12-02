Para abordar la creación del modelo relacional basado en el enunciado proporcionado sobre la base de datos para películas y su ficha técnica, primero identificaremos las entidades y relaciones del problema, y luego desarrollaremos las tablas necesarias cumpliendo con las tres primeras formas normales.

---

## **Modelo Relacional Derivado del Diagrama E/R**

### **Identificación de entidades y relaciones**
Del enunciado se derivan las siguientes entidades y relaciones:

1. **Película**
   - **Atributos**: 
     - `titulo` (clave primaria, PK)
     - `año`
     - `nacionalidad`
     - `idioma`
     - `blanco_y_negro` (booleano)
     - `restriccion_edad`
     - `resumen`
     - `observaciones`

2. **Director**
   - **Atributos**:
     - `id_director` (PK, clave primaria, puede ser un identificador único generado)
     - `nombre_director`
     - `fecha_nacimiento`
     - `pais_origen`

   - Relación con **Película**: 
     - Una película tiene un único director, pero un director puede haber dirigido varias películas (**1:N**).

3. **Actor**
   - **Atributos**:
     - `id_actor` (PK)
     - `nombre_actor`
     - `nacionalidad`

   - Relación con **Película** (representa el reparto):
     - Un actor puede participar en varias películas y una película puede tener varios actores (**N:M**). En esta relación, también se almacena el **nombre del personaje** que el actor interpreta en la película.

---

### **Modelo Relacional**

#### **1. Tabla: `Peliculas`**
| **Atributo**         | **Tipo**         | **Descripción**                             |  
|----------------------|------------------|---------------------------------------------|  
| `titulo`             | VARCHAR(255)    | Clave primaria (nombre único de la película).|  
| `año`                | YEAR            | Año de producción.                          |  
| `nacionalidad`       | VARCHAR(100)    | Nacionalidad de la película.                |  
| `idioma`             | VARCHAR(50)     | Idioma original de la película.             |  
| `blanco_y_negro`     | BOOLEAN         | Indica si la película es en blanco y negro. |  
| `restriccion_edad`   | VARCHAR(10)     | Clasificación de edad (ejemplo: +18, APT).  |  
| `resumen`            | TEXT            | Descripción breve de la trama.              |  
| `observaciones`      | TEXT            | Notas personales sobre la película.         |  
| `id_director`        | INT             | Clave foránea que enlaza con `Directores`.  |  

**Clave primaria (PK):** `titulo`  
**Clave foránea (FK):** `id_director` → `Directores(id_director)`

#### **2. Tabla: `Directores`**
| **Atributo**         | **Tipo**         | **Descripción**                             |  
|----------------------|------------------|---------------------------------------------|  
| `id_director`        | INT AUTO_INCREMENT | Identificador único del director.           |  
| `nombre_director`    | VARCHAR(255)    | Nombre completo del director.               |  
| `fecha_nacimiento`   | DATE            | Fecha de nacimiento.                        |  
| `pais_origen`        | VARCHAR(100)    | País de origen del director.                |  

**Clave primaria (PK):** `id_director`  

#### **3. Tabla: `Actores`**
| **Atributo**         | **Tipo**         | **Descripción**                             |  
|----------------------|------------------|---------------------------------------------|  
| `id_actor`           | INT AUTO_INCREMENT | Identificador único del actor.              |  
| `nombre_actor`       | VARCHAR(255)    | Nombre completo del actor.                  |  
| `nacionalidad`       | VARCHAR(100)    | Nacionalidad del actor.                     |  

**Clave primaria (PK):** `id_actor`  

#### **4. Tabla: `Peliculas_Actores`**  
Esta tabla intermedia almacena la relación **N:M** entre películas y actores.

| **Atributo**         | **Tipo**         | **Descripción**                             |  
|----------------------|------------------|---------------------------------------------|  
| `id_actor`           | INT             | Clave foránea que enlaza con `Actores`.     |  
| `titulo`             | VARCHAR(255)    | Clave foránea que enlaza con `Peliculas`.   |  
| `nombre_personaje`   | VARCHAR(255)    | Nombre del personaje interpretado.          |  

**Clave primaria compuesta (PK):** `(id_actor, titulo)`  
**Claves foráneas (FK):**  
- `id_actor` → `Actores(id_actor)`  
- `titulo` → `Peliculas(titulo)`

---

### **Cumplimiento de las formas normales**

1. **Primera Forma Normal (1FN):**
   - Todos los atributos son atómicos y no contienen listas ni valores multivaluados.
   
2. **Segunda Forma Normal (2FN):**
   - Todas las tablas tienen claves primarias, y todos los atributos no clave dependen completamente de la clave primaria.  
     Ejemplo: En `Peliculas`, todos los atributos dependen de `titulo`.

3. **Tercera Forma Normal (3FN):**
   - No existen dependencias transitivas entre los atributos.  
     Ejemplo: La nacionalidad de un actor se almacena en `Actores` y no en `Peliculas_Actores`.

---

### **Esquema Relacional Simplificado**

```
Peliculas(titulo [PK], año, nacionalidad, idioma, blanco_y_negro, restriccion_edad, resumen, observaciones, id_director [FK])
Directores(id_director [PK], nombre_director, fecha_nacimiento, pais_origen)
Actores(id_actor [PK], nombre_actor, nacionalidad)
Peliculas_Actores(id_actor [PK, FK], titulo [PK, FK], nombre_personaje)
```

# Simplificación de pasos:

## **Paso 1: Identificación de entidades y relaciones en el diagrama E/R**

### **Entidades principales**
1. **Película**:
   - Representa las características básicas de cada película.
   - Atributos: título, año, nacionalidad, idioma, blanco y negro, restricción de edad, resumen, observaciones.

2. **Director**:
   - Contiene información sobre el director de una película.
   - Atributos: nombre, fecha de nacimiento, país de origen.
   - Relación con **Película**: Un director puede dirigir varias películas (**1:N**).

3. **Actor**:
   - Almacena información sobre los actores.
   - Atributos: nombre, nacionalidad.
   - Relación con **Película**: Un actor puede participar en varias películas y una película puede tener varios actores (**N:M**). En esta relación, se incluye el personaje que interpreta.

---

## **Paso 2: Conversión de Entidades a Tablas**

### **Tabla para cada entidad**
Cada entidad del diagrama E/R se convierte en una tabla con sus atributos como columnas. El atributo clave primaria (PK) se define para identificar de forma única cada fila en la tabla.

1. **Películas**:
   - Atributos:
     - `titulo`: PK, identifica de manera única cada película.
     - Otros atributos: año, nacionalidad, idioma, blanco_y_negro, restricción_edad, resumen, observaciones.

2. **Directores**:
   - Atributos:
     - `id_director`: PK, identificador único.
     - Otros atributos: nombre_director, fecha_nacimiento, pais_origen.
   - Relación **1:N** con **Películas**: Añadimos `id_director` como clave foránea (FK) en la tabla de **Películas**.

3. **Actores**:
   - Atributos:
     - `id_actor`: PK, identificador único.
     - Otros atributos: nombre_actor, nacionalidad.

4. **Relación Actores-Películas** (Reparto):
   - Esta relación **N:M** genera una tabla intermedia:
     - Atributos:
       - `id_actor`: FK hacia **Actores**.
       - `titulo`: FK hacia **Películas**.
       - `nombre_personaje`: atributo adicional para guardar el personaje que interpreta.

---

## **Paso 3: Normalización**

### **Primera Forma Normal (1FN):**
- Todos los atributos son atómicos: no contienen listas ni valores multivaluados.
- Las tablas cumplen con esta regla porque cada celda contiene un solo valor (por ejemplo, un actor tiene un único nombre).

### **Segunda Forma Normal (2FN):**
- Todos los atributos no clave dependen de la clave primaria completa.
- Ejemplo:
  - En **Películas**, todos los atributos dependen de `titulo`.
  - En la tabla intermedia **Peliculas_Actores**, el atributo `nombre_personaje` depende de la combinación de `id_actor` y `titulo` (clave primaria compuesta).

### **Tercera Forma Normal (3FN):**
- No existen dependencias transitivas.
- Ejemplo:
  - La nacionalidad de un actor se almacena en la tabla **Actores**, no en **Peliculas_Actores**, eliminando redundancia.

---

## **Paso 4: Tablas Relacionales (Esquema para la Base de Datos)**

### **1. Tabla `Peliculas`**
```sql
CREATE TABLE Peliculas (
    titulo VARCHAR(255) PRIMARY KEY,
    año YEAR,
    nacionalidad VARCHAR(100),
    idioma VARCHAR(50),
    blanco_y_negro BOOLEAN,
    restriccion_edad VARCHAR(10),
    resumen TEXT,
    observaciones TEXT,
    id_director INT,
    FOREIGN KEY (id_director) REFERENCES Directores(id_director)
);
```

### **2. Tabla `Directores`**
```sql
CREATE TABLE Directores (
    id_director INT AUTO_INCREMENT PRIMARY KEY,
    nombre_director VARCHAR(255),
    fecha_nacimiento DATE,
    pais_origen VARCHAR(100)
);
```

### **3. Tabla `Actores`**
```sql
CREATE TABLE Actores (
    id_actor INT AUTO_INCREMENT PRIMARY KEY,
    nombre_actor VARCHAR(255),
    nacionalidad VARCHAR(100)
);
```

### **4. Tabla `Peliculas_Actores` (Relación N:M)**
```sql
CREATE TABLE Peliculas_Actores (
    id_actor INT,
    titulo VARCHAR(255),
    nombre_personaje VARCHAR(255),
    PRIMARY KEY (id_actor, titulo),
    FOREIGN KEY (id_actor) REFERENCES Actores(id_actor),
    FOREIGN KEY (titulo) REFERENCES Peliculas(titulo)
);
```

---

## **Explicación de las Relaciones**

1. **Relación Director-Películas**:
   - Cada película está dirigida por un único director (`id_director` en `Peliculas` referencia a `Directores`).
   - Un director puede dirigir varias películas (relación **1:N**).

2. **Relación Actor-Películas**:
   - La relación **N:M** entre actores y películas se gestiona mediante la tabla `Peliculas_Actores`, que incluye las claves foráneas `id_actor` y `titulo`, y un atributo adicional `nombre_personaje`.

# Repaso de los conceptos

¡Claro! Aquí tienes el proceso completo de normalización desde la **Primera Forma Normal (1FN)** hasta la **Sexta Forma Normal (6FN)**, actualizando el esquema final para cada tabla, con todos los campos correspondientes.

---

## **Paso 1: Normalización hasta la Tercera Forma Normal (3FN)**

### **Problema Inicial:**
Tenemos una tabla desorganizada con redundancias y valores no atómicos:

| **titulo**    | **año** | **director**      | **actor**             | **personaje** | **restriccion** |
|---------------|---------|------------------|-----------------------|---------------|-----------------|
| Titanic       | 1997    | James Cameron    | Leonardo DiCaprio     | Jack Dawson   | PG-13           |
| Titanic       | 1997    | James Cameron    | Kate Winslet          | Rose Dewitt   | PG-13           |
| Avatar        | 2009    | James Cameron    | Sam Worthington       | Jake Sully    | PG-13           |

---

### **Primera Forma Normal (1FN):**
**Regla principal:** Todos los atributos deben ser atómicos.

- Observamos que todos los valores ya son atómicos. Cumplimos la **1FN**.

---

### **Segunda Forma Normal (2FN):**
**Regla principal:** No debe haber dependencias parciales; cada atributo no clave depende completamente de la clave primaria.

En la tabla inicial, la clave primaria podría ser `(titulo, actor)`. Sin embargo, atributos como `director` y `restriccion` dependen solo de `titulo`, lo que viola la **2FN**.

- Solución: Dividimos la tabla en dos:
  - `Peliculas`: Información básica sobre cada película.
  - `Reparto`: Relación entre películas y actores.

**Tabla Peliculas:**
| **titulo**    | **año** | **director**      | **restriccion** |
|---------------|---------|------------------|-----------------|
| Titanic       | 1997    | James Cameron    | PG-13           |
| Avatar        | 2009    | James Cameron    | PG-13           |

**Tabla Reparto:**
| **titulo**    | **actor**             | **personaje** |
|---------------|-----------------------|---------------|
| Titanic       | Leonardo DiCaprio     | Jack Dawson   |
| Titanic       | Kate Winslet          | Rose Dewitt   |
| Avatar        | Sam Worthington       | Jake Sully    |

---

### **Tercera Forma Normal (3FN):**
**Regla principal:** No debe haber dependencias transitivas.

En la tabla `Peliculas`, si el atributo `director` tiene información adicional, como su nacionalidad, habría una dependencia transitiva (el director dependería del título de la película). Para solucionarlo, creamos una tabla adicional:

**Tabla Directores:**
| **id_director** | **nombre_director** | **nacionalidad** |
|-----------------|---------------------|------------------|
| 1               | James Cameron       | Canadá           |

**Tabla Peliculas** (actualizada):
| **titulo**    | **año** | **id_director** | **restriccion** |
|---------------|---------|-----------------|-----------------|
| Titanic       | 1997    | 1               | PG-13           |
| Avatar        | 2009    | 1               | PG-13           |

**Relaciones:**  
- `Peliculas` tiene una FK hacia `Directores`.

Ahora, todas las dependencias están bien definidas. Cumplimos la **3FN**.

---

## **Paso 2: Normalización a la Cuarta Forma Normal (4FN)**

**Regla principal:** No debe haber dependencias multivaluadas no relacionadas.

Supongamos que queremos añadir idiomas en los que se lanzó cada película:

| **titulo**    | **idioma**  | **actor**             |
|---------------|------------|-----------------------|
| Titanic       | Inglés     | Leonardo DiCaprio     |
| Titanic       | Español    | Kate Winslet          |

Aquí, `idioma` no depende de `actor`. Esto genera redundancia.

- **Solución:** Creamos una tabla para los idiomas:

**Tabla Idiomas:**
| **titulo**    | **idioma**  |
|---------------|------------|
| Titanic       | Inglés     |
| Titanic       | Español    |
| Avatar        | Inglés     |

Eliminamos la redundancia. Cumplimos la **4FN**.

---

## **Paso 3: Normalización a la Quinta Forma Normal (5FN)**

**Regla principal:** Eliminamos dependencias de unión, dividiendo relaciones complejas en relaciones más simples.

En la tabla `Reparto`, la relación entre `actor`, `titulo` y `personaje` es compleja. Podemos dividirla en tres tablas:

**Tabla Actores-Películas:**
| **actor**             | **titulo**    |
|-----------------------|---------------|
| Leonardo DiCaprio     | Titanic       |
| Kate Winslet          | Titanic       |
| Sam Worthington       | Avatar        |

**Tabla Películas-Personajes:**
| **titulo**    | **personaje** |
|---------------|---------------|
| Titanic       | Jack Dawson   |
| Titanic       | Rose Dewitt   |
| Avatar        | Jake Sully    |

**Tabla Actores-Personajes:**
| **actor**             | **personaje** |
|-----------------------|---------------|
| Leonardo DiCaprio     | Jack Dawson   |
| Kate Winslet          | Rose Dewitt   |
| Sam Worthington       | Jake Sully    |

Ahora las relaciones están completamente descompuestas. Cumplimos la **5FN**.

---

## **Paso 4: Normalización a la Sexta Forma Normal (6FN)**

**Regla principal:** Separamos los datos temporales en tablas independientes.

1. **Restricciones de edad (temporales):**
   | **titulo**    | **pais**  | **restriccion** | **fecha_inicio** | **fecha_fin** |
   |---------------|----------|-----------------|------------------|---------------|
   | Titanic       | EEUU      | PG-13           | 1997-12-19       | NULL          |
   | Titanic       | España    | 13+             | 1998-01-01       | NULL          |

2. **Directores (cambios temporales):**
   | **id_director** | **nacionalidad** | **fecha_inicio** | **fecha_fin** |
   |-----------------|------------------|------------------|---------------|
   | 1               | Canadá           | 1955-01-01       | NULL          |

---

### **Esquema Final:**

Aquí está el esquema final, con las tablas detalladas y los campos actualizados:

- **Peliculas**:
  | **titulo**    | **año** | **id_director** | **restriccion** |
  |---------------|---------|-----------------|-----------------|
  | Titanic       | 1997    | 1               | PG-13           |
  | Avatar        | 2009    | 1               | PG-13           |

- **Directores_Temporal**:
  | **id_director** | **nacionalidad** | **fecha_inicio** | **fecha_fin** |
  |-----------------|------------------|------------------|---------------|
  | 1               | Canadá           | 1955-01-01       | NULL          |

- **Actores**:
  | **id_actor**   | **nombre_actor**    | **nacionalidad** |
  |----------------|---------------------|------------------|
  | 1              | Leonardo DiCaprio    | EEUU             |
  | 2              | Kate Winslet         | Reino Unido      |

- **Peliculas_Actores**:
  | **id_actor**   | **titulo**    |
  |----------------|---------------|
  | 1              | Titanic       |
  | 2              | Titanic       |
  | 3              | Avatar        |

- **Peliculas_Personajes**:
  | **titulo**     | **nombre_personaje** |
  |----------------|----------------------|
  | Titanic        | Jack Dawson          |
  | Titanic        | Rose Dewitt          |
  | Avatar         | Jake Sully           |

- **Actores_Personajes**:
  | **id_actor**   | **nombre_personaje** |
  |----------------|----------------------|
  | 1              | Jack Dawson          |
  | 2              | Rose Dewitt          |
  | 3              | Jake Sully           |

- **Restricciones_Temporales**:
  | **titulo**     | **pais**   | **restriccion** | **fecha_inicio** | **fecha_fin** |
  |----------------|-----------|-----------------|------------------|---------------|
  | Titanic        | EEUU      | PG-13           | 1997-12-19       | NULL          |
  | Titanic        | España    | 13+             | 1998-01-01       | NULL          |

---

Este esquema final cumple con la **Sexta Forma Normal (6FN)**, asegurando que los datos estén organizados de manera eficiente, especialmente aquellos que varían con el tiempo, y eliminando redundancias para una mayor flexibilidad.
