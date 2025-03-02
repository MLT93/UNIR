# Echo

---

## 🔹 **1. Comando Básico `echo`**

El comando `echo` se usa para imprimir texto en la salida estándar (generalmente la terminal). Es comúnmente usado en scripts y para mostrar información.

### **Sintaxis básica:**

```bash
echo "Texto a imprimir"
```

### **Ejemplo:**

```bash
echo "Hola, mundo"
```

✔ **Salida:**
```
Hola, mundo
```

📌 **Explicación**:
- Imprime el texto "Hola, mundo" en la terminal.

---

## 🔹 **2. Opción `-n` (No agregar salto de línea al final)**

Por defecto, `echo` agrega un salto de línea después del texto que imprime. La opción `-n` evita que esto ocurra.

### **Sintaxis:**

```bash
echo -n "Texto a imprimir"
```

### **Ejemplo:**

```bash
echo -n "Hola, "
echo "mundo"
```

✔ **Salida:**
```
Hola, mundo
```

📌 **Explicación**:
- Con `-n`, el primer `echo` imprime "Hola, " sin un salto de línea, y luego el segundo `echo` continúa en la misma línea, imprimiendo "mundo".

---

## 🔹 **3. Opción `-e` (Habilitar secuencias de escape)**

Por defecto, `echo` no interpreta caracteres de escape como `\n` o `\t`. Usando `-e`, habilitas el procesamiento de estas secuencias.

### **Sintaxis:**

```bash
echo -e "Texto con\n salto de línea"
```

### **Ejemplo:**

```bash
echo -e "Hola,\n\tMundo"
```

✔ **Salida:**
```
Hola,
    Mundo
```

📌 **Explicación**:
- `\n` agrega un salto de línea, y `\t` inserta un tabulador. La opción `-e` permite que estas secuencias de escape se interpreten correctamente.

---

## 🔹 **4. Opción `-E` (Deshabilitar secuencias de escape)**

Si el sistema tiene la opción `-e` habilitada por defecto (en algunas distribuciones de Linux), usar `-E` desactiva el procesamiento de las secuencias de escape.

### **Sintaxis:**

```bash
echo -E "Texto con\n salto de línea"
```

### **Ejemplo:**

```bash
echo -E "Hola,\n\tMundo"
```

✔ **Salida:**
```
Hola,\n    Mundo
```

📌 **Explicación**:
- Aunque se haya intentado usar las secuencias `\n` y `\t`, con `-E` `echo` las interpreta literalmente como texto y no como una secuencia de escape.

---

## 🔹 **5. Opción `--help` (Obtener ayuda)**

Puedes usar `--help` para obtener una breve descripción de las opciones disponibles en `echo`.

### **Sintaxis:**

```bash
echo --help
```

### **Ejemplo:**

```bash
echo --help
```

✔ **Salida:**
```
Uso: echo [OPCIÓN]... [STRING]...
Muestra una línea de texto.

  -n           No imprimir la nueva línea al final
  -e           Habilitar secuencias de escape
  -E           Deshabilitar secuencias de escape
  --help       Mostrar esta ayuda y salir
```

📌 **Explicación**:
- El comando `--help` proporciona información sobre cómo usar `echo` y las opciones que puedes aplicar.

---

## 🔹 **6. Usar variables con `echo`**

Puedes imprimir el valor de una variable utilizando `echo`. Esto es útil en scripts para mostrar resultados o el estado de una variable.

### **Sintaxis:**

```bash
echo "$variable"
```

### **Ejemplo:**

```bash
nombre="Juan"
echo "Hola, $nombre"
```

✔ **Salida:**
```
Hola, Juan
```

📌 **Explicación**:
- En este caso, `echo` imprime el valor de la variable `nombre`, que es "Juan".

---

## 🔹 **7. Usar comillas simples y dobles**

- **Comillas dobles (`"`)** permiten la expansión de variables y el uso de secuencias de escape.
- **Comillas simples (`'`)** evitan que las variables sean expandidas o las secuencias de escape sean interpretadas.

### **Sintaxis:**

```bash
echo "Texto con $variable"
echo 'Texto con $variable'
```

### **Ejemplo:**

```bash
nombre="Juan"
echo "Hola, $nombre"
echo 'Hola, $nombre'
```

✔ **Salida:**
```
Hola, Juan
Hola, $nombre
```

📌 **Explicación**:
- La primera línea usa comillas dobles, por lo que la variable `$nombre` es expandida a "Juan".
- La segunda línea usa comillas simples, por lo que `$nombre` se imprime literalmente, sin expansión.

---

## 🔹 **8. Usar `echo` para escribir en archivos**

Puedes redirigir la salida de `echo` a un archivo usando el operador `>` o `>>`. 

- **`>`** sobrescribe el archivo (si ya existe).
- **`>>`** agrega (concatena) el texto al final del archivo.

### **Sintaxis:**

```bash
echo "Texto" > archivo.txt   # Sobrescribe el archivo
echo "Más texto" >> archivo.txt  # Agrega al final del archivo
```

### **Ejemplo:**

```bash
echo "Este es un archivo" > archivo.txt
echo "Otro texto" >> archivo.txt
```

✔ **Salida en `archivo.txt`:**
```
Este es un archivo
Otro texto
```

📌 **Explicación**:
- La primera línea sobrescribe `archivo.txt` con el texto "Este es un archivo".
- La segunda línea agrega "Otro texto" al final del archivo.

---

## 🔹 **9. Comando `echo` con la variable especial `$?` (Último código de salida)**

La variable especial `$?` contiene el código de salida del último comando ejecutado. `0` generalmente significa que el comando se ejecutó correctamente, y cualquier otro número indica un error.

### **Sintaxis:**

```bash
echo "$?"
```

### **Ejemplo:**

```bash
ls archivo_inexistente
echo $?
```

✔ **Salida:**
```
ls: no se puede acceder a 'archivo_inexistente': No such file or directory
2
```

📌 **Explicación**:
- El comando `ls` falla al intentar acceder a un archivo inexistente, y `echo $?` muestra el código de salida `2`, que indica que hubo un error.

---

## 🚀 **Resumen rápido de `echo` y sus variantes**

| Comando | Descripción | Ejemplo |
|---------|-------------|---------|
| `echo` | Imprimir texto en la terminal | `echo "Hola, mundo"` |
| `echo -n` | No agregar salto de línea al final | `echo -n "Hola, "` |
| `echo -e` | Interpretar secuencias de escape | `echo -e "Hola,\n\tMundo"` |
| `echo -E` | Deshabilitar secuencias de escape | `echo -E "Hola,\n\tMundo"` |
| `echo --help` | Mostrar ayuda sobre las opciones de `echo` | `echo --help` |
| `echo "$variable"` | Imprimir valor de una variable | `echo "$nombre"` |
| `echo 'texto'` | Usar comillas simples para evitar expansión | `echo '$nombre'` |
| `echo > archivo.txt` | Sobrescribir un archivo con texto | `echo "Texto" > archivo.txt` |
| `echo >> archivo.txt` | Agregar texto al final de un archivo | `echo "Más texto" >> archivo.txt` |
| `echo $?` | Mostrar el código de salida del último comando | `echo $?` |

---

## 🎯 **Conclusión**

- **`echo`** es un comando básico pero esencial, utilizado para mostrar texto en la terminal, imprimir valores de variables y manejar archivos.
- La opción **`-e`** es útil para interpretar secuencias de escape como saltos de línea o tabuladores.
- Las opciones **`-n`** y **`-E`** son útiles para controlar cómo se imprimen los resultados, especialmente cuando trabajas con redirección de salida o en scripts.
